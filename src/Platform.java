import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Platform extends JComponent {

    //instance variables
    private int locX;
    private int locY;
    private int width;
    private int height;
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
    public int leftBoundX()
    {
        return locX;
    }
    public int rightBoundX()
    {
        return locX + width;
    }
    public int topY()
    {
        return locY;
    }
    public int bottomY()
    {
        return locY + height;
    }

    public void drawImg()
    {
        try {
            img = ImageIO.read(getClass().getResource("images/platform.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getImg()
    {
        return img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public boolean touching(Patty p)
    {
        // checks right, left, then bottom of patty; checks left, right, then top of platform
        return (p.getLocX() < this.rightBoundX() && p.rightBoundX() > this.leftBoundX() && p.getBottomY() == this.topY());
    }

}
