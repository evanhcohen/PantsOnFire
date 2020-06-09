import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuPanel extends JPanel implements ActionListener, KeyListener
{
    private JButton start;
    private JButton instructions;

    public MenuPanel()
    {
        start = new JButton("START");
        start.addActionListener(this);
        start.setActionCommand("Start");
        add(start);

        instructions = new JButton("HOW TO PLAY");
        instructions.addActionListener(this);
        instructions.setActionCommand("Instructions");
        add(instructions);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Instructions"))
        {
            MenuFrame.changePanel(2);
            GameFrame.changePanel(2);
            InstructionsFrame.changePanel(2);
        }
        if (action.equals("Start"))
        {
            GameFrame.changePanel(3);
            MenuFrame.changePanel(3);
            InstructionsFrame.changePanel(3);
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
