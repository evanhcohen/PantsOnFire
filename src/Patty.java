import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Patty extends JComponent
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



}
