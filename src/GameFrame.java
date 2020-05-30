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
        game = new GamePanel(); // modify this later
        game.setPreferredSize(new Dimension(1100,700));

        // add the panel to the frame
        frame.getContentPane().add(game);
    }

    // shows the frame
    public void display()
    {
        frame.pack();
        frame.setVisible(true);
    }
}
