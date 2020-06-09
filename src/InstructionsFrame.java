import javax.swing.*;
import java.awt.*;

public class InstructionsFrame extends JFrame
{
    private static JFrame frame;
    private static InstructionsPanel instructions;

    public InstructionsFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fyre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates panel
        instructions = new InstructionsPanel();

        instructions.setPreferredSize(new Dimension(1500,500));

        // add menu panel to the frame
        frame.getContentPane().add(instructions);
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
        if (x == 2)
        {
            display();
        }
        else
        {
            frame.setVisible(false);
        }

    }
}
