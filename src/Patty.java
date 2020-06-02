import javax.swing.*;


public class Patty extends JComponent
{
    // instance variables
    private int lives;
    private int locX;
    private int locY;
    private int changeX = 0;
    private int changeY = 0;

    // constructor
    public Patty()
    {
        lives = 3;
        locX = 30;
        locY = 30;
    }

//    public void paintComponent(Graphics g)
//    {
//        g.setColor(Color.red);
//        g.fillRect(locX,locY,80,80);
//    }

    public int getLocX()
    {
        return locX;
    }
    public int getLocY()
    {
        return locY;
    }
    public int getLives()
    {
        return lives;
    }

    public void changeX(int x)
    {
        locX += x;
    }
    public void changeY(int y)
    {
        locY += y;
    }
    public void repaint()
    {
        repaint(locX,locY,80,80);
        System.out.println("repaint");
    }
}
