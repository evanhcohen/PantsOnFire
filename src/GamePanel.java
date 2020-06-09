import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{
    private static Patty p;
    private Platform platform1;
    private Platform platform2;
    private Platform platform3;

    ArrayList<Platform> platforms;

    private Timer time = new Timer (3, this);

    private JButton settings;

    private Image background;

    private boolean up = false;

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
        platform1 = new Platform(100, 400);
        platform1.drawImg();
        platform2 = new Platform(200, 400);
        platform2.drawImg();
        platform3 = new Platform(300, 400);
        platform3.drawImg();

        platforms.add(platform1);
        platforms.add(platform2);
        platforms.add(platform3);


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
        g.drawImage(platform2.getImg(100, 100),platform2.getLocX(),platform2.getLocY(), this);
        g.drawImage(platform3.getImg(100, 100),platform3.getLocX(),platform3.getLocY(), this);
    }

    public void actionPerformed (ActionEvent e)
    {
        // modify the players x and y values

        p.changeX(changeX);
        if (up)
        {

        }
        p.changeY(changeY);

        isTouching();



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
            up = true;
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

    public static Patty getP()
    {
        return p;
    }

    public boolean isTouching()
    {
        for (Platform x : platforms)
        {
            if (x.touching())
                return true;

        }
        return false;
    }
}
