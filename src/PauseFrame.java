import javax.swing.*;

public class PauseFrame extends MainFrame
{
    private static JFrame frame;
    private static PausePanel pause;

    public PauseFrame()
    {
        createFrame();
        frame.dispose();
    }

    // helps with screen swapping
    public static void changePanel(int x)
    {
        if (x == 6)
        {
            createFrame();
            display(frame);
        }
        else
        {
            frame.setVisible(false);
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
        pause = new PausePanel();
        pause.setPreferredSize(d);

        // add panel to the frame
        frame.getContentPane().add(pause);
    }
}
