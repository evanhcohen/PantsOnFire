import javax.swing.*;

public class PauseFrame extends MainFrame
{
    private static JFrame frame;
    private static PausePanel pause;

    public PauseFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // locks frame size
        frame.setResizable(false);
        // removes title-bar
        frame.setUndecorated(true);

        // creates panel
        pause = new PausePanel();
        pause.setPreferredSize(d);

        // add panel to the frame
        frame.getContentPane().add(pause);
    }

    // helps with screen swapping
    public static void changePanel(int x)
    {
        if (x == 6)
        {
            display(frame);
        }
        else
        {
            frame.setVisible(false);
        }
    }
}
