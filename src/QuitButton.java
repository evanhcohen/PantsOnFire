import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class QuitButton extends JButton
{
    // quit button
    private JButton quit;

    // quit confirmation objects
    JOptionPane confirm;
    JDialog confirmDialog;
    JButton yes;
    JButton no;
    JButton[] options;

    public QuitButton(ActionListener a)
    {
        // set up the literal quit button
        quit = new JButton("Quit");
        quit.setFont(new Font("Arial", Font.PLAIN, 40));
        Dimension quitDim = quit.getPreferredSize();
        quit.setBounds(MainFrame.width - quitDim.width,0,quitDim.width,quitDim.height);
        quit.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(1, 5, 1, 5)));

        quit.setContentAreaFilled(false);
        quit.setFocusPainted(false);
        quit.setOpaque(false);

        quit.addActionListener(a);
        quit.setActionCommand("quit");

        // create yes button for quit confirmation
        yes = new JButton("Yes");
        yes.setFont(new Font("Arial", Font.PLAIN, 15));
        yes.setPreferredSize(new Dimension(60,30));
        yes.setContentAreaFilled(false);
        yes.setFocusPainted(false);
        yes.setOpaque(false);
        yes.addActionListener(a);
        yes.setActionCommand("yes");

        // create no button for quit confirmation
        no = new JButton("No");
        no.setFont(new Font("Arial", Font.PLAIN, 15));
        no.setPreferredSize(new Dimension(60,30));
        no.setContentAreaFilled(false);
        no.setFocusPainted(false);
        no.setOpaque(false);
        no.addActionListener(a);
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

    // return the confirm pop-up
    public JDialog getConfirm()
    {
        return confirmDialog;
    }

    // return the quit JButton to be added into the panel
    public JButton getQuit()
    {
        return quit;
    }
}
