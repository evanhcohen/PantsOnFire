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
    private int changeX = 0;
    private int changeY = 0;
    private int jump = 0;

    private Fire flame;
    private FireExtinguisher extinguisher;

    // platforms
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
    private Platform platform16;
    private Platform platform17;
    private Platform platform18;
    private Platform platform19;
    private Platform platform20;
    private Platform platform21;
    private ArrayList<Platform> myPlatforms;

    // game status checkers
    private static boolean play = false;
    private boolean ready;
    private boolean hasExtinguisher = false;
    private static boolean death = false;

    // time
    private Timer time = new Timer(3, this);

    // pause button
    private JButton pauseButton;
    private Image pauseButtonImg;
    private int pauseSize = 50;

    // timer
    private static long overallStart;
    private static long overallCurrent;
    private static long pauseStart;
    private static long pauseCurrent;
    private static int pauseSec;
    private static int overallSec;
    private static boolean pause = false;
    private static int displayTime;
    // time label
    private JLabel timeLabel;
    private Dimension timeDim;

    // background
    private Image background;

    // constructor
    public GamePanel()
    {
        // starts timer
        time.start();

        // adds a KeyListener
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // layout
        setLayout(null);

        // set up player object
        p = new Patty(50, 350, 50, 50);
//        p = new Patty(675, 124-50,50,50); // used for testing fire & fire extinguisher
        p.drawImg();

        //sets up fire
        flame = new Fire(1125, 344);
        flame.drawImg();

        //sets up Fire Extinguisher
        extinguisher = new FireExtinguisher(1175, 28);
        extinguisher.drawImg();

        // set up platforms
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
        platform10 = new Platform(800, 100);
        platform10.drawImg();
        platform11 = new Platform(1035, 92);
        platform11.drawImg();
        platform12 = new Platform(1085, 92);
        platform12.drawImg();
        platform13 = new Platform(1135, 92);
        platform13.drawImg();
        platform14 = new Platform(1185, 92);
        platform14.drawImg();
        platform15 = new Platform(500, 400);
        platform15.drawImg();
        platform16 = new Platform(725, 400);
        platform16.drawImg();
        platform17 = new Platform(800, 352);
        platform17.drawImg();
        platform18 = new Platform(1035, 400);
        platform18.drawImg();
        platform19 = new Platform(1085, 400);
        platform19.drawImg();
        platform20 = new Platform(1135, 400);
        platform20.drawImg();
        platform21 = new Platform(1185, 400);
        platform21.drawImg();

        // create platforms ArrayList and add platforms to it
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
        myPlatforms.add(platform16);
        myPlatforms.add(platform17);
        myPlatforms.add(platform18);
        myPlatforms.add(platform19);
        myPlatforms.add(platform20);
        myPlatforms.add(platform21);

        // set up images
        try {
            background = ImageIO.read(getClass().getResource("images/cityBackground.jpg"));
            pauseButtonImg = ImageIO.read(getClass().getResource("images/pause.png")).getScaledInstance(pauseSize,pauseSize, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // set up pause button
        pauseButton = new JButton();
        pauseButton.setMargin(new Insets(0, 0, 0, 0));
        pauseButton.setBorder(null);
        pauseButton.setBorderPainted(false);
        pauseButton.setContentAreaFilled(false);
        pauseButton.setFocusPainted(false);
        pauseButton.setOpaque(false);
        pauseButton.addActionListener(this);
        pauseButton.setActionCommand("pause");
        pauseButton.setIcon(new ImageIcon(pauseButtonImg));
        add(pauseButton);

        // instructions text
        timeLabel = new JLabel();
        timeLabel.setText("Time remaining: 90");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        timeLabel.setForeground(Color.red);
        timeDim = timeLabel.getPreferredSize();
        timeLabel.setBounds(0,0, 1500, timeDim.height);
        add(timeLabel);

        // game status update
        ready = true;
    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);

        // set pause button location (issues when in constructor)
        pauseButton.setBounds(this.getWidth() - pauseSize - 15, 15, pauseSize, pauseSize);

        // images drawn in this specific order: the earlier drawn, the farther in the background

        // draw background
        g.drawImage(background,0,0,this.getWidth(),this.getHeight(),this);

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
        g.drawImage(platform16.getImg(),platform16.leftBoundX(),platform16.topY(), this);
        g.drawImage(platform17.getImg(),platform17.leftBoundX(),platform17.topY(), this);
        g.drawImage(platform18.getImg(),platform18.leftBoundX(),platform18.topY(), this);
        g.drawImage(platform19.getImg(),platform19.leftBoundX(),platform19.topY(), this);
        g.drawImage(platform20.getImg(),platform20.leftBoundX(),platform20.topY(), this);
        g.drawImage(platform21.getImg(),platform21.leftBoundX(),platform21.topY(), this);

        // draw fire
        g.drawImage(flame.getImg(),flame.leftBoundX(),flame.topY(), this);

        // draw extinguisher when player doesn't have extinguisher
        if (!hasExtinguisher)
        {
            g.drawImage(extinguisher.getImg(),extinguisher.leftBoundX(),extinguisher.topY(), this);
        }

        // draw Patty
        g.drawImage(p.getImg(),p.getLocX(),p.getLocY(), this);
    }

    public void actionPerformed (ActionEvent e)
    {
        // game only runs when it's in "play" mode
        if (play)
        {
            // time
            overallCurrent = System.currentTimeMillis();
            overallSec =  (int)((overallCurrent - overallStart) / 1000);

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
            // check if touching extinguisher
            if(touchEx())
            {
                hasExtinguisher = true;
            }
            // check if touching fire
            if(isOnFire())
            {
                if(hasExtinguisher)
                {
                    MainFrame.swapScreen(4);
                    death = true;
                    hasExtinguisher = false;
                    play = false;
                    changeX = 0;
                    changeY = 0;
                }
                else
                {
                    death = true;
                }
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

            // check if pause is pressed
            String action = e.getActionCommand();
            if (action == "pause") // "==" for strings is incorrect, but errors occurred when .equals was used
            {
                MainFrame.swapScreen(6);
                play = false;
                pause = true;
                pauseStart = System.currentTimeMillis();
                changeX = 0;
                changeY = 0;
            }
        }
        // if game is paused, modify the paused time
        else if (pause)
        {
            pauseCurrent = System.currentTimeMillis();
            pauseSec =  (int)((pauseCurrent - pauseStart) / 1000);
        }

        // time that gets displayed
        displayTime = 90 - overallSec + pauseSec;
        // makes the time display
        if (ready)
        {
            timeLabel.setText("Time remaining: " + displayTime);
            add(timeLabel);
        }
        // if time runs out
        if (displayTime == 0)
        {
            MainFrame.swapScreen(5);
            death = true;
            hasExtinguisher = false;
            play = false;
            changeX = 0;
            changeY = 0;
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
        // only allow jump if touching platform
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

    // check if touching platform
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

    // check if touching fire
    public boolean isOnFire()
    {
        return flame.touching(p);
    }

    // check if touching fire extinguisher
    public boolean touchEx()
    {
        return extinguisher.touching(p);
    }

    public static boolean isDead()
    {
        return death;
    }

    public static void changeStatus(boolean status)
    {
        play = status;
    }

    // restart time system (runs when game starts or restarts)
    public static void restart()
    {
        overallStart = System.currentTimeMillis();
        pauseSec = 0;
        overallSec = 90;
    }
}
