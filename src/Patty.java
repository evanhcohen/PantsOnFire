import javax.swing.*;
import java.awt.*;


public class Patty extends JComponent
{
    // instance variables
    private int lives;
    private static int locX;
    private static int locY;
    private int changeX = 0;
    private int changeY = 0;

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

    // accessors
    public int getLives()
    {
        return lives;
    }


    //mutators
    public static void changeLocX(int x)
    {
        locX += x;
    }
    public static void changeLocY(int y)
    {
        locY += y;
    }
    public void repaint()
    {
        repaint();
    }
}
