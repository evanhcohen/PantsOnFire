import javax.swing.*;

public class GameFrame extends MainFrame
{
    private static JFrame frame;
    private static GamePanel game;

    public GameFrame()
    {
        // creates the frame
        frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // locks frame size
        frame.setResizable(false);
        // removes title-bar
        frame.setUndecorated(true);

        // creates panel
        game = new GamePanel();
        game.setPreferredSize(d);

        // add panel to the frame
        frame.getContentPane().add(game);
    }

    // helps with screen swapping
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
