import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class PausePanel extends JPanel implements ActionListener, KeyListener
{
    // resume button
    private JButton resume;
    private Image resumeImg;
    private int resumeSize = 50;

    // quit button
    private QuitButton quit;

    // message
    JLabel message;

    public PausePanel()
    {
        // allow for layout
        setLayout(null);

        // set up images
        try {
            resumeImg = ImageIO.read(getClass().getResource("images/play.png")).getScaledInstance(resumeSize, resumeSize, Image.SCALE_SMOOTH);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // create buttons
        resume = new JButton("Resume", new ImageIcon(resumeImg));

        // set button font
        resume.setFont(new Font("Arial", Font.PLAIN, 40));

        // set button dimensions
        Dimension resume = this.resume.getPreferredSize();

        // make and set location for resume
        this.resume.setBounds(MainFrame.width/2 - resume.width/2,MainFrame.height/2 - resume.height/2, resume.width, resume.height);
        makeButton(this.resume, "play");

        // make and set location for quit
        quit = new QuitButton(this);
        add(quit.getQuit());

        // make and set location for win message
        message = new JLabel("Game Paused");
        message.setFont(new Font("Arial", Font.PLAIN, 50));
        Dimension titleDim = message.getPreferredSize();
        message.setBounds(MainFrame.width/2 - titleDim.width/2,MainFrame.height/2 - 150, 1200, titleDim.height);
        add(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("play"))
        {
            MainFrame.swapScreen(3);
            GamePanel.setTotalPause();
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
