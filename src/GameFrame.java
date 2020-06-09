import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    private static JFrame frame;
    private static GamePanel game;

    public GameFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fyre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates panel
        game = new GamePanel();
        game.setPreferredSize(new Dimension(1500,500));

        // add panel to the frame
        frame.getContentPane().add(game);
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
        if(x == 3)
        {
            display();
        }
        else
        {
            frame.setVisible(false);
        }
    }
}
