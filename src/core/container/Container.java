package core.container;

import core.bullets.Bullet;
import core.plants.Plant;
import core.zombies.Zombie;

import java.util.ArrayList;

/*
each container contains all of a line

 */
public class Container {
    private Bullet firstBullet;
    private Plant firstPlant;
    private Zombie firstZombie;
    private Bullet tmpBullet;
    private Plant tmpPlant;
    private Zombie tmpZombie;
    private ArrayList<Bullet> bullets=new ArrayList<>();
    private ArrayList<Zombie> zombies=new ArrayList<>();
    private ArrayList<Plant> plants=new ArrayList<>();



}
