import javax.swing.*;

public class WinFrame extends MainFrame
{
    private static JFrame frame;
    private static WinPanel win;

    public WinFrame()
    {
        createFrame();
        frame.dispose();
    }

    // helps with screen swapping
    public static void changePanel(int x)
    {
        if (x == 4)
        {
            createFrame();
            display(frame);
        }
        else
        {
            frame.dispose();
        }
    }

    private static void createFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // locks frame size
        frame.setResizable(false);
        // removes title-bar
        frame.setUndecorated(true);

        // creates panel
        win = new WinPanel();
        win.setPreferredSize(d);

        // add panel to the frame
        frame.getContentPane().add(win);
    }

}
