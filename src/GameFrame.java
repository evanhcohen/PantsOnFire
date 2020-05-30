import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    private JFrame frame;
    private MenuPanel menu;
    private GamePanel game;

    // constructor
    public GameFrame()
    {
        // creates the frame
        frame = new JFrame("Pants on Fyre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates the panel
        game = new GamePanel();
        menu = new MenuPanel();

        menu.setPreferredSize(new Dimension(1100,700));
        game.setPreferredSize(new Dimension(1100,700));

        // add the panel to the frame
        frame.getContentPane().add(menu);
        frame.getContentPane().removeAll();

        frame.getContentPane().add(menu);

    }

    // shows the frame
    public void display()
    {
        frame.pack();
        frame.setVisible(true);
    }
}
