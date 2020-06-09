import javax.swing.*;
import java.awt.*;

public class MenuFrame extends MainFrame
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

        // add panel to the frame
        frame.getContentPane().add(menu);
    }
    public static JFrame getFrame()
    {
        return frame;
    }

    public static void changePanel(int x)
    {
        if(x == 1)
        {
            display(frame);
        }
        else
        {
            frame.setVisible(false);
        }
    }
}
