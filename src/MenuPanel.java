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
    // instructions button
    private JButton instructions;
    private Image instructionsImage;
    private int instructionsSize = 50;

    // menu button
    private JButton play;
    private Image playImage;
    private int playSize = 50;

    // quit button
    private JButton quit;

    // quit confirmation objects
    JOptionPane confirm;
    JDialog confirmDialog;
    JButton yes;
    JButton no;
    JButton[] options;

    // title text
    JLabel title;

    public MenuPanel()
    {
        // allow for layout
        setLayout(null);

        // set up images
        try {
            playImage = ImageIO.read(getClass().getResource("images/play.png")).getScaledInstance(playSize,playSize, Image.SCALE_SMOOTH);
            instructionsImage = ImageIO.read(getClass().getResource("images/instructions.png")).getScaledInstance(instructionsSize,instructionsSize, Image.SCALE_SMOOTH);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // create buttons
        play = new JButton("Play", new ImageIcon(playImage));
        instructions = new JButton("Instructions", new ImageIcon(instructionsImage));
        quit = new JButton("Quit");

        // set button fonts
        play.setFont(new Font("Arial", Font.PLAIN, 40));
        instructions.setFont(new Font("Arial", Font.PLAIN, 40));
        quit.setFont(new Font("Arial", Font.PLAIN, 40));

        // set button dimensions
        Dimension playDim = play.getPreferredSize();
        Dimension instructionsDim = instructions.getPreferredSize();
        Dimension quitDim = quit.getPreferredSize();

        // variable used to set location of buttons
        int totW = playDim.width + instructionsDim.width;

        // set location and make play button
        play.setBounds(MainFrame.width/2 - totW/2 + 1,MainFrame.height/2 - playDim.height/2, playDim.width, playDim.height);
        makeButton(play, "play");

        // set location and make instructions button
        instructions.setBounds(MainFrame.width/2 - totW/2 + playDim.width - 1,MainFrame.height/2 - instructionsDim.height/2, instructionsDim.width, instructionsDim.height);
        makeButton(instructions, "instructions");

        // set location and make quit button
        quit.setBounds(MainFrame.width - quitDim.width,0,quitDim.width,quitDim.height);
        makeButton(quit, "quit");

        // make title label
        title = new JLabel("Pants on Fire");
        title.setFont(new Font("Arial", Font.PLAIN, 70));
        Dimension titleDim = title.getPreferredSize();
        title.setBounds(MainFrame.width/2 - titleDim.width/2,MainFrame.height/2 - 150, 500, titleDim.height);
        add(title);

        // create yes button for quit confirmation
        yes = new JButton("Yes");
        yes.setFont(new Font("Arial", Font.PLAIN, 15));
        yes.setPreferredSize(new Dimension(60,30));
        yes.setContentAreaFilled(false);
        yes.setFocusPainted(false);
        yes.setOpaque(false);
        yes.addActionListener(this);
        yes.setActionCommand("yes");

        // create no button for quit confirmation
        no = new JButton("No");
        no.setFont(new Font("Arial", Font.PLAIN, 15));
        no.setPreferredSize(new Dimension(60,30));
        no.setContentAreaFilled(false);
        no.setFocusPainted(false);
        no.setOpaque(false);
        no.addActionListener(this);
        no.setActionCommand("no");

        // create options list for quit confirmation
        options = new JButton[2];
        options[0] = yes;
        options[1] = no;

        // create quit confirmation pop-up
        confirm = new JOptionPane();
        confirm.setMessage("Are you sure you want to quit? All progress will be lost.");
        confirm.setOptionType(JOptionPane.DEFAULT_OPTION);
        confirm.setMessageType(JOptionPane.PLAIN_MESSAGE);
        confirm.setIcon(null);
        confirm.setOptions(options);
        confirm.setInitialSelectionValue(options[0]);
        confirmDialog = confirm.createDialog(null,null);
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
            MainFrame.swapScreen(3);
            GamePanel.changeStatus(true);
        }
        // pop-up on quit
        if (action.equals("quit"))
        {
            confirmDialog.setVisible(true);
        }
        // quit if yes confirmed
        if (action.equals("yes"))
        {
            System.exit(0);
        }
        // close pop-up if no confirmed
        if (action.equals("no"))
        {
            confirmDialog.setVisible(false);
        }
    }

    // button maker method for buttons that require these points
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
