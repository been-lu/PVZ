package core.bullets;

import core.zombies.Zombie;

import java.awt.image.BufferedImage;

public class Bullet {
    private int position_x;
    private boolean isIce;//to judge whether this bullet is created by a ice bean shooter
    static int bulletSpeed;
    private BufferedImage img;

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

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setIce(boolean ice) {
        this.isIce = ice;
    }

    public Bullet(int position_x,boolean ice){
        setPosition_x(position_x);
        setIce(ice);
    }

    public void collision(Zombie z){
        if(isIce){

        }

    }
}
