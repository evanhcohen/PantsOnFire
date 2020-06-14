import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class LosePanel extends JPanel implements ActionListener, KeyListener
{
    // make sizes relative
    private int rel = MainFrame.width;

    // instructions button
    private JButton instructions;
    private Image instructionsImage;
    private int instructionsSize = rel/31;

    // restart button
    private JButton restart;
    private Image restartImg;
    private int restartSize = rel/31;

    // quit button
    private QuitButton quit;

    // lose message
    JLabel message;

    public LosePanel()
    {
        // allow for layout
        setLayout(null);

        // set up images
        try {
            restartImg = ImageIO.read(getClass().getResource("images/play.png")).getScaledInstance(restartSize, restartSize, Image.SCALE_SMOOTH);
            instructionsImage = ImageIO.read(getClass().getResource("images/instructions.png")).getScaledInstance(instructionsSize,instructionsSize, Image.SCALE_SMOOTH);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // create buttons
        restart = new JButton("Restart", new ImageIcon(restartImg));
        instructions = new JButton("Instructions", new ImageIcon(instructionsImage));

        // set button font
        restart.setFont(new Font("Arial", Font.PLAIN, rel/39));
        instructions.setFont(new Font("Arial", Font.PLAIN, rel/39));

        // set button dimensions
        Dimension playDim = restart.getPreferredSize();
        Dimension instructionsDim = instructions.getPreferredSize();

        // variable used to set location of buttons
        int totW = playDim.width + instructionsDim.width;

        // make and set location for restart
        restart.setBounds(MainFrame.width/2 - totW/2 + 1,MainFrame.height/2 - playDim.height/2, playDim.width, playDim.height);
        makeButton(restart, "play");

        // make and set location for instructions
        instructions.setBounds(MainFrame.width/2 - totW/2 + playDim.width - 1,MainFrame.height/2 - instructionsDim.height/2, instructionsDim.width, instructionsDim.height);
        makeButton(instructions, "instructions");

        // make and set location for quit
        quit = new QuitButton(this);
        add(quit.getQuit());

        // make and set location for lose message
        message = new JLabel("You have failed this city!");
        message.setFont(new Font("Arial", Font.PLAIN, rel/31));
        Dimension titleDim = message.getPreferredSize();
        message.setBounds(MainFrame.width/2 - titleDim.width/2,MainFrame.height/2 - rel/10, rel/2, titleDim.height);
        add(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("instructions"))
        {
            MainFrame.swapScreen(2);
        }
        if (action.equals("play"))
        {
            GamePanel.restart();
            MainFrame.swapScreen(3);
        }
        // make pop-up for confirmation if quit
        if (action.equals("quit"))
        {
            quit.getConfirm().setVisible(true);
        }
        // if yes confirmed, quit
        if (action.equals("yes"))
        {
            System.exit(0);
        }
        // if no confirmed, exit pop-up
        if (action.equals("no"))
        {
            quit.getConfirm().setVisible(false);
        }
    }

    // method to assist in button making
    public void makeButton(JButton b,String text)
    {
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
