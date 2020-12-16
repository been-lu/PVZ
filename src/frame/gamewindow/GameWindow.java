package frame.gamewindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

import core.bullets.Bullet;
import core.plants.Plant;
import core.plants.Pea;
import core.plants.SnowPea;
import core.plants.SunFlower;
import core.zombies.*;
import util.ImgUtil;



public  class GameWindow extends JPanel implements Runnable
{
    public ArrayList<Zombie> zombie = new ArrayList();
    public ArrayList<Plant>  plant = new ArrayList();
    public ArrayList<Bullet> bullets=new ArrayList<>();

//    public Container c1=new Container();
//    public Container c2=new Container();
//    public Container c3=new Container();
//    public Container c4=new Container();
//    public Container c5=new Container();


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
        this.creatZombie();
        this.createBullet();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        this.paintBack(g);
        drawZombie(g);
        drawPlant(g);
        drawBullet(g);
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

    public void drawBullet(Graphics g){
        if(bullets.isEmpty())
            return ;
        for(Bullet b:bullets){
            b.paintObject(g);
        }
    }
    public void isPass () {
    }
    public void isGameOver () {
    }
    public void drawSun(Graphics g) {
    }


    public boolean check(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2)
    {
        return x1 + w1 >= x2 && y1 + h1 >= y2 && x2 + w2 >= x1 && y2 + h2 >= y1;
    }


    //public void zombieisAttacked(ArrayList<Zombie> zombie){}

    public void drawBomb(Graphics g)
    {
    }

    public void zombiemove()
    {
       for(Zombie z:zombie)
       {
           z.cheak(plant);
           z.step();
       }
    }

    public void bulletMove(){
        Iterator<Bullet> b=bullets.iterator();
        while(b.hasNext()){
            Bullet tmp=b.next();
            if(tmp.check(zombie))
                b.remove();
            else{
                tmp.step();
                if(tmp.getPosition_x()>900)
                    b.remove();
            }
        }
    }

    //test
    public void createBullet(){
        bullets.add(new Bullet(80,0,true));
        bullets.add(new Bullet(80,100,false));
    }
    public void cheakdie()
    {

       Iterator<Plant> p=plant.iterator();
       while(p.hasNext())
       {
           Plant temp=p.next();
           if(temp.getState()==1)
           {
               p.remove();
           }
       }
       Iterator<Zombie>z=zombie.iterator();
       while(z.hasNext())
       {
           Zombie temp=z.next();
           if(temp.getState()==2)
           {
               z.remove();
           }
       }

    }

    public void creatZombie()
    {
        int m=100;//每一格大概100高

        plant.add(new Pea(0,100));
        plant.add(new Pea(80,100));
        plant.add(new Pea(240,100));
        plant.add(new SnowPea(500,200));
        plant.add(new SunFlower(0,0));
        plant.add(new SunFlower(400,200));
        zombie.add(new Zombie0(600,0));
        zombie.add(new Zombie1(600,m));//0.100
        zombie.add(new Zombie2(600,2*m));
        zombie.add(new Zombie3(600,3*m));
        zombie.add(new Zombie4(600,4*m));
    }

    public void run()
    {
        while(true)
        {
            try
            {
                this.zombiemove();
                this.bulletMove();
                cheakdie();
                repaint();

                Thread.sleep(30);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }



}



