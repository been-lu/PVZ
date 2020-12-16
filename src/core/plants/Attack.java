package core.plants;

import core.bullets.Bullet;
import core.zombies.Zombie;

import java.util.ArrayList;

public interface Attack {
    public boolean attack(ArrayList<Zombie> zombies, ArrayList<Bullet> bullets);
}
