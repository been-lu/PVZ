package core.plants;

import frame.gamewindow.GameWindow;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

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
}
