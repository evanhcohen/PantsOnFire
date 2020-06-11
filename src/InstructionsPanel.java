import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class InstructionsPanel extends JPanel implements ActionListener, KeyListener
{
    private JButton menu;
    private Image menuImage;
    private int menuSize = 15;

    public InstructionsPanel()
    {
        // set up images
        try {
            menuImage = ImageIO.read(getClass().getResource("images/menu.png")).getScaledInstance(menuSize,menuSize, Image.SCALE_SMOOTH);

        } catch (IOException e) {
            e.printStackTrace();
        }

        menu = new JButton("Menu", new ImageIcon(menuImage));
        menu.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        menu.setContentAreaFilled(false);
        menu.setFocusPainted(false);
        menu.setOpaque(false);
        menu.addActionListener(this);
        menu.setActionCommand("menu");
        menu.setBounds(0,300, 0, 0);
        add(menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("menu"))
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
