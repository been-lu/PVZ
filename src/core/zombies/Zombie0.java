package core.zombies;

import core.plants.Plant;

import frame.gamewindow.GameWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class Zombie0 extends Zombie
{
    BufferedImage runimg[]=new BufferedImage[22];
    BufferedImage attackimg[]=new BufferedImage[21];
    BufferedImage dieimg[]=new BufferedImage[10];
    public Zombie0(int x,int y)
    {
        super(x, y);
        this.width=60;
        this.height=60;
        this.life=20;
        this.speed=0.8;
        this.getImage1();
        this.zombiarunimg=0;
        this.zombiaattackimg=0;
        this.zombiadieimg=0;
        this.ATK=0.1;
        this.state=RUN;
    }
    public void getImage1()   //加载图片
    {
        try
        {
            int i;
            for( i=1;i<=22;i++)
            {
                 runimg[i-1] = ImageIO.read(new File("img/run/zombie (" + i + ").png"));
               // else  runimg[i] = ImageIO.read(new File("img/run/run00" + i + ".jpg"));
            }
            for( i=1;i<=21;i++)
            {
                attackimg[i-1] = ImageIO.read(new File("img/run/zombieAttack(" + i + ").png"));
                // else  runimg[i] = ImageIO.read(new File("img/run/run00" + i + ".jpg"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public BufferedImage getImage()  //获取图片.供其他类调用
    {
        if (state == 0)
        {
            zombiarunimg++;
            if (zombiarunimg == 22)
                zombiarunimg = 0;
            return (runimg[zombiarunimg]);
        } else if (state == 1)
        {
            zombiaattackimg++;
            if (zombiaattackimg == 21)
                zombiaattackimg = 0;
            return (attackimg[zombiaattackimg]);
        } else
        {
            zombiadieimg++;
            if (zombiadieimg == 0)
                zombiadieimg = 0;
            return (dieimg[zombiadieimg]);

        }
    }
    @Override
    public void paintObjict(Graphics g)
    {
        g.drawImage(getImage(),position_x+110,position_y+40,null);//100
    }
    @Override
    public void step()
    {
        if(state==0)
        {
            if(position_x<=0)
                position_x--;
            position_x -= speed;
        }
    }
    @Override
    public void cheak(ArrayList<Plant> plant)
    {
        System.out.println("僵尸位置"+position_x);
        for(Plant  p: plant)
        {
            if(position_y==p.getPosition_y())
            {
                if (this.getPosition_y() == p.getPosition_y() && this.getPosition_x() < p.getPosition_x() + 40)
                {
                    attack(p);
                }
            }
        }
    }
    @Override
    public void attack(Plant p)
    {

      state=ATTACK;
        if(p.getLife()<ATK)
            state=RUN;
      p.beAttack(ATK);
    }




}
