package models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Spaceship {

    private BufferedImage image;
    private int x; //position
    private int speed;

    public Spaceship(){

        x = 600;
        speed = 5;

        try{
            image = ImageIO.read(new File("images/spaceship.png"));
        } catch (Exception e) {
            System.out.println("couldn't load image");
            e.printStackTrace();
        }
    }

    public void paint(Graphics2D g){
        g.drawImage(image,x,550,x+ 100 , 650, 0, 0,image.getWidth(),image.getHeight(),null );
    }

    public void move(int direction){
        if(direction == 1) {
            x += speed;
        } else if (direction == -1) {
            x -= speed;
        }
    }

    public Shot shoot(){
        Shot shots;
        shots = new Shot(x+49, 550);
        return shots;
    }
}
