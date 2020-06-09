import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame
{
    private static JFrame frame;
    private static MenuPanel menu;

    public MenuFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fyre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates panel
        menu = new MenuPanel();

        menu.setPreferredSize(new Dimension(1500,500));

        // add menu panel to the frame
        frame.getContentPane().add(menu);
    }
    public static JFrame getFrame()
    {
        return frame;
    }

    // shows the frame
    public static void display() // potentially make this static
    {
        frame.pack();
        frame.setLocation(0,0);
        frame.setVisible(true);
    }

    public static void changePanel(int x)
    {
        if(x == 1)
        {
            display();
        }
        else
        {
            frame.setVisible(false);
        }
    }
}
