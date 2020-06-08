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
    private Platform platform1;
    private Timer time = new Timer (3, this);

    private JButton settings;

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
        platform1 = new Platform(30, 400);
        platform1.drawImg();

        settings = new JButton();

        try {
            background = ImageIO.read(getClass().getResource("images/backgroundTest.jpg"));
            settings.setIcon(new ImageIcon (ImageIO.read(getClass().getResource("images/settings.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        settings.setMargin(new Insets(0, 0, 0, 0));
        settings.setBorder(null);
        settings.setPreferredSize(new Dimension(20,20));
        add(settings);

    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);

        // draw background
        g.drawImage(background,0,0,this.getWidth(),this.getHeight(),this);

        //draw Patty
        g.drawImage(p.getImg(50, 50),p.getLocX(),p.getLocY(), this);

        g.drawImage(platform1.getImg(100, 100),platform1.getLocX(),platform1.getLocY(), this);
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
