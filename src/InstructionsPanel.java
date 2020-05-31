import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InstructionsPanel extends JPanel implements ActionListener, KeyListener
{
    private JButton menu;
    private static boolean backToMenu = false;

    public InstructionsPanel()
    {
        menu = new JButton("MENU");
        menu.addActionListener(this);
        menu.setActionCommand("Menu");
        add(menu);

    }

    public static boolean getBackToMenu()
    {
        return backToMenu;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Menu")) {
            backToMenu = true;
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
