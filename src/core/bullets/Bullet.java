package core.bullets;

import core.zombies.Zombie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Bullet {
    private int position_x;
    private int position_y;
    private boolean isIce;//to judge whether this bullet is created by a ice bean shooter
    static double bulletSpeed=1;
    private BufferedImage img;

    public BufferedImage getImage(){
        return this.img;
    }

    //drawing part
    public void paintObject(Graphics g){
        g.drawImage(getImg(),position_x+70,position_y+80,null);
    }

    public int getPosition_y() {
        return this.position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public boolean isIce() {
        return isIce;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setIce(boolean ice) {
        this.isIce = ice;
    }

    //init part
    public Bullet(int position_x,int position_y,boolean ice)
    {
        setPosition_x(position_x);
        setPosition_y(position_y);
        setIce(ice);
        if(ice){
            try{
                this.img = ImageIO.read(new File("img/0.png"));
            }catch (Exception var1) {
                var1.printStackTrace();
            }
        }
        else
        {
            try{
                this.img = ImageIO.read(new File("img/pea_bullet.png"));
            }catch (Exception var1) {
                var1.printStackTrace();
            }
        }
    }

    //when the bullet hit a zombie
    //undone
    public void collision(Zombie z){
        if(isIce){

        }

    }

    public boolean check(ArrayList<Zombie> zombies){
        for(Zombie z:zombies){
            if(z.getPosition_y()==this.getPosition_y()){
                if(z.getPosition_x()-this.getPosition_x()<=1){
                    if(isIce())
                        z.beAttack(2);
                    else
                        z.beAttack(1);
                    return true;
                }
            }
        }
        return false;
    }

    public void step(){
        setPosition_x((int)(getPosition_x()+bulletSpeed));
    }



}
