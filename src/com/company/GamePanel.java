package com.company;

import javax.swing.*;
import java.awt.*;

// function as game screen
public class GamePanel extends JPanel implements Runnable{
    //Screen Settings
    final int originalTileSize = 16; // this is 16x16 tile
    final int scale = 3; // scale our 16x16, to make it larger on screen
    final int tileSize = originalTileSize * scale; // this is now the actual tile size

    // 4x3 ratio
    final int maxScreenCol = 16;
    final int maxscreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxscreenRow; // 576 pixels

    Thread gameThread; // to repeat process again and again every 1 second

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

    }
}
