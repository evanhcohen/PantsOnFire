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

    private JButton close;
    private Image closeImage;
    private int closeSize;

    JLabel title;

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
        instructions = new JButton("Instructions", new ImageIcon(instructionsImage));
        close = new JButton("Close");

        play.setFont(new Font("Arial", Font.PLAIN, 40));
        instructions.setFont(new Font("Arial", Font.PLAIN, 40));
        close.setFont(new Font("Arial", Font.PLAIN, 40));

        Dimension playDim = play.getPreferredSize();
        Dimension instructionsDim = instructions.getPreferredSize();

        int totW = playDim.width + instructionsDim.width;

        play.setBounds(MainFrame.width/2 - totW/2 + 1,MainFrame.height/2 - playDim.height/2, playDim.width, playDim.height);
        makeButton(play, "play");

        instructions.setBounds(MainFrame.width/2 - totW/2 + playDim.width - 1,MainFrame.height/2 - instructionsDim.height/2, instructionsDim.width, instructionsDim.height);
        makeButton(instructions, "instructions");

        close.setBounds(0,0,close.getPreferredSize().width,close.getPreferredSize().height);
        makeButton(close, "close");

        title = new JLabel("Pants on Fyre");
        title.setFont(new Font("Arial", Font.PLAIN, 70));
        Dimension titleDim = title.getPreferredSize();
        title.setBounds(MainFrame.width/2 - titleDim.width/2,MainFrame.height/2 - 150, 500, titleDim.height);
        add(title);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("instructions"))
        {
            MenuFrame.changePanel(2);
            GameFrame.changePanel(2);
            InstructionsFrame.changePanel(2);
        }
        if (action.equals("play"))
        {
            GameFrame.changePanel(3);
            MenuFrame.changePanel(3);
            InstructionsFrame.changePanel(3);
            GamePanel.changeStatus(true);
        }
        if (action.equals("close"))
        {
            System.exit(0);
        }
    }

    public void makeButton(JButton b,String text)
    {
        b.setFont(new Font("Arial", Font.PLAIN, 40));

        b.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(1, 5, 1, 5)));

        b.setContentAreaFilled(false);
        b.setFocusPainted(false);
        b.setOpaque(false);

        b.addActionListener(this);
        b.setActionCommand(text);
        add(b);
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
