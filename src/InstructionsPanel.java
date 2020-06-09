import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InstructionsPanel extends JPanel implements ActionListener, KeyListener
{
    private JButton menu;

    public InstructionsPanel()
    {
        menu = new JButton("MENU");
        menu.addActionListener(this);
        menu.setActionCommand("Menu");
        add(menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Menu"))
        {
            MenuFrame.changePanel(1);
            GameFrame.changePanel(1);
            InstructionsFrame.changePanel(1);
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
