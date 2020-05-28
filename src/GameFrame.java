import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    private JFrame frame;
    private SamplePanel panel; // modify this to a different panel

    // constructor
    public GameFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fyre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates the panel
        panel = new SamplePanel(); // modify this later
        panel.setPreferredSize(new Dimension(500,300));

        // add the panel to the frame
        frame.getContentPane().add(panel);
    }

    // shows the frame
    public void display()
    {
        frame.pack();
        frame.setVisible(true);
    }
}
