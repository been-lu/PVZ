package core.zombies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public  class Zombie3 extends Zombie
{
    public static final int i1=19;//有报走
    public static final int i2=14;//无报走
    public static final int i3=8;//有报吃
    public static final int i4=7;//无报吃
    public static final int i5=11;//失去报纸
    public static final int i6=11;//死亡
    BufferedImage img1[]=new BufferedImage[i1];
    BufferedImage img2[]=new BufferedImage[i2];
    BufferedImage img3[]=new BufferedImage[i3];
    BufferedImage img4[]=new BufferedImage[i4];
    BufferedImage img5[]=new BufferedImage[i5];
    BufferedImage img6[]=new BufferedImage[i6];
    protected int im1=0;
    protected int im2=0;
    protected int im3=0;
    protected int im4=0;
    protected int im5=0;
    protected int im6=0;
    protected int haspaper=1;//y一表示有
    public Zombie3(int x,int y)
    {
        super(x,y);
        this.width=60;
        this.height=60;
        this.life=20;
        this.speed=0.4;
        this.getImage1();
        this.zombiarunimg=0;
        this.zombiaattackimg=0;
        this.zombiadieimg=0;
        this.ATK=0.1;
        this.state=RUN;
        this.kind=3;
    }
    @Override
    public BufferedImage getImage()
    {
        System.out.println(state);
        if (state == 0)
        {
            if(haspaper==1)
            {
                im1++;
                if(im1==i1)
                {
                    im1=0;
                }
                return img1[im1];
            }
            else
            {
                im2++;
                if(im2==i2)
                {
                    im2=0;
                }
                return img2[im2];
            }
        }
        else if (state == 1)
        {
            if(haspaper==1)
            {
                im3++;
                if(im3==i3)
                {
                    im3=0;
                }
                return img3[im3];
            }
            else
            {
                im4++;
                if(im4==i4)
                {
                    im4=0;
                }
                return img4[im4];
            }
        }
        else
        {
            im5++;
            if(im5==i5)
            {
                im5=0;
            }
            return img5[im5];

        }
    }
    @Override
    public void getImage1()
    {

        try
        {
            int i;
            for( i=1;i<=i1;i++)
            {
                img1[i-1] = ImageIO.read(new File("img/run/newspaperZombieRun("+i+").png"));
            }
            for( i=1;i<=i2;i++)
            {
                img2[i-1] = ImageIO.read(new File("img/run/noNewspaperZombieRun("+i+").png"));
            }
            for( i=1;i<=i3;i++)
            {
                img3[i-1] = ImageIO.read(new File("img/run/newspaperZombieAttack("+i+").png"));
            }
            for( i=1;i<=i4;i++)
            {
                img4[i-1] = ImageIO.read(new File("img/run/withoutPaperAttack ("+i+").png"));
            }
            for( i=1;i<=i5;i++)
            {
                img5[i-1] = ImageIO.read(new File("img/run/lostNewspaper("+i+").png"));
            }
            for( i=1;i<=i6;i++)
            {
                img6[i-1] = ImageIO.read(new File("img/run/newspaperZombieDie("+i+").png"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void beAttack(int ATK)
    {
        this.life-=ATK;
        if(this.life<=10&&this.life>=0)
        {
           haspaper=0;
           speed=1.5;
        }
        if(this.life<=0)
        {
            state=0;
        }
    }
    @Override
    public void step()
    {
        if(state==0)
        {
            if(position_x<=0)
                position_x--;
            position_x -= speed;
        }
    }
}
