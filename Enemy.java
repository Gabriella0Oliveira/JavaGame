import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy {

    private BufferedImage image;
    private int x;
    private int y;
    private int speed;
    private int direction;


    public Enemy() {

        x = 400;
        speed = 2;

        try {
            image = ImageIO.read(new File("images/enemy.png"));
        } catch (IOException e) {
            System.out.println("couldn't load image");
            e.printStackTrace();
        }

    }

    public void paint(Graphics2D g) {
    }

    public void move() {
    }

    public void setDirection() {
    }
}