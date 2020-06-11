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
    private JButton start;
    private JButton instructions;

    private Image play;
    private int playSize = 15;

    public MenuPanel()
    {
        // set up images
        try {
            play = ImageIO.read(getClass().getResource("images/play.png")).getScaledInstance(playSize,playSize, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }


        start = new JButton("START", new ImageIcon(play));
        start.setMargin(new Insets(0, 0, 0, 0));
        start.setBorder(null);
        start.setBorderPainted(false);
        start.setContentAreaFilled(false);
        start.setFocusPainted(false);
        start.setOpaque(false);
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
