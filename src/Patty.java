import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Patty extends JPanel implements ActionListener, KeyListener
{
    // instance variables
    private int lives;

    // constructor
    public Patty()
    {
        lives = 3;
    }

    // accessors
    public int getLives()
    {
        return lives;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
