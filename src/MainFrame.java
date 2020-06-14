import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    // some variables used throughout the program
    protected static int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    protected static int height = 500;
    protected static Dimension d = new Dimension(width,height);

    // shows the frame
    public static void display(JFrame f)
    {
        f.pack();
        f.setLocation(0,0);
        f.setVisible(true);
    }

    // screen swapping mechanism
    public static void swapScreen(int n)
    {
        GameFrame.changePanel(n);
        InstructionsFrame.changePanel(n);
        MenuFrame.changePanel(n);
        WinFrame.changePanel(n);
        LoseFrame.changePanel(n);
        PauseFrame.changePanel(n);
    }
}

