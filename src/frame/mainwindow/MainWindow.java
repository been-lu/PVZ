package frame.mainwindow;

import com.sun.tools.javac.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainWindow extends JPanel{
    static Boolean flag = false;
    public static Color color;
    private static BufferedImage surface;
    public static BufferedImage maoxian;
    public static BufferedImage maoxian_1;//更换图片作为"鼠标已经在该按钮上"的提示
    public static BufferedImage image1;
    public static BufferedImage image2;
    public static BufferedImage d;

    static{
        color = Color.BLACK;

        try{
            surface = ImageIO.read(new File("img/Surface.png"));
            maoxian = ImageIO.read(new File("img/maoxian.png"));
            maoxian_1 = ImageIO.read(new File("img/maoxian_1.png"));
            d = ImageIO.read(new File("img/d.png"));
        }catch (Exception var1) {
            var1.printStackTrace();
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(surface, 0, 0, (ImageObserver)null);
        g.drawImage(d, 20, 0, (ImageObserver)null);
        g.drawImage(image1, 470, 60, (ImageObserver)null);
    }

    public MainWindow(){
        image1 = maoxian;
        this.addMouseListener(new MainListener());
        this.addMouseMotionListener(new MainListener());
    }
}
