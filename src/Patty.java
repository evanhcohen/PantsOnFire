import javax.swing.*;
import java.awt.*;

public class Patty extends JComponent

{
    // instance variables
    private int lives;

    // constructor
    public Patty()
    {
        lives = 3;
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(30,30,80,80);
    }



                      // accessors
    public int getLives()
    {
        return lives;
    }



}
