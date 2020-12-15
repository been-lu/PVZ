package core.zombies;

import core.plants.Plant;
import frame.gamewindow.GameWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Zombie0 extends Zombie implements Attack
{


    BufferedImage runimg[]=new BufferedImage[88];
    public Zombie0(int x,int y)
    {
        super(x, y);
        this.width=100;
        this.height=100;
        this.life=20;
        this.speed=1;
        this.getImage1();
        this.zombiarunimg=0;
        this.ATK=5;
    }

    public void getImage1()   //加载图片
    {
        try
        {
            int i;
            for( i=0;i<=87;i++)
            {
                if(i<10) runimg[i] = ImageIO.read(new File("img/run/run000" + i + ".jpg"));
                else  runimg[i] = ImageIO.read(new File("img/run/run00" + i + ".jpg"));
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
        zombiarunimg++;
        if(zombiarunimg==87)
            zombiarunimg=0;
        return (runimg[zombiarunimg]);
    }

    @Override
    public void step()
    {
        if(state==0)
      this.position_x-=speed;
    }

    @Override
    public void cheak()
    {
        GameWindow P3=new GameWindow();
        for(Plant  p:P3. plant)
        {
            if(this.getPosition_y()==p.getPosition_y()&&this.getPosition_x()<p.getPosition_x())
                attack(p);
        }
    }

    @Override
    public void attack(Plant p)
    {
      state=ATTACK;
      p.beAttack(ATK);
    }
}
