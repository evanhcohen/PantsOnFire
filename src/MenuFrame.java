import javax.swing.*;

public class MenuFrame extends MainFrame
{
    private static JFrame frame;
    private static MenuPanel menu;

    public MenuFrame()
    {
        createFrame();
    }

    public static JFrame getFrame()
    {
        return frame;
    }

    // helps with screen swapping
    public static void changePanel(int x)
    {
        if(x == 1)
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
        menu = new MenuPanel();
        menu.setPreferredSize(d);

        // add panel to the frame
        frame.getContentPane().add(menu);
    }
}
