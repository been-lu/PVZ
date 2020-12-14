package core.zombies;

import core.plants.Plant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Zombie
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
        g.drawImage(getImage(),x,y,null);
    }
    protected int width;
    protected int height;
    protected int live;
    protected int x;
    protected int y;


    public static final int LIFE = 0;
    public static final int ATTACK = 1;
    public static final int DEAD = 2;
    protected int state = LIFE;

    public abstract void step();
}
