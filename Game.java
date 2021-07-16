import javax.swing.*;
import java.awt.*;

public class Game {

    public static void main(String[] args) {

        JFrame window = new JFrame("Space Invaders"); //Constructor
        //methods:
        window.setIconImage(new ImageIcon("images/icon.png").getImage()); //trying to set an icon
        window.setSize(1200,700);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        // window.setBackground(Color.BLACK); //trying to set the background color.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits game when window close.

        SpaceGame spaceInvaders = new SpaceGame();
        spaceInvaders.setBounds(0,0,1200,700);
        spaceInvaders.setBackground(Color.BLACK); // Ok, I think it makes more sense to put the background here

        window.add(spaceInvaders);
        window.addKeyListener(spaceInvaders);

        window.setVisible(true);
    }
}