package core.zombies;

import java.awt.image.BufferedImage;

public class Zombie0 extends Zombie
{

    private BufferedImage x;
    public BufferedImage getImage()
    {
        x=loadImage("img/Zombie0.gif");
        return x;
    }
    @Override
    public void step()
    {

    }
}
