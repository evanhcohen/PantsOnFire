import javax.swing.*;
import java.awt.*;

public class GameFrame extends MainFrame
{
    private static JFrame frame;
    private static GamePanel game;

    public GameFrame()
    {
        // creates the frame
        frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates panel
        game = new GamePanel();
        game.setPreferredSize(new Dimension(1500,500));

        // add panel to the frame
        frame.getContentPane().add(game);
    }

    public static void changePanel(int x)
    {
        if(x == 3)
        {
            frame.getContentPane().add(game);
            display(frame);
        }
        else
        {
            frame.setVisible(false);
        }
    }
}
