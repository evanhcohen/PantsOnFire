import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuPanel extends JPanel implements ActionListener, KeyListener
{
    private JButton start;
    private JButton instructions;
    private boolean startGame = false;

    public MenuPanel()
    {
        start = new JButton("START");
        instructions = new JButton("HOW TO PLAY");

        start.addActionListener(this);
        start.setActionCommand("Start");
        add(start);
        add(instructions);

    }
    public boolean getStartGame()
    {
        return startGame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Start")) {
            startGame = true;
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
