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

    private JButton quit;

    JOptionPane confirm;
    JDialog confirmDialog;
    JButton yes;
    JButton no;
    JButton[] options;

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
        quit = new JButton("Quit");

        play.setFont(new Font("Arial", Font.PLAIN, 40));
        instructions.setFont(new Font("Arial", Font.PLAIN, 40));
        quit.setFont(new Font("Arial", Font.PLAIN, 40));

        Dimension playDim = play.getPreferredSize();
        Dimension instructionsDim = instructions.getPreferredSize();
        Dimension quitDim = quit.getPreferredSize();

        int totW = playDim.width + instructionsDim.width;

        play.setBounds(MainFrame.width/2 - totW/2 + 1,MainFrame.height/2 - playDim.height/2, playDim.width, playDim.height);
        makeButton(play, "play");

        instructions.setBounds(MainFrame.width/2 - totW/2 + playDim.width - 1,MainFrame.height/2 - instructionsDim.height/2, instructionsDim.width, instructionsDim.height);
        makeButton(instructions, "instructions");

        quit.setBounds(MainFrame.width - quitDim.width,0,quitDim.width,quitDim.height);
        makeButton(quit, "quit");

        title = new JLabel("Pants on Fire");
        title.setFont(new Font("Arial", Font.PLAIN, 70));
        Dimension titleDim = title.getPreferredSize();
        title.setBounds(MainFrame.width/2 - titleDim.width/2,MainFrame.height/2 - 150, 500, titleDim.height);
        add(title);

        yes = new JButton("Yes");
        yes.setFont(new Font("Arial", Font.PLAIN, 15));
        yes.setPreferredSize(new Dimension(60,30));
        yes.setContentAreaFilled(false);
        yes.setFocusPainted(false);
        yes.setOpaque(false);
        yes.addActionListener(this);
        yes.setActionCommand("yes");

        no = new JButton("No");
        no.setFont(new Font("Arial", Font.PLAIN, 15));
        no.setPreferredSize(new Dimension(60,30));
        no.setContentAreaFilled(false);
        no.setFocusPainted(false);
        no.setOpaque(false);
        no.addActionListener(this);
        no.setActionCommand("no");

        options = new JButton[2];
        options[0] = yes;
        options[1] = no;

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
        if (action.equals("quit"))
        {
            confirmDialog.setVisible(true);

        }
        if (action.equals("yes"))
        {
            System.exit(0);
        }
        if (action.equals("no"))
        {
            confirmDialog.setVisible(false);
        }
    }

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
