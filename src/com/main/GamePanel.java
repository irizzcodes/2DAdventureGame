package com.main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

// function as game screen
public class GamePanel extends JPanel implements Runnable{
    //Screen Settings
    final int originalTileSize = 32; // this is 32x32 tile
    final int scale = 2; // scale our 32x32, to make it larger on screen
    public final int tileSize = originalTileSize * scale; // this is now the actual tile size

    // 4x3 ratio
    public final int maxScreenCol = 16;
    public final int maxscreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxscreenRow; // 576 pixels

    // Frame per second
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // to repeat process again and again every 1 second
    Player player = new Player(this,keyH);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    /* !!!!!!!!!!!!!!!!!!!!!!!!! THREAD SLEEP METHOD !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; // precise calculation, dividing nanoseconds by FPS, 1 billion ns = 1 sec
        double nextDrawTime = System.nanoTime() + drawInterval;
        // System.nanoTime() = return current value of JVM High-R time source in nanoseconds

        while (gameThread != null){
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000; // because sleep only accepts milliseconds

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime); // to do nothing while waiting for the next loop

                nextDrawTime += drawInterval;
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
     */

    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        // for variables to display FPS
        long timer = 0;
        int drawCount = 0;


        while (gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                // Update information for character position
                update();
                // Update information for the screen
                repaint();
                delta--;
                drawCount++;
            }

            // to display FPS
            if (timer >= 1000000000){
                System.out.println("FPS: "+ drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }



    public void update(){
        player.update();


    }

    // Note!! Graphics class has many functions to draw objects on screen
    public void paintComponent(Graphics g){
        super.paintComponent(g); // super for the parent class of this class

        // Graphics2D extends the Graphic Class  to provide more control coordinate, color, text layout
        Graphics2D g2 = (Graphics2D)g; // we change graphic g to graphic 2d class
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();

    }
}
