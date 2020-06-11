import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MenuPanel extends JPanel implements ActionListener, KeyListener
{
    private JButton instructions;
    private Image instructionsImage;
    private int instructionsSize = 15;

    Dimension size;

    private JButton play;
    private Image playImage;
    private int playSize = 15;

    public MenuPanel()
    {
//        setLayout(null);

        // set up images
        try {
            playImage = ImageIO.read(getClass().getResource("images/play.png")).getScaledInstance(playSize,playSize, Image.SCALE_SMOOTH);
            instructionsImage = ImageIO.read(getClass().getResource("images/instructions.png")).getScaledInstance(instructionsSize,instructionsSize, Image.SCALE_SMOOTH);

        } catch (IOException e) {
            e.printStackTrace();
        }

        play = new JButton("Play", new ImageIcon(playImage));
        size = play.getPreferredSize();
        play.setBounds(700,30, size.width, size.height);

        play.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(1, 5, 1, 5)));

        play.setContentAreaFilled(false);
        play.setFocusPainted(false);
        play.setOpaque(false);

        play.addActionListener(this);
        play.setActionCommand("Start");
        add(play);

        instructions = new JButton("Instructions", new ImageIcon(instructionsImage));
        size = instructions.getPreferredSize();
        instructions.setBounds(900,30, size.width, size.height);

        instructions.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(1, 5, 1, 5)));

        instructions.setContentAreaFilled(false);
        instructions.setFocusPainted(false);
        instructions.setOpaque(false);

        instructions.addActionListener(this);
        instructions.setActionCommand("Instructions");
        instructions.setBounds(0,300, 0, 0);
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
            GamePanel.changeStatus(true);
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
