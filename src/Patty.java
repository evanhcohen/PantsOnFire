import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Patty extends JComponent
{
    // instance variables
    private int lives;
    private int locX;
    private int locY;
    private int startX;
    private int startY;
    private int width;
    private int height;
    private Image img;

    // constructor
    public Patty(int x, int y, int w, int h)
    {
        lives = 3;
        locX = x;
        locY = y;
        startX = x;
        startY = y;
        width = w;
        height = h;
    }

    public int getLocX()
    {
        return locX;
    }
    public int rightBoundX()
    {
        return locX + width;
    }

    public int getLocY()
    {
        return locY;
    }
    public int getBottomY()
    {
        return locY + height;
    }

    public int getLives()
    {
        return lives;
    }

    public void drawImg()
    {
        try {
            img = ImageIO.read(getClass().getResource("images/square.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getImg()
    {
        return img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public void changeX(int x)
    {
        if (GamePanel.isDead())
        {
            locX = startX;
        }
        else if (GamePanel.isDead())
        {
            locX = startX;
        }
        else
        {
            locX += x;

        }
    }

    public void changeY(int y)
    {
        if (GamePanel.isDead())
        {
            locY = startY;
        }
        else
        {
            locY += y;
        }
    }

    public void fall()
    {
        locY += 4;
    }

}
