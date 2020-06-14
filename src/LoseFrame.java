import javax.swing.*;

public class LoseFrame extends MainFrame
{
    private static JFrame frame;
    private static LosePanel lose;

    public LoseFrame()
    {
        createFrame();
        frame.dispose();
    }

    // helps with screen swapping
    public static void changePanel(int x)
    {
        if (x == 5)
        {
            createFrame();
            display(frame);
        }
        else
        {
            frame.dispose();
        }
    }

    public static void createFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // locks frame size
        frame.setResizable(false);
        // removes title-bar
        frame.setUndecorated(true);

        // creates panel
        lose = new LosePanel();
        lose.setPreferredSize(d);

        // add panel to the frame
        frame.getContentPane().add(lose);
    }
}
