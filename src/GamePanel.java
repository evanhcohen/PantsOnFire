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

    private static boolean play = false;

    private Platform platform1;
    private Platform platform2;
    private Platform platform3;
    private Platform platform4;
    private Platform platform5;
    private Platform platform6;
    private Platform platform7;
    private Platform platform8;
    private Platform platform9;
    private Platform platform10;
    private Platform platform11;
    private Platform platform12;
    private Platform platform13;
    private Platform platform14;
    private Platform platform15;
    private ArrayList<Platform> myPlatforms;

    private boolean ready;

    private Timer time = new Timer(3, this);

    private JButton pause;
    private Image pauseButton;
    private int pauseSize = 50;

    private Image background;

    private int changeX = 0;
    private int changeY = 0;
    private static boolean death = false;

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

        setLayout(null);

        // sets up player object
        p = new Patty(50, 350, 50, 50);
        p.drawImg();

        // sets up platforms
        platform1 = new Platform(50, 400);
        platform1.drawImg();
        platform2 = new Platform(150, 348);
        platform2.drawImg();
        platform3 = new Platform(20, 304);
        platform3.drawImg();
        platform4 = new Platform(200, 284);
        platform4.drawImg();
        platform5 = new Platform(125, 224);
        platform5.drawImg();
        platform6 = new Platform(75, 164);
        platform6.drawImg();
        platform7 = new Platform(250, 124);
        platform7.drawImg();
        platform8 = new Platform(450, 132);
        platform8.drawImg();
        platform9 = new Platform(675, 124);
        platform9.drawImg();
        platform10 = new Platform(800, 92);
        platform10.drawImg();
        platform11 = new Platform(1050, 96);
        platform11.drawImg();
        platform12 = new Platform(1100, 96);
        platform12.drawImg();
        platform13 = new Platform(1150, 96);
        platform13.drawImg();
        platform14 = new Platform(1200, 96);
        platform14.drawImg();
        platform15 = new Platform(1250, 96);
        platform15.drawImg();


        myPlatforms = new ArrayList<>();
        myPlatforms.add(platform1);
        myPlatforms.add(platform2);
        myPlatforms.add(platform3);
        myPlatforms.add(platform4);
        myPlatforms.add(platform5);
        myPlatforms.add(platform6);
        myPlatforms.add(platform7);
        myPlatforms.add(platform8);
        myPlatforms.add(platform9);
        myPlatforms.add(platform10);
        myPlatforms.add(platform11);
        myPlatforms.add(platform12);
        myPlatforms.add(platform13);
        myPlatforms.add(platform14);
        myPlatforms.add(platform15);


        // set up images
        try {
            background = ImageIO.read(getClass().getResource("images/cityBackground.jpg"));
            pauseButton = ImageIO.read(getClass().getResource("images/pause.png")).getScaledInstance(pauseSize,pauseSize, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // set up pause button
        pause = new JButton();
        pause.setMargin(new Insets(0, 0, 0, 0));
        pause.setBorder(null);
        pause.setBorderPainted(false);
        pause.setContentAreaFilled(false);
        pause.setFocusPainted(false);
        pause.setOpaque(false);
        pause.addActionListener(this);
        pause.setActionCommand("pause");
        pause.setIcon(new ImageIcon(pauseButton));
        add(pause);

        ready = true;
    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);

        pause.setBounds(this.getWidth() - pauseSize - 15, 15, pauseSize, pauseSize);

        // draw background
        g.drawImage(background,0,0,this.getWidth(),this.getHeight(),this);

        // draw Patty
        g.drawImage(p.getImg(),p.getLocX(),p.getLocY(), this);

        // draw platforms
        g.drawImage(platform1.getImg(),platform1.leftBoundX(),platform1.topY(), this);
        g.drawImage(platform2.getImg(),platform2.leftBoundX(),platform2.topY(), this);
        g.drawImage(platform3.getImg(),platform3.leftBoundX(),platform3.topY(), this);
        g.drawImage(platform4.getImg(),platform4.leftBoundX(),platform4.topY(), this);
        g.drawImage(platform5.getImg(),platform5.leftBoundX(),platform5.topY(), this);
        g.drawImage(platform6.getImg(),platform6.leftBoundX(),platform6.topY(), this);
        g.drawImage(platform7.getImg(),platform7.leftBoundX(),platform7.topY(), this);
        g.drawImage(platform8.getImg(),platform8.leftBoundX(),platform8.topY(), this);
        g.drawImage(platform9.getImg(),platform9.leftBoundX(),platform9.topY(), this);
        g.drawImage(platform10.getImg(),platform10.leftBoundX(),platform10.topY(), this);
        g.drawImage(platform11.getImg(),platform11.leftBoundX(),platform11.topY(), this);
        g.drawImage(platform12.getImg(),platform12.leftBoundX(),platform12.topY(), this);
        g.drawImage(platform13.getImg(),platform13.leftBoundX(),platform13.topY(), this);
        g.drawImage(platform14.getImg(),platform14.leftBoundX(),platform14.topY(), this);
        g.drawImage(platform15.getImg(),platform15.leftBoundX(),platform15.topY(), this);
    }

    public void actionPerformed (ActionEvent e)
    {
        if (play)
        {

            // jumping with gravity
            if(jump >= 1 && jump <= 15)
            {
                changeY = -4;
                jump ++;
            }
            else if(jump > 15 || (ready && !isTouching()))
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

            // if player falls down to bottom it goes back to beginning
            if(p.getLocY() >= 500)
            {
                death = true;
            }

            // change x and y for player
            p.changeX(changeX);
            p.changeY(changeY);

            repaint();
            death = false;


            String action = e.getActionCommand();
            if (action == "pause")
            {
                MenuFrame.changePanel(1);
                GameFrame.changePanel(1);
                InstructionsFrame.changePanel(1);
                play = false;
                changeX = 0;
                changeY = 0;
            }
        }
    }

    public void keyPressed (KeyEvent e)
    {
        int c = e.getKeyCode();

        if (c == KeyEvent.VK_LEFT)
        {
            changeX = -4;
        }
        if (c == KeyEvent.VK_RIGHT)
        {
            changeX = 4;

        }
        if (c == KeyEvent.VK_UP && isTouching())
        {
            jump = 1;
            ready = false;
        }
    }

    public void keyReleased (KeyEvent e)
    {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_RIGHT)
        {
            changeX = 0;
        }
        if (c == KeyEvent.VK_UP)
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

    public static boolean isDead()
    {
        return death;
    }

    public static void changeStatus(boolean status)
    {
        play = status;
    }
}
