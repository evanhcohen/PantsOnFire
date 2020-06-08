import java.awt.*;

public class Platform {

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

}
