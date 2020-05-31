import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuPanel extends JPanel implements ActionListener, KeyListener
{
    private JButton start;
    private JButton instructions;
    private static boolean startGame = false;
    private static boolean goToInstructions = false;

    public MenuPanel()
    {
        start = new JButton("START");
        instructions = new JButton("HOW TO PLAY");

        start.addActionListener(this);
        start.setActionCommand("Start");
        instructions.addActionListener(this);
        instructions.setActionCommand("Instructions");
        add(start);
        add(instructions);

    }
    public static boolean getStartGame()
    {
        return startGame;
    }
    public static boolean getGoToInstructions()
    {
        return goToInstructions;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Start"))
        {
            startGame = true;
            GameFrame.changePanel();
            GameFrame.getFrame().pack();
            GameFrame.getFrame().setVisible(true);
        }
        if (action.equals("Instructions"))
        {
            goToInstructions = true;
            GameFrame.changePanel();

            GameFrame.getFrame().pack();
            GameFrame.getFrame().setVisible(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
