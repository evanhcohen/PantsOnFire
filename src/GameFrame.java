import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    private static JFrame frame;
//    private static MenuPanel menu;
    private static GamePanel game;
//    private static InstructionsPanel instructions;
    private static int panelNum = 0;

    public GameFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fyre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates panel
        game = new GamePanel();
//        menu = new MenuPanel();
//        instructions = new InstructionsPanel();

//        menu.setPreferredSize(new Dimension(1500,500));
        game.setPreferredSize(new Dimension(1500,500));
//        instructions.setPreferredSize(new Dimension(1500,500));

        // add menu panel to the frame
        frame.getContentPane().add(game);
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
        if(panelNum == 3)
        {
            display();
        }
        else
        {
            frame.setVisible(false);
        }


    }
}
