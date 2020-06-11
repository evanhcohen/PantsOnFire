import javax.swing.*;

public class WinFrame extends MainFrame
{
    private static JFrame frame;
    private static WinPanel win;

    public WinFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.setUndecorated(true);

        // creates panel
        win = new WinPanel();
        win.setPreferredSize(d);

        // add panel to the frame
        frame.getContentPane().add(win);
    }

    public static void changePanel(int x)
    {
        if (x == 4)
        {
            display(frame);
        }
        else
        {
            frame.setVisible(false);
        }
    }
}
