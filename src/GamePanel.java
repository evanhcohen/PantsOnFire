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
    // player object
    private static Patty p;

    private Platform platform1;
    private Platform platform2;
    private Platform platform3;
    private ArrayList<Platform> myPlatforms;

    private boolean ready;

    private Timer time = new Timer(3, this);

    private JButton settings;

    private Image background;

    private int changeX = 0;
    private int changeY = 0;

    private int jump = 0;

    // constructor
    public GamePanel()
    {
        // starts timer
        time.start();

        // adds a KeyListener
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // sets up player object
        p = new Patty(50, 350, 50, 50);
        p.drawImg();

        // sets up platforms
        platform1 = new Platform(50, 400);
        platform1.drawImg();
        platform2 = new Platform(200, 400);
        platform2.drawImg();
        platform3 = new Platform(300, 400);
        platform3.drawImg();

        myPlatforms = new ArrayList<>();
        myPlatforms.add(platform1);
        myPlatforms.add(platform2);
        myPlatforms.add(platform3);

        // set up settings button
        settings = new JButton(); //*** change this to pause button
        settings.setMargin(new Insets(0, 0, 0, 0));
        settings.setBorder(null);
        settings.setPreferredSize(new Dimension(20,20));
        add(settings);

        // set up images
        try {
            background = ImageIO.read(getClass().getResource("images/cityBackground.jpg"));
            settings.setIcon(new ImageIcon (ImageIO.read(getClass().getResource("images/settings.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ready = true;
    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);

        // draw background
        g.drawImage(background,0,0,this.getWidth(),this.getHeight(),this);

        // draw Patty
        g.drawImage(p.getImg(),p.getLocX(),p.getLocY(), this);

        // draw platforms
        g.drawImage(platform1.getImg(),platform1.leftBoundX(),platform1.topY(), this);
        g.drawImage(platform2.getImg(),platform2.leftBoundX(),platform2.topY(), this);
        g.drawImage(platform3.getImg(),platform3.leftBoundX(),platform3.topY(), this);
    }

    public void actionPerformed (ActionEvent e)
    {

        // jumping with gravity
        if(jump >= 1 && jump <= 30)
        {
            changeY = -4;
            jump ++;
        }
        else if(jump > 30 || (ready && !isTouching()))
        {
            changeY = 4;
            ready = true;
        }

        // don't move when touching platform
        if(ready && isTouching())
        {
            jump = 0;
            changeY = 0;
        }

        // change x and y for player
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
        if (c == KeyEvent.VK_UP && isTouching())
        {
            jump = 1;
            ready = false;
        }
        if (c == KeyEvent.VK_DOWN)
        {
            // intentionally left blank (nothing happens on down click)
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

    public boolean isTouching()
    {
        for (Platform x : myPlatforms)
        {
            if (x.touching(p))
            {
                return true;
            }
        }
        return false;
    }
}
