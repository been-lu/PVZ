package core.plants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class SunFlower extends Plant
{
    BufferedImage waiting[]=new BufferedImage[19];
    @Override
    public BufferedImage getImage()
    {
        plantimg++;
        if(plantimg==18)
            plantimg=0;
        return waiting[plantimg];
    }
    public void paintObjict(Graphics g)
    {
        g.drawImage(getImage(),position_x+110,position_y+80,null);
    }
    @Override
    public void getImage1()
    {
        try
        {
            int i;
            for( i=1;i<=18;i++)
            {
                waiting[i-1] = ImageIO.read(new File("img/run/s" + i + ".png"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public  SunFlower (int x,int y)
    {
        super(x, y);
        this.width=50;
        this.height=50;
        this.plantimg=0;
        this.life=10;
        this.getImage1();
        this.kind=0;
    }

}
