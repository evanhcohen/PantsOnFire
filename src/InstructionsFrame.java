import javax.swing.*;
import java.awt.*;

public class InstructionsFrame extends JFrame
{
    private static JFrame frame;
    private static InstructionsPanel instructions;
    private static int panelNum = 0;

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
        frame.setVisible(true);
    }

    public static void changePanel(int x)
    {
        panelNum = x;
        if (panelNum == 2)
        {
            display();
        }
        else
        {
            frame.setVisible(false);
        }

    }
}
