import javax.swing.*;
import java.awt.*;

public class SpaceGame extends JPanel implements Runnable {

    Spaceship spaceship;

    public SpaceGame() {

        spaceship = new Spaceship();

        Thread game = new Thread(this);
        game.start();  //this will call run() method
    }

    public void run() {
        //noinspection InfiniteLoopStatement
        while(true){
            update();
            repaint();
            sleep();
        }
    }

    private void update() {
        //System.out.println("updating"); // just checking if it updates
    }

    @Override
    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);

        Graphics2D g = (Graphics2D) g2.create();

        spaceship.paint(g);

        /*g.setColor(Color.white);
        g.fillRect(0,0,50,50); testing */
    }

    private void sleep() {
    }

}
