package core.plants;

import frame.gamewindow.GameWindow;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public  class Pea extends Plant
{

    BufferedImage attrackimg[]=new BufferedImage[88];
    BufferedImage waiting[]=new BufferedImage[88];
    public BufferedImage getImage()
    {
        //plantimg++;
     // return waiting[plantimg];
        return waiting[0];
    }
    public void getImage1()
    {
        try
        {
          waiting[0]=ImageIO.read(new File("img/Plant2.png"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public Pea(int x,int y)
    {
        super(x,y);
        this.height=50;
        this.width=50;
        this.getImage1();
    }
}
