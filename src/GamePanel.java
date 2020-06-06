import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{
    private Patty p;
    private Timer time = new Timer (3, this);

    Image background;

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

        p = new Patty(30, 400);
        p.drawImg();

        try {
            background = ImageIO.read(getClass().getResource("backgroundTest.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);

        // draw background
        g.drawImage(background,0,0,this.getWidth(),this.getHeight(),this);

        //draw Patty
        g.drawImage(p.getImg(50, 50),p.getLocX(),p.getLocY(), this);
    }

    public void actionPerformed (ActionEvent e)
    {
        // modify the players x and y values
        p.changeX(changeX);
        p.changeY(changeY);

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
