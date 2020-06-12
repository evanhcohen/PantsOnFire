import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Patty extends JComponent
{
    // current location
    private int locX;
    private int locY;
    // starting location
    private int startX;
    private int startY;
    // width, height
    private int width;
    private int height;
    // image for object appearance
    private Image img;

    // constructor
    public Patty(int x, int y, int w, int h)
    {
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
        // if player is dead, set x to start location, otherwise change by the inputted amount
        if (GamePanel.isDead())
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
        // if player is dead, set y to start location, otherwise change by the inputted amount
        if (GamePanel.isDead())
        {
            locY = startY;
        }
        else
        {
            locY += y;
        }
    }
}
