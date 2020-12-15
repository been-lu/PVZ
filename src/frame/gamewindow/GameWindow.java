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

import core.zombies.Zombie;
import core.zombies.Zombie0;
import util.ImgUtil;



public  class GameWindow extends JPanel implements Runnable
{

    ArrayList<Zombie> zombie = new ArrayList();

    String state;
    boolean GameOver = false;
    boolean Pass = false;

    public GameWindow()
    {

    }

    public void Action()
    {
        Zombie ces=new Zombie0(200,400) ;
        add(ces);
        (new Thread(new GameWindow())).start();
        this.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {

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
        this.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {

            }

            public void mouseDragged(MouseEvent e) {
            }
        });
    }//鼠标处理

    public void paint(Graphics g)
    {


        super.paint(g);
  
        //Zombie ce=new Zombie0(400,100);
       // Zombie ce2=new Zombie0(600,100);
       // drawZombie(g);
       // System.out.println("1");
       // this.paintBack(g);
        //zombie.add(ce);
        //zombie.add(ce2);

       // drawZombie(g);
    }


    public void paintBack(Graphics g){
        g.drawImage(ImgUtil.background1, -150, 0, (ImageObserver)null);
    }

    public void drawZombie(Graphics g)
    {

        for(Zombie z:zombie)
        {
            z.paintObjict(g);
        }

    }

    public void drawSun(Graphics g)
    {

    }

    public void drawBomb(Graphics g)
    {

    }

    public void isPass(){
    }

    public void isGameOver(){
    }

    public boolean check(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
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
        System.out.println("2");
        while(true)
        {
            try
            {
                this. creatZombie();
                this. zombiemove();
                Thread.sleep(500);
                ;

            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }



        }

    }
    public void creatZombie()
    {
        zombie.add(new Zombie0(100,100));
    }
}



