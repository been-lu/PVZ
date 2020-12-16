package core.plants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Nut extends Plant
{
    public static final int IMGNUM=16;
    public static final int IMGNUM1=11;
    public static final int IMGNUM2=15;
    BufferedImage waiting[]=new BufferedImage[IMGNUM];
    BufferedImage waiting1[]=new BufferedImage[IMGNUM1];
    BufferedImage waiting2[]=new BufferedImage[IMGNUM2];
    int state1;
    public Nut (int x,int y)
    {
        super(x,y);
        this.height=50;
        this.width=50;
        this.plantimg=0;
        this.plantimg1=0;
        this.plantimg2=0;
        this.getImage1();
        this.life=10;
        this.kind=3;
        this.state1=0;//0完好,1残缺,2更残缺
    }
    @Override
    public BufferedImage getImage()
    {
        if(state1==0)
        {
            plantimg++;
            if(plantimg==IMGNUM)
                plantimg=0;
            return waiting[plantimg];
        }
        else
        if(state1==1)
        {
            plantimg1++;
            if(plantimg1==IMGNUM)
                plantimg1=0;
            return waiting[plantimg1];
        }
        else
        {
            plantimg2++;
            if(plantimg==IMGNUM)
                plantimg2=0;
            return waiting[plantimg2];
        }
    }
    @Override
    public void getImage1()
    {
      int i;
        for(i=1;i<=IMGNUM;i++)
        {
            try
            {
                waiting[i-1]= ImageIO.read(new File("img/plant/wallNut("+i+").png"));
            } catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        for(i=1;i<=IMGNUM1;i++)
        {
            try
            {
                waiting1[i-1]= ImageIO.read(new File("img/plant/wallNut_cracked1("+i+").png"));
            } catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        for(i=1;i<=IMGNUM2;i++)
        {
            try
            {
                waiting2[i-1]= ImageIO.read(new File("img/plant/wallNut_cracked2("+i+").png"));
            } catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
