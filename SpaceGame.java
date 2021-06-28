import javax.swing.*;

public class SpaceGame extends JPanel implements Runnable {

    public SpaceGame() {
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
        System.out.println("updating"); // just checking if it updates
    }

    private void sleep() {
    }

}
