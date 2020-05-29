import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    private JFrame frame;
    private SamplePanel panel; //modify this to a different panel
    private MenuPanel menu;
    private GamePanel game;
    // constructor

    public GameFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fyre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates the panel
        menu = new MenuPanel(); // modify this later
        menu.setPreferredSize(new Dimension(500,300));

        // add the panel to the frame
        frame.getContentPane().add(menu);
    }

    // shows the frame
    public void display()
    {
        frame.pack();
        frame.setVisible(true);
    }
}
