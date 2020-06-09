import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Platform extends JComponent {

    //instance variables
    private int locX;
    private int locY;
    private int changeX = 0;
    private int changeY = 0;
    private Image img;

    //constructor
    public Platform(int x, int y)
    {
        locX = x;
        locY = y;
    }

    //accessors
    public int getLocX()
    {
        return locX;
    }
    public int getLocY()
    {
        return locY;
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


    public Image getImg(int w, int h)
    {
        return img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }


    public void touching()
    {
        Patty p = GamePanel.getP();



    }

}
