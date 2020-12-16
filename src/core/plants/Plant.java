package core.plants;
import core.bullets.Bullet;
import core.zombies.Zombie;
import frame.gamewindow.GameWindow;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class Plant extends JLabel
{
    protected int width;
    public int kind;//0-太阳花,1-豌豆射手,2-寒冰射手,-3坚果,-4双射手
    protected int height;
    protected double life;
    protected int position_x;
    protected int position_y;
    protected int plantimg;
    protected int plantimg1;
    protected int plantimg2;
    public  static final int LIFE=0;
    public  static final int DIE=1;
    protected int state = LIFE;
    public Plant(int x, int y)
    {
        this.position_x=x;
        this.position_y=y;
    }
    public  void paintObjict(Graphics g)

    {
        g.drawImage(getImage(), position_x+110, position_y+80, null);
    }
    public abstract BufferedImage getImage();
    public abstract void getImage1();
    public  void beAttack(double ATK)
    {
        this.life-=ATK;
        if(this.life<=0)
        {
            this.state=DIE;
        }
    }
    public int getState()
    {
        return state;
    }
    public void setState(int state)
    {
        this.state = state;
    }
    public double getLife()
    {
        return life;
    }
    public void setLife(double life)
    {
        this.life = life;
    }
    public int getPosition_x() {
        return this.position_x;
    }
    public int getPosition_y() {
        return this.position_y;
    }
    public void setPosition_x(int position_x)
    {
        this.position_x = position_x;
    }
    public void setPosition_y(int position_y)
    {
        this.position_y = position_y;
    }
}
