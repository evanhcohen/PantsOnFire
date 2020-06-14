import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    // some variables used throughout the program
    protected static int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    protected static int height = width/3;
    protected static Dimension d = new Dimension(width,height);
    private static int currentScreen = 1;
    private static int lastScreen = 0;


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
        lastScreen = currentScreen;
        currentScreen = n;
        GameFrame.changePanel(n);
        InstructionsFrame.changePanel(n);
        MenuFrame.changePanel(n);
        WinFrame.changePanel(n);
        LoseFrame.changePanel(n);
        PauseFrame.changePanel(n);
    }

    public static int getLastScreen()
    {
        return lastScreen;
    }
}

