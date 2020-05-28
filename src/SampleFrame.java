import javax.swing.*;
import java.awt.*;

public class SampleFrame extends JFrame
{
    private JFrame frame;
    private SamplePanel panel;

    public SampleFrame()
    {
        // Creates the frame.
        frame = new JFrame("Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creates the panel.
        panel = new SamplePanel();
        panel.setPreferredSize(new Dimension(1000,800));

        // Adds the panel to the frame.
        frame.getContentPane().add(panel);
    }

    // Shows the frame.
    public void display()
    {
        frame.pack();
        frame.setVisible(true);
    }
}