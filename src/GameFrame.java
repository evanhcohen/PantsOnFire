import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    private static JFrame frame;
    private static MenuPanel menu;
    private static GamePanel game;
    private static InstructionsPanel instructions;

    // constructor
    public GameFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fyre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates the panel
        game = new GamePanel();
        menu = new MenuPanel();
        instructions = new InstructionsPanel();

        menu.setPreferredSize(new Dimension(1100,700));
        game.setPreferredSize(new Dimension(1100,700));
        instructions.setPreferredSize(new Dimension(1100,700));

        // add the panel to the frame
        frame.getContentPane().add(menu);
    }
    public static JFrame getFrame()
    {
        return frame;
    }

    // shows the frame
    public void display()
    {
        frame.pack();
        frame.setVisible(true);
    }

    public static void changePanel()
    {
        if(MenuPanel.getStartGame())
        {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(game);
        }
        else if(InstructionsPanel.getBackToMenu())
        {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(menu);
        }
        else if(MenuPanel.getGoToInstructions())
        {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(instructions);
        }

    }
}
