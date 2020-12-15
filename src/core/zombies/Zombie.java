package core.zombies;

import frame.gamewindow.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Zombie extends JLabel
{
    protected int width;
    protected int height;
    protected int life;
    protected int position_x;
    protected int position_y;
    protected int zombiarunimg;
    protected int zombiaattackimg;
    protected int zombiadieimg;
    protected int speed;
    protected int ATK;
    public static final int isdie = 0;
    public static final int RUN=0;
    public static final int ATTACK = 1;
    public static final int DEAD = 2;
    protected int state = RUN;

    public abstract BufferedImage getImage();


    public void paintObjict(Graphics g)
    {
        g.drawImage(getImage(),position_x-65,position_y+20,null);
    }

<<<<<<< HEAD

    public abstract void step();


    public int getPosition_x()
    {
        return this.position_x;
    }

    public int getPosition_y()
    {
        return this.position_y;
    }

    public int getLife()
    {
        return life;
    }
=======
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

>>>>>>> 060f7a54c99b4fdd1005d5f16ecaeda27fd0e9ad

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

<<<<<<< HEAD
    public int getState()
    {
        return state;
    }
=======
    public abstract void step();

>>>>>>> 060f7a54c99b4fdd1005d5f16ecaeda27fd0e9ad

    public void setState(int state)
    {
        this.state = state;
    }

    public int getATK()
    {
        return ATK;
    }

    public void setATK(int ATK)
    {
        this.ATK = ATK;
    }

    public void setLife(int life)
    {
        this.life = life;
    }

    public void beAttack(int ATK)
    {
        this.life-=ATK;
        if(this.life<=0)
        {
            GameWindow p=new GameWindow();
            p.plant.remove(this);
        }
    }

<<<<<<< HEAD
=======
    public int getPosition_y() {
        return this.position_y;
    }

>>>>>>> 060f7a54c99b4fdd1005d5f16ecaeda27fd0e9ad
    public Zombie (int x,int y)
    {
        this.position_x=x;
        this.position_y=y;
<<<<<<< HEAD
=======
        setIcon(getImage1());
>>>>>>> 060f7a54c99b4fdd1005d5f16ecaeda27fd0e9ad
    }
}
