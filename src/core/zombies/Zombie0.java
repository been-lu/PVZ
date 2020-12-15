package core.zombies;

import core.plants.Plant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Zombie0 extends Zombie
{



    public Zombie0(int x,int y)
    {
        super(x, y);

        this.width=100;
        this.height=100;
        this.live=20;
        this.speed=50;
    }

    public BufferedImage getImage()
    {
        try
        {
            BufferedImage img = ImageIO.read(new File("img/Zombie0.gif"));
            return img;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public Icon getImage1()
    {
        Icon img=new ImageIcon("img/Zombie0.gif");
        return img;
    }

    @Override
    public void step()
    {
      this.x-=speed;
    }
}
