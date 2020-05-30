import javax.swing.*;
import java.awt.*;

public class Patty extends JComponent

{
    // instance variables
    private int lives;
    private int locX;
    private int locY;

    // constructor
    public Patty()
    {
        lives = 3;
        locX = 30;
        locY = 30;
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(locX,locY,80,80);
    }

    public void repaint(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(locX,locY,80,80);
    }


    // mutators
    public void changeX(int x)
    {
        locX = x;
    }

    public void changeY(int y)
    {
        locY = y;
    }


    // accessors
    public int getLives()
    {
        return lives;
    }



}
