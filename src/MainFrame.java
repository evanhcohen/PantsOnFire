import javax.swing.*;

public class MainFrame extends JFrame
{
    private static int frameNum;

    // shows the frame
    public static void display(JFrame f)
    {
        f.pack();
        f.setLocation(0,0);
        f.setVisible(true);
    }

}

