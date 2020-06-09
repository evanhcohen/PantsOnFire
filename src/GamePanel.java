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

    private int jump = 0;

    private Platform platform1;
    private Platform platform2;
    private Platform platform3;
    private boolean ready = false;

    private ArrayList<Platform> myPlatforms;

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

        p = new Patty(30, 0, 50, 50);
        p.drawImg();

        platform1 = new Platform(50, 400);
        platform1.drawImg();
        platform2 = new Platform(200, 400);
        platform2.drawImg();
        platform3 = new Platform(300, 400);
        platform3.drawImg();

        myPlatforms = new ArrayList<Platform>();
        myPlatforms.add(platform1);
        myPlatforms.add(platform2);
        myPlatforms.add(platform3);

         settings = new JButton();

        try {
            background = ImageIO.read(getClass().getResource("images/backgroundTest.jpg"));
            settings.setIcon(new ImageIcon (ImageIO.read(getClass().getResource("images/settings.png"))));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        settings.setMargin(new Insets(0, 0, 0, 0));
        settings.setBorder(null);
        settings.setPreferredSize(new Dimension(20,20));
        add(settings);

        ready = true;
    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);

        // draw background
        g.drawImage(background,0,0,this.getWidth(),this.getHeight(),this);

        //draw Patty
        g.drawImage(p.getImg(),p.getLocX(),p.getLocY(), this);

        g.drawImage(platform1.getImg(),platform1.getLocX(),platform1.getLocY(), this);
        g.drawImage(platform2.getImg(),platform2.getLocX(),platform2.getLocY(), this);
        g.drawImage(platform3.getImg(),platform3.getLocX(),platform3.getLocY(), this);
    }

    public void actionPerformed (ActionEvent e)
    {
        // modify the players x and y values

        if(jump >= 1 && jump <= 30)
        {
            changeY = -4;
            jump ++;
        }
        if(jump > 30)
        {
            changeY = 1;
        }
        if(ready && isTouching() == 1)
        {
            p.changeY(-1);
            jump = 0;
            changeY = 0;

        }
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
            up = true;
            jump = 1;
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

    public int isTouching()
    {
        int answer = 0;
        for (Platform x : myPlatforms)
        {
            if (x.touching())
            {
                answer = 1;
            }
        }
        return answer;
    }
}
