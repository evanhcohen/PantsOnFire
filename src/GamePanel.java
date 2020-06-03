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

    private int changeX = 0;
    private int changeY = 0;

    public GamePanel()
    {
        // starts timer
        time.start();

        // adds a KeyListener
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        p = new Patty(30, 30);
        p.drawImg();
    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(p.getImg(50, 50),p.getLocX(),p.getLocY(), this);
        //g.fillRect(p.getLocX(),p.getLocY(),80,80); // makes a rectangle
    }

    public void actionPerformed (ActionEvent e)
    {
        //System.out.println("LocX before change: " + p.getLocX());
        p.changeX(changeX);
        p.changeY(changeY);
        //System.out.println("LocX after change: " + p.getLocX());
        repaint();
        //repaint(p.getLocX(), p.getLocY(), 80, 80);
    }

    public void keyPressed (KeyEvent e)
    {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT)
        {
            System.out.println("KeyEvent left occurred");

            changeX = -2;
        }
        if (c == KeyEvent.VK_RIGHT)
        {
            System.out.println("KeyEvent right occurred");

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
