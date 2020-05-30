import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{
    private int locx = 300;
    private int locy = 300;
    private int circX = 400;
    private int circY = 0;
    private int changeX = 0;
    private int changeY = 0;
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

        p = new Patty();

    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(locx, locy, 50, 50);
        p.paintComponent(g);
    }

    public void actionPerformed (ActionEvent e)
    {
        locx += changeX;
        locy += changeY;
        circY += 2;
        if (circY > 800)
        {
            circY = 0;
        }
        repaint();
    }

    public void keyPressed (KeyEvent e)
    {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT)
        {
            changeX = -2;
        }
        if (c == KeyEvent.VK_RIGHT)
        {
            changeX = 2;
        }
        if (c == KeyEvent.VK_UP)
        {
            changeY = -2;
        }
        if (c == KeyEvent.VK_DOWN)
        {
            changeY = 2;
        }
    }

    public void keyReleased (KeyEvent e)
    {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_RIGHT)
        {
            changeX = 0;
        }
        if (c == KeyEvent.VK_UP || c == KeyEvent.VK_DOWN)
        {
            changeY = 0;
        }
    }

    public void keyTyped (KeyEvent e)
    {

    }
}
