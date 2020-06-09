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
    private int changeX = 0;
    private int changeY = 0;
    private Image img;
    private boolean isFalling;

    // constructor
    public Patty(int x, int y)
    {
        lives = 3;
        locX = x;
        locY = y;
    }


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

    public void drawImg()
    {
        URL resource = getClass().getResource("images/square.jpg");
        try {
            img = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getImg(int w, int h)
    {
        return img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
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
        locY += 1;
    }

}
