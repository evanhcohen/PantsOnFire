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
    // back button
    private JButton back;
    private Image backImage;
    private int backSize = 30;
    private Dimension backDim;

    // instructions label
    private JLabel inst;
    private Dimension instDim;

    // image
    private Image exampleImg;
    private JLabel example;
    private int exH = (int) (460 * .75);
    private int exW = (int) (557 * .75);
    private Dimension exDim;

    // quit button
    private QuitButton quit;

    public InstructionsPanel()
    {
        // allow for layout
        setLayout(null);

        // set up images
        try {
            backImage = ImageIO.read(getClass().getResource("images/back.png")).getScaledInstance(backSize, backSize, Image.SCALE_SMOOTH);
            exampleImg = ImageIO.read(getClass().getResource("images/example.jpg")).getScaledInstance(exW,exH, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // back button
        back = new JButton("Back", new ImageIcon(backImage));
        back.setFont(new Font("Arial", Font.PLAIN, 30));
        backDim = back.getPreferredSize();
        back.setBounds(MainFrame.width/2 - backDim.width/2,30, backDim.width, backDim.height);

        back.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(1, 5, 1, 5)));

        back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        back.setOpaque(false);

        back.addActionListener(this);
        back.setActionCommand("back");
        add(back);

        // instructions text
        inst = new JLabel();
        inst.setText("<html> " +
                        "Thank you for answering our call!<br>" +
                        "The city is on fire and <b>you</b> are the only one who can stop it!<br>" +
                        "Be sure to collect the fire extinguisher before getting to the fire!<br>" +
                        "Now, it's your job to save the city. Good luck!<br><br>" +
                        "Use the right and left arrow keys to move around <br>" +
                        "and the up arrow to jump." +
                        "</html>");
        inst.setFont(new Font("Arial", Font.PLAIN, 25));
        instDim = inst.getPreferredSize();
        inst.setBounds(200,MainFrame.height/2 - instDim.height/2, 1500, instDim.height);
        add(inst);

        // image text
        example = new JLabel();
        example.setIcon(new ImageIcon(exampleImg));
        exDim = example.getPreferredSize();
        example.setBounds(MainFrame.width/2 + 200,MainFrame.height/2 - exDim.height/2, 1500, exDim.height);
        add(example);

        // make the quit button
        quit = new QuitButton(this);
        add(quit.getQuit());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("back"))
        {
            // change screens
            MainFrame.swapScreen(MainFrame.getLastScreen());
        }
        // pop-up on quit
        if (action.equals("quit"))
        {
            quit.getConfirm().setVisible(true);
        }
        // quit if yes confirmed
        if (action.equals("yes"))
        {
            System.exit(0);
        }
        // close pop-up if no confirmed
        if (action.equals("no"))
        {
            quit.getConfirm().setVisible(false);
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
