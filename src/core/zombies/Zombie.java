package core.zombies;

import core.plants.Plant;
import frame.gamewindow.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


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
    protected double speed;
    protected double ATK;
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
    public abstract void step();
    public void cheak(ArrayList<Plant> plant)
    {
        for(Plant p: plant)
        {
            if(this.getPosition_y()==p.getPosition_y()&&this.getPosition_x()<p.getPosition_x()+60)
                attack(p);
        }
    }
    public void attack(Plant p)
    {
        state=ATTACK;
        p.beAttack(ATK);
    }
    public void beAttack(int ATK)
    {
        this.life-=ATK;
        if(this.life<=0)
        {
            state=2;
        }
    }
    public Zombie (int x,int y)
    {
        this.position_x=x;
        this.position_y=y;
    }
    public int getLife()
    {
        return life;
    }
    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }
    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }
    public double getSpeed()
    {
        return speed;
    }
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    public int getState()
    {
        return state;
    }
    public void setState(int state)
    {
        this.state = state;
    }
    public double getATK()
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
    public int getPosition_y() {
        return this.position_y;
    }
    public int getPosition_x()
    {
        return this.position_x;
    }
}
