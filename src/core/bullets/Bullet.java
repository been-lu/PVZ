package core.bullets;

import core.zombies.Zombie;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bullet {
    private int position_x;
    private int position_y;
    private boolean isIce;//to judge whether this bullet is created by a ice bean shooter
    static int bulletSpeed=30;
    private BufferedImage img;

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

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setIce(boolean ice) {
        this.isIce = ice;
    }

    //init part
    public Bullet(int position_x,boolean ice){
        setPosition_x(position_x);
        setIce(ice);
        if(ice){
            try{
                this.img = ImageIO.read(new File("img/icebullet.png"));
            }catch (Exception var1) {
                var1.printStackTrace();
            }
        }
        else
        {
            try{
                this.img = ImageIO.read(new File("img/bullet.png"));
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




}
