import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{
    private Patty p;
    private Timer time = new Timer (5, this);


    public GamePanel()
    {
        // starts timer
        time.start();

        // adds a KeyListener
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        p = new Patty(30, 30);
    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.fillRect(p.getLocX(),p.getLocY(),80,80);
    }

    public void actionPerformed (ActionEvent e)
    {
        repaint();
        //repaint(p.getLocX(), p.getLocY(), 80, 80);
    }

    public void keyPressed (KeyEvent e)
    {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT)
        {
            p.changeX(-2);
        }
        if (c == KeyEvent.VK_RIGHT)
        {
            p.changeX(2);
        }
        if (c == KeyEvent.VK_UP)
        {
            p.changeY(-2);
        }
        if (c == KeyEvent.VK_DOWN)
        {
            p.changeY(2);
        }
    }

    public void keyReleased (KeyEvent e)
    {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_RIGHT)
        {
            p.changeX(0);
        }
        if (c == KeyEvent.VK_UP || c == KeyEvent.VK_DOWN)
        {
            p.changeY(0);
        }
    }

    public void keyTyped (KeyEvent e)
    {

    }
}
