import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SpaceGame extends JPanel implements Runnable, KeyListener {

    Spaceship spaceship;
    private int direction = 0;
    private final ArrayList<Shot> shots;
    private final ArrayList<Enemy> enemies;

    public SpaceGame() {

        spaceship = new Spaceship();
        enemies = new ArrayList<>();
        shots = new ArrayList<>();

        BufferedImage enemyImage = null;
        try {
            enemyImage = ImageIO.read(new File("images/enemy.png"));
        } catch (IOException e) {
            System.out.println("couldn't load image");
            e.printStackTrace();
        }

        for (int i = 0; i < 40; i++) {
            enemies.add(new Enemy(enemyImage, 50 + i % 10 * 75,  i / 10 * 75, 1));
        }

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
        for (int i = 0; i < shots.size(); i++) {
            shots.get(i).update();

            if (shots.get(i).destroy()) {
                shots.remove(i);
                i--;
            }
        }

        for (Enemy value : enemies) {
            value.update();
        }

        for (int i = 0; i < enemies.size(); i++) {

            if (enemies.get(i).getX() <= 0 || enemies.get(i).getX() >= 1200-50) {

                for (Enemy value : enemies) {
                    value.setDirection();
                }
                break; //break will cause them to change direction only once in the loop.
            }

        }
    }


    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);

        Graphics2D g = (Graphics2D) g2.create();

        spaceship.paint(g);

        for (Shot shot : shots) {
            shot.paint(g);
        }

        for (Enemy value : enemies) {
            value.paint(g);
        }

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
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER || keyEvent.getKeyCode() == KeyEvent.VK_S) {
            //System.out.println("shoot");
            shots.add(spaceship.shoot());
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