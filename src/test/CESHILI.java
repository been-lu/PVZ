package test;

import frame.gamewindow.GameWindow;
import frame.mainwindow.MainWindow;

import javax.swing.*;
import java.awt.*;

public class CESHILI extends JFrame
{
    public static MainWindow m = new MainWindow();
    public static CESHILI p;
    public static GameWindow p2;

    public CESHILI()
    {
        this.setSize(900, 630);
        this.setLocation(0, 0);
        this.add(m);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        p = new CESHILI();
    }
}
