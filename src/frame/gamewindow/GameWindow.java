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
import core.bullets.Sun;
import core.plants.*;
import core.zombies.*;
import util.ImgUtil;
import java.lang.Math.*;



public  class GameWindow extends JPanel implements Runnable
{
    public ArrayList<Zombie> zombie = new ArrayList();
    public ArrayList<Plant>  plant = new ArrayList();
    public ArrayList<Bullet> bullets=new ArrayList<>();
    public ArrayList<Sun> sun=new ArrayList<>();

//    public Container c1=new Container();
//    public Container c2=new Container();
//    public Container c3=new Container();
//    public Container c4=new Container();
//    public Container c5=new Container();


    String state;
    boolean GameOver = false;
    boolean Pass = false;
    int drawinterval=2;
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
        drawSun(g);
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
    public void isPass ()
    {
    }
    public void isGameOver ()
    {
    }
    public void drawSun(Graphics g)
    {
        for(Sun s:sun)
        {
            s.paintObjict(g);
        }
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
        int iscreatzombia=0;
        int tempx=0;
        int tempy=0;
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
               if(temp.getKind()==1||temp.getKind()==2)
               {
                   iscreatzombia=1;
                   tempx=temp.getPosition_x();
                   tempy=temp.getPosition_y();
                   z.remove();
               }
               else
               {
                   z.remove();
               }
           }
       }
       if(iscreatzombia==1)
       {
           zombie.add(new Zombie0(tempx,tempy));
       }
    }
    public void creatZombie()
    {
        int m=100;//每一格大概100高
        plant.add(new Pea(0,0));
        plant.add(new Pea(0,100));
        plant.add(new Pea(0,300));
        plant.add(new Pea(0,200));
        plant.add(new Pea(0,400));
        plant.add(new SunFlower(80,0));
        plant.add(new SunFlower(80,100));
        plant.add(new SunFlower(80,200));
        plant.add(new SunFlower(80,300));
        plant.add(new SunFlower(80,400));
        plant.add(new SnowPea(160,0));
        plant.add(new SnowPea(160,100));
        plant.add(new SnowPea(160,200));
        plant.add(new SnowPea(160,300));
        plant.add(new SnowPea(160,400));
        plant.add(new Nut(400,0));
        plant.add(new Nut(400,100));
        plant.add(new Nut(400,200));
        plant.add(new Nut(400,300));
        plant.add(new Nut(400,400));
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
                plantAttack();
                sunflowercreatsun();
                if(drawinterval==2)
                {
                    drawinterval=0;
                    repaint();
                }
                drawinterval++;
                Thread.sleep(30);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void sunflowercreatsun()
    {
        for(Plant p:plant)
        {
            if(p.kind==0)
            {
                if(p.suninterval==200)
                {
                   Random r=new Random();
                   int x=r.nextInt(30);
                   int y=r.nextInt(30);
                   x-=15;
                   y-=15;
                    p.suninterval=0;
                    sun.add(new Sun(p.getPosition_x()+x,p.getPosition_y()+y));
                }
                p.suninterval++;
            }
        }
    }
    public void plantAttack(){
        for(Plant p:plant)
            p.attack(zombie,bullets);
    }

}



