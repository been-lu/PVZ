package core.zombies;

import core.plants.Plant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Zombie extends JLabel
{


    public abstract BufferedImage getImage();
    public abstract Icon getImage1();

    public void paintObjict(Graphics g)
    {
        g.drawImage(getImage(),position_x,position_y,null);
    }
    protected int width;
    protected int height;

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    protected int live;
<<<<<<< Updated upstream
    protected int position_x;
    protected int position_y;
=======
    protected int x;
    protected int y;
    protected int speed;
>>>>>>> Stashed changes


    public static final int LIFE = 0;
    public static final int ATTACK = 1;
    public static final int DEAD = 2;
    protected int state = LIFE;

    public abstract void step();
<<<<<<< Updated upstream

    public int getPosition_x() {
        return this.position_x;
    }

    public int getPosition_y() {
        return this.position_y;
=======
    public Zombie (int x,int y)
    {
        this.x=x;
        this.y=y;
        setIcon(getImage1());
>>>>>>> Stashed changes
    }
}
