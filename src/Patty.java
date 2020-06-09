import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;


public class Patty extends JComponent
{
    // instance variables
    private int lives;
    private int locX;
    private int locY;
    private int width;
    private int height;
    private int changeX = 0;
    private int changeY = 0;
    private Image img;
    private boolean isFalling;

    // constructor
    public Patty(int x, int y, int w, int h)
    {
        lives = 3;
        locX = x;
        locY = y;
        width = w;
        height = h;
    }

    public int getLocX()
    {
        return locX;
    }
    public int getRightX()
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
        URL resource = getClass().getResource("images/square.jpg");
        try {
            img = ImageIO.read(resource);
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
        locX += x;
    }

    public void changeY(int y)
    {
        locY += y;
    }

    public void changeFallStatus(boolean status)
    {
        isFalling = status;
    }


    public void gravity()
    {
        locY += 1;
        locY += 1;
        locY += 1;
        locY += -1;
        locY += -1;
        locY += -1;
    }

    public void fall()
    {
        locY += 4;
    }

}
