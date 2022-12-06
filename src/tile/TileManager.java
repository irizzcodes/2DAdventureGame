package tile;

import com.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    Tile[] tile;
    int mapTileNumber[][];

    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[10];
        mapTileNumber = new int[gp.maxScreenCol][gp.maxscreenRow];

        getTileImage();
        loadMap("maps/map01.txt");

    }

    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png"));

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){

        try{
            InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxscreenRow){
                String line = br.readLine();

                while (col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol){
                    col=0;
                    row++;
                }


            }
            br.close();

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    public void draw(Graphics2D g2){
        //g2.drawImage(tile[0].image,0,0,gp.tileSize, gp.tileSize, null); // for individual
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxscreenRow){

            int tileNum = mapTileNumber[col][row];

            g2.drawImage(tile[tileNum].image,x,y,gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol){
                col=0;
                x=0;
                row++;
                y += gp.tileSize;
            }
        }

    }
}