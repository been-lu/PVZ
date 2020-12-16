package core.plants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class SnowPea extends Plant
{
    public static final int IMGNUM=15;
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
                waiting[i-1]= ImageIO.read(new File("img/plant/snowPea("+i+").png"));
            } catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
    public SnowPea(int x,int y)
    {
        super(x,y);
        this.width=50;
        this.height=50;
        this.plantimg=0;
        this.life=30;
        this.getImage1();
        this.kind=2;
    }
}
