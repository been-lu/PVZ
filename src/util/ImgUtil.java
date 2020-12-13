package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImgUtil {
    public static BufferedImage background1;

    static{
        try{
            background1 = ImageIO.read(new FileInputStream("img/background1.jpg"));
        }catch (IOException var1) {
            var1.printStackTrace();
        }
    }

    public ImgUtil() {
    }

    public static Image LoadImage(ImageIcon im) {
        Image image = null;
        Image img = null;
        img = im.getImage();
        image = Toolkit.getDefaultToolkit().createImage(img.getSource());
        return image;
    }

    public static void setAlpha(Graphics g, float alpha) {
        int compositeRule = 3;
        AlphaComposite alphaComposite = AlphaComposite.getInstance(compositeRule, alpha);
        ((Graphics2D)g).setComposite(alphaComposite);
    }
}
