package models;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {

    private BufferedImage image;
    private int x;
    private int y;
    private int speed;
    private int direction;


    public Enemy(BufferedImage image, int X, int Y, int direction) {

        this.x = X;
        this.y = Y;
        this.direction = direction;
        this.speed = 1;
        this.image = image;

    }

    public void paint(Graphics2D g) {
        g.drawImage(image,x,y,x + 50 , y + 50, 0, 0,image.getWidth(),image.getHeight(),null );

    }

    public void update(){
        x += speed * direction;
    }

    public void setDirection() {
        direction = direction * -1 ;
        y += 15;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public int getSize(){
        return 50;
    }
}