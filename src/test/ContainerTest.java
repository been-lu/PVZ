package test;

import core.bullets.Bullet;
import core.container.Container;

public class ContainerTest {
    public static void main(String[] args) {
        Container c1=new Container();
        c1.addBullet(0,false);
        c1.addPlant();
        c1.addZombie();
       // c1.refresh();
    }
}
