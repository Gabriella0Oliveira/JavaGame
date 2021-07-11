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

    }

    public void move(){

    }

    public void shoot(){

    }
}
