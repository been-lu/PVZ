package core.plants;

import java.awt.image.BufferedImage;

public  class Pea extends Plant
{

    private BufferedImage x;
    public BufferedImage getImage()
    {
      x=loadImage("img/1.gif");
      return x;
    }


    public void step()
    {

    }
}
