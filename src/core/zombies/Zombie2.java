package core.zombies;

import core.plants.Plant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Zombie2 extends Zombie{
    BufferedImage runimg[]=new BufferedImage[21];
    BufferedImage attackimg[]=new BufferedImage[11];
    BufferedImage dieimg[]=new BufferedImage[10];
    public Zombie2(int x,int y)
    {
        super(x, y);
        this.width=40;
        this.height=40;
        this.life=20;
        this.speed=0.4;
        this.getImage1();
        this.zombiarunimg=0;
        this.zombiaattackimg=0;
        this.zombiadieimg=0;
        this.ATK=0.1;
        this.state=RUN;
        this.kind=2;
    }

    public void getImage1(){
        try
        {
            int i;
            for( i=1;i<=21;i++)     //加载铁桶僵尸走路
            {
                runimg[i-1] = ImageIO.read(new File("img/run/coneheadZombieRun(" + i + ").png"));
            }
            for( i=1;i<=11;i++)     //加载铁桶僵尸攻击
            {
                attackimg[i-1] = ImageIO.read(new File("img/run/coneheadZombieAttack(" + i + ").png"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public BufferedImage getImage() {
        if (state == 0)
        {
            zombiarunimg++;
            if (zombiarunimg == 21)
                zombiarunimg = 0;
            return (runimg[zombiarunimg]);
        } else if (state == 1)
        {
            zombiaattackimg++;
            if (zombiaattackimg == 11)
                zombiaattackimg = 0;
            return (attackimg[zombiaattackimg]);
        } else
        {
            zombiadieimg++;
            if (zombiadieimg == 0)
                zombiadieimg = 0;
            return (dieimg[(int)zombiadieimg]);

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
    public void creatzombie(int x,int y,ArrayList<Zombie> z)
    {
        z.add(new Zombie0(x,y));
    }
}
