import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceGame extends JPanel implements Runnable, KeyListener {

    Spaceship spaceship;
    private int direction = 0;

    public SpaceGame() {

        spaceship = new Spaceship();

        Thread game = new Thread(this);
        game.start();  //this will call run() method
    }

    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            update();
            repaint();
            sleep();
        }
    }

    private void update() {
        spaceship.move(direction);
        //System.out.println("updating"); // just checking if it updates
    }


    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);

        Graphics2D g = (Graphics2D) g2.create();

        spaceship.paint(g);

        /*g.setColor(Color.white);
        g.fillRect(0,0,50,50); testing */
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT || keyEvent.getKeyCode() == KeyEvent.VK_D) {
            //System.out.println("test a");
            direction = 1;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT || keyEvent.getKeyCode() == KeyEvent.VK_A) {
            //System.out.println("test b");
            direction = -1;
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT || keyEvent.getKeyCode() == KeyEvent.VK_D){
            //System.out.println("test c");
            direction=0;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT || keyEvent.getKeyCode() == KeyEvent.VK_A){
            //System.out.println("test d");
            direction=0;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT || keyEvent.getKeyCode() == KeyEvent.VK_D){
            //System.out.println("test e");
            direction = 1;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT || keyEvent.getKeyCode() == KeyEvent.VK_A){
            //System.out.println("test f");
            direction = -1;
        }

    }
}