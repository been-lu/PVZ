package frame.gamewindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JPanel;
import java.awt.image.ImageObserver;
import java.io.File;

import core.plants.Plant;
import core.plants.Pea;
import core.zombies.Zombie;
import core.zombies.Zombie0;
import util.ImgUtil;



public  class GameWindow extends JPanel implements Runnable
{

  public ArrayList<Zombie> zombie = new ArrayList();
  public ArrayList<Plant>  plant = new ArrayList();

    String state;
    boolean GameOver = false;
    boolean Pass = false;
    public GameWindow()
    {

    }

    public void Action()
    {
        Thread t1=new Thread(this);
        t1.start();
        this. creatZombie();
        this.addMouseListener(new MouseListener()
        {
            public void mousePressed(MouseEvent e)
            {

            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseClicked(MouseEvent e) {
            }
        });
        this.addMouseMotionListener
                (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {

            }

            public void mouseDragged(MouseEvent e) {
            }
        });
    }//鼠标处理

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        this.paintBack(g);
        drawZombie(g);
        drawPlant(g);
    }

    public void paintBack(Graphics g)
    {
        g.drawImage(ImgUtil.background1, -150, 0, (ImageObserver)null);
    }

    public void drawZombie(Graphics g)
    {
        for(Zombie z:zombie)
        {
            z.paintObjict(g);
        }

    }
    public void drawPlant(Graphics g)
    {
        for(Plant p:plant)
        {
            p.paintObjict(g);
        }
    }

        public void drawSun (Graphics g)
        {

        }

        public void drawBomb (Graphics g)
        {

        }

        public void isPass ()
        {

        }

        public void isGameOver ()
        {

        }


    public boolean check(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2)
    {
        return x1 + w1 >= x2 && y1 + h1 >= y2 && x2 + w2 >= x1 && y2 + h2 >= y1;
    }

    //public void zombieisAttacked(ArrayList<Zombie> zombie){}

    public void zombiemove()
    {
       for(Zombie z:zombie)
       {
           z.step();
       }
    }
    public void run()
    {

        while(true)
        {
            try
            {
                this. zombiemove();
                Thread.sleep(30);
                repaint();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
    public void update(Graphics g)
    {

    }
    public void creatZombie()
    {
        int m=100;//每一格大概100高
        zombie.add(new Zombie0(830,0));
        plant.add(new Pea(100,0));
        zombie.add(new Zombie0(830,m));//0.100
        zombie.add(new Zombie0(830,2*m));
        zombie.add(new Zombie0(830,3*m));
        zombie.add(new Zombie0(830,4*m));

    }
}



