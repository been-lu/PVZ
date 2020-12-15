package frame.mainwindow;

import com.sun.tools.javac.Main;
import frame.gamewindow.GameWindow;
import test.Test0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.KeyStore;

public class MainListener extends MouseAdapter {
    public MainListener() {
    }

    public void mouseMoved(MouseEvent e) {
        if (e.getX() >= 480 && e.getX() <= 760 && e.getY() >= 60 && e.getY() <= 202){
            MainWindow.image1=MainWindow.maoxian_1;
            Test0.p.setCursor(Cursor.DEFAULT_CURSOR);
        }else{
            MainWindow.image1=MainWindow.maoxian;
            Test0.p.setCursor(Cursor.DEFAULT_CURSOR);
        }
    }

    public void mouseClicked(MouseEvent e){
        if (e.getX() >= 470 && e.getX() <= 800 && e.getY() >= 60 && e.getY() <= 202){
            Test0.p.remove(Test0.m);
            Test0.p2=new GameWindow();
            Test0.p2.Action();
            Test0.p.add(Test0.p2);
            Test0.p.repaint();
          //  Test0.p2.requestFocus();
            Test0.p.setVisible(true);
        }
    }

}
