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

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    protected int live;
    protected int position_x;
    protected int position_y;
    protected int speed;



    public static final int LIFE = 0;
    public static final int ATTACK = 1;
    public static final int DEAD = 2;
    protected int state = LIFE;

    public abstract void step();


    public int getPosition_x() {
        return this.position_x;
    }

    public int getPosition_y() {
        return this.position_y;
    }

    public Zombie (int x,int y)
    {
        this.position_x=x;
        this.position_y=y;
        setIcon(getImage1());
    }
}
