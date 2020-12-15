package core.plants;
import frame.gamewindow.GameWindow;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class Plant extends JLabel
{
    protected int width;
    protected int height;
    protected int life;
    protected int position_x;
    protected int position_y;
    protected int plantimg;
    public static final int LIFE = 0;
    public static final int ATTACK = 1;
    public static final int DEAD = 2;
    protected int state = LIFE;

    public Plant(int x, int y)
    {
        this.position_x=x;
        this.position_y=y;
    }

    public static int getATTACK()
    {
        return ATTACK;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public static int getLIFE()
    {
        return LIFE;
    }

    public abstract BufferedImage getImage();
    public abstract void getImage1();
    public  void beAttack(int ATK)
    {
        this.life-=ATK;
        if(this.life<=0)
        {
            GameWindow p=new GameWindow();
            p.plant.remove(this);
        }
    }



    public int getPosition_x() {
        return this.position_x;
    }

    public int getPosition_y() {
        return this.position_y;
    }

    public  void paintObjict(Graphics g)

    {
        g.drawImage(getImage(),position_x,position_y,null);
    }
}
