package core.container;

import core.bullets.Bullet;
import core.plants.Plant;
import core.zombies.Zombie;

import java.util.ArrayList;

/*
each container contains all of a line

 */
public class Container {
    private Bullet firstBullet = null;
    private Plant firstPlant = null;
    private Zombie firstZombie = null;
    private Bullet tmpBullet = null;
    private Plant tmpPlant = null;
    private Zombie tmpZombie = null;
    private int i;//the counter
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<Zombie> zombies = new ArrayList<>();
    private ArrayList<Plant> plants = new ArrayList<>();

    public Bullet getFirstBullet() {
        return this.firstBullet;
    }

    public Plant getFirstPlant() {
        return this.firstPlant;
    }

    public Zombie getFirstZombie() {
        return this.firstZombie;
    }

    public void findFirstBullet() {
        if (bullets.isEmpty()) {
            firstBullet = null;
            return;
        }
        firstBullet = bullets.get(0);
        for (int i = 1; i < bullets.size(); i++) {
            if (firstBullet.getPosition_x() < bullets.get(i).getPosition_x())
                firstBullet = bullets.get(i);
        }
    }

    //undone
    public void findFirstPlant() {
        if (plants.isEmpty()) {
            firstPlant = null;
            return;
        }
        firstPlant = plants.get(0);
        for (int i = 1; i < plants.size(); i++) {

        }
    }

    //undone
    public void findFirstZombie() {
        if (zombies.isEmpty()) {
            firstZombie = null;
            return;
        }
        firstZombie = zombies.get(0);
        for (int i = 1; i < zombies.size(); i++) {

        }
    }

    public void addBullet(int position_x, boolean ice) {
        tmpBullet = new Bullet(position_x, ice);
        bullets.add(tmpBullet);
        tmpBullet = null;
    }

    //undone
    public void addPlant(){

    }

    //undone
    public void addZombie(){

    }

    //delete the bullet
    //after using this function, make the reference null
    public boolean deleteBullet(Bullet b) {
        for (i = 0; i < bullets.size(); i++)
            if (bullets.get(i).equals(b)) {
                bullets.remove(i);
                return true;
            }
        return false;
    }

    //delete the plant
    //after using this function, make the reference null
    public boolean deletePlant(Plant p) {
        for (i = 0; i < plants.size(); i++)
            if (plants.get(i).equals(p)) {
                plants.remove(i);
                return true;
            }
        return false;
    }

    //delete the zombie
    //after using this function, make the reference null
    public boolean deleteZombie(Zombie z){
        for(i=0;i<zombies.size();i++)
            if(zombies.get(i).equals(z)){
                zombies.remove(i);
                return true;
            }
        return false;
    }
}