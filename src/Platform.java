import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Platform extends JComponent {

    //instance variables
    private int locX;
    private int locY;
    private int width;
    private int height;
    private int changeX = 0;
    private int changeY = 0;
    private Image img;

    //constructor
    public Platform(int x, int y)
    {
        locX = x;
        locY = y;
        width = 80;
        height = 30;
    }

    //accessors
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



    public void drawImg()
    {
        URL resource = getClass().getResource("images/platform.png");
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


    public boolean touching()
    {
        Patty p = GamePanel.getP();

        if (p.getLocX() < this.getRightX() && p.getRightX() > this.getLocX() && p.getBottomY() == this.getLocY())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
