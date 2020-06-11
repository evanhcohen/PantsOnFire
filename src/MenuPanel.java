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
    private int instructionsSize = 50;

    private JButton play;
    private Image playImage;
    private int playSize = 50;

    Dimension size;

    public MenuPanel()
    {
        setLayout(null);

        // set up images
        try {
            playImage = ImageIO.read(getClass().getResource("images/play.png")).getScaledInstance(playSize,playSize, Image.SCALE_SMOOTH);
            instructionsImage = ImageIO.read(getClass().getResource("images/instructions.png")).getScaledInstance(instructionsSize,instructionsSize, Image.SCALE_SMOOTH);

        } catch (IOException e) {
            e.printStackTrace();
        }

        play = new JButton("Play", new ImageIcon(playImage));
        play.setFont(new Font("Arial", Font.PLAIN, 40));
        size = play.getPreferredSize();
        play.setBounds(MainFrame.width/2 - size.width,MainFrame.height/2 - size.height/2, size.width, size.height);
        makeButton(play);
        play.addActionListener(this);
        play.setActionCommand("Start");
        add(play);

        instructions = new JButton("Instructions", new ImageIcon(instructionsImage));
        instructions.setFont(new Font("Arial", Font.PLAIN, 40));
        size = instructions.getPreferredSize();
        instructions.setBounds(MainFrame.width/2,MainFrame.height/2 - size.height/2, size.width, size.height);
        makeButton(play);
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

    public void makeButton(JButton b)
    {
        b.setFont(new Font("Arial", Font.PLAIN, 40));

        b.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(1, 5, 1, 5)));

        b.setContentAreaFilled(false);
        b.setFocusPainted(false);
        b.setOpaque(false);
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
