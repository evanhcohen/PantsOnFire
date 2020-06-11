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
    private int menuSize = 30;
    private Dimension menuDim;

    private JLabel inst;
    private Dimension instDim;

    public InstructionsPanel()
    {
        setLayout(null);

        // set up images
        try {
            menuImage = ImageIO.read(getClass().getResource("images/menu.png")).getScaledInstance(menuSize,menuSize, Image.SCALE_SMOOTH);

        } catch (IOException e) {
            e.printStackTrace();
        }

        menu = new JButton("Menu", new ImageIcon(menuImage));
        menu.setFont(new Font("Arial", Font.PLAIN, 30));
        menuDim = menu.getPreferredSize();
        menu.setBounds(MainFrame.width/2 - menuDim.width/2,30, menuDim.width, menuDim.height);

        menu.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(1, 5, 1, 5)));

        menu.setContentAreaFilled(false);
        menu.setFocusPainted(false);
        menu.setOpaque(false);

        menu.addActionListener(this);
        menu.setActionCommand("menu");
        add(menu);

        inst = new JLabel();
        inst.setText("<html> " +
                        "Thank you for answering our call!<br>" +
                        "The city is on fire and <b>you</b> are the only one who can stop it!<br>" +
                        "Use the arrow keys to move around.<br>" +
                        "Make sure to collect the fire extinguisher first.<br>" +
                        "Now, it's your job to save the city. Good luck!" +
                     "</html>");
        inst.setFont(new Font("Arial", Font.PLAIN, 20));
        instDim = inst.getPreferredSize();
        inst.setBounds(0,MainFrame.height/2 - instDim.height/2, 1500, instDim.height);

        add(inst);

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
