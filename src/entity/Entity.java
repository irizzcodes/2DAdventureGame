package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage left1, left2, left3, left4 , left5, left6, left7, left8;
    public BufferedImage right1, right2, right3, right4, right5, right6, right7, right8;
    public BufferedImage up1;
    public BufferedImage down1;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
