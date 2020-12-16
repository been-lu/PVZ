package core.bullets;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Sun
{
    BufferedImage waiting[]=new BufferedImage[22];
    int position_x;
    int position_y;
    int img=0;
    int width;
    int height;
    public   Sun(int x,int y)
    {
        position_x=x;
        position_y=y;

        this.getImage1();
    }
        public BufferedImage getImage()
        {
            img++;
            if(img==22)
                img=0;
            return waiting[img];
        }
        public void paintObjict(Graphics g)
        {
            g.drawImage(getImage(),position_x+110,position_y+80,null);
        }

        public void getImage1()
        {
            try
            {
                int i;
                for( i=1;i<=22;i++)
                {
                    waiting[i-1] = ImageIO.read(new File("img/plant/sun(" + i + ").png"));
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

}
