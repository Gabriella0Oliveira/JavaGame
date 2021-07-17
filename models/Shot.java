package models;

import models.Enemy;

import java.awt.*;

public class Shot {

    private final int x;
    private int y;
    private final int speed;
    private int sizeX = 5;
    private int sizeY = 15;


    public Shot(int X, int Y){
        this.x = X;
        this.y = Y;
        speed = 10;
    }

    public void paint(Graphics2D g){
        g.setColor(Color.yellow);
        g.fillRect(x,y,5,15);
    }

    public void update() {
        y -= speed;
    }

    public boolean destroy() {
        return y < 0;
    }

    public boolean isColliding(Enemy enemy) {

        if( x >= enemy.getX() && x + sizeX <= enemy.getX() + enemy.getSize()) {
            return y <= enemy.getY() + enemy.getSize();
        }
        return false;
    }
}