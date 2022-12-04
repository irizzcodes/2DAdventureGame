package entity;

import com.main.GamePanel;
import com.main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public  Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "left";
    }

    public void getPlayerImage(){
        try{
            //UP
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_left_1.png"));
            //DOWN
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_right_1.png"));
            //LEFT
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_left_2.png"));
            left3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_left_3.png"));
            left4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_left_4.png"));
            left5 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_left_5.png"));
            left6 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_left_6.png"));
            left7 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_left_7.png"));
            left8 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_left_8.png"));
            //RIGHT
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_right_2.png"));
            right3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_right_3.png"));
            right4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_right_4.png"));
            right5 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_right_5.png"));
            right6 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_right_6.png"));
            right7 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_right_7.png"));
            right8 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_right_8.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed == true) {
                direction = "up";
                y -= speed; // playerY = playerY - playerSpeed
            } else if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
            } else if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;
            } else if (keyH.rightPressed == true) {
                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if (spriteCounter > 9) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 5;
                } else if (spriteNum == 5) {
                    spriteNum = 6;
                } else if (spriteNum == 6) {
                    spriteNum = 7;
                } else if (spriteNum == 7) {
                    spriteNum = 8;
                } else if (spriteNum == 8) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else if (direction == "left" && !keyH.upPressed){
            spriteCounter++;
            if (spriteCounter > 14) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                } else if (spriteNum == 3) {
                    spriteNum = 1;
                } else if (spriteNum == 4) {
                    spriteNum = 1;
                } else if (spriteNum == 5) {
                    spriteNum = 1;
                } else if (spriteNum == 7) {
                    spriteNum = 1;
                } else if (spriteNum == 8) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else if (direction == "right" && !keyH.upPressed){
            spriteCounter++;
            if (spriteCounter > 14) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                } else if (spriteNum == 3) {
                    spriteNum = 1;
                } else if (spriteNum == 4) {
                    spriteNum = 1;
                } else if (spriteNum == 5) {
                    spriteNum = 1;
                } else if (spriteNum == 7) {
                    spriteNum = 1;
                } else if (spriteNum == 8) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white); color of rectangle
        //g2.fillRect(x,y,gp.tileSize,gp.tileSize); rectangle

        BufferedImage image = null;
        switch(direction){
            case "up":
                if(spriteNum == 1) {
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up1;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    image = down1;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                if(spriteNum == 3) {
                    image = left3;
                }
                if(spriteNum == 4) {
                    image = left4;
                }
                if(spriteNum == 5) {
                    image = left5;
                }
                if(spriteNum == 6) {
                    image = left6;
                }
                if(spriteNum == 7) {
                    image = left7;
                }
                if(spriteNum == 8) {
                    image = left8;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                if(spriteNum == 3) {
                    image = right3;
                }
                if(spriteNum == 4) {
                    image = right4;
                }
                if(spriteNum == 5) {
                    image = right5;
                }
                if(spriteNum == 6) {
                    image = right6;
                }
                if(spriteNum == 7) {
                    image = right7;
                }
                if(spriteNum == 8) {
                    image = right8;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
}
