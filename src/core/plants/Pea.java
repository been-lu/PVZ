package core.plants;

import core.bullets.Bullet;
import core.zombies.Zombie;
import frame.gamewindow.GameWindow;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public  class Pea extends Plant
{

    //BufferedImage attrackimg[]=new BufferedImage[88];
    public static final int IMGNUM=13;
    BufferedImage waiting[]=new BufferedImage[IMGNUM];
    public BufferedImage getImage()
    {
        plantimg++;
        if(plantimg==IMGNUM)
            plantimg=0;
        return waiting[plantimg];

    }
    public void getImage1()
    {
        int i;
        for(i=1;i<=IMGNUM;i++)
        {
            try
            {
                waiting[i-1]=ImageIO.read(new File("img/plant/peaShooter("+i+").png"));
            } catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
    public Pea(int x,int y)
    {
        super(x,y);
        this.height=50;
        this.width=50;
        this.plantimg=0;
        this.getImage1();
        this.life=10;
        this.kind=1;
    }


    public boolean attack(ArrayList<Zombie> zombies, ArrayList<Bullet> bullets)
    {
        for(Zombie z:zombies)
        {
            if(z.getPosition_y()==this.position_y)
                if(z.getPosition_x()>=this.position_x)
                {
                    bullets.add(new Bullet(position_x, position_y, false));
                    return true;
                }
        }
        return false;
    }

}
