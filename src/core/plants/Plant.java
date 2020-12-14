package core.plants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public abstract class Plant
{
    public static BufferedImage loadImage(String fileName)
    {
        try
        {
            BufferedImage img = ImageIO.read(Plant.class.getResource(fileName));
            return img;
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public abstract BufferedImage getImage();


    public void paintObject(Graphics g)
    {
        g.drawImage(getImage(),position_x,position_y,null);
    }

    protected int width;
    protected int height;
    protected int live;
    protected int position_x;
    protected int position_y;


    public static final int LIFE = 0;
    public static final int ATTACK = 1;
    public static final int DEAD = 2;
    protected int state = LIFE;

    public abstract void step();

    public int getPosition_x() {
        return position_x;
    }

    public int getPosition_y() {
        return position_y;
    }
}
