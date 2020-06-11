import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    protected static int width = 1500;
    protected static int height = 500;
    Dimension d = new Dimension(width,height);

    // shows the frame
    public static void display(JFrame f)
    {
        f.pack();
        f.setLocation(0,0);
        f.setVisible(true);
    }
}

