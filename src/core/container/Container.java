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
    static int gap;//the minimum distance between a zombie and a bullet

    public Bullet getFirstBullet() {
        return this.firstBullet;
    }

    public Plant getFirstPlant() {
        return this.firstPlant;
    }

    public Zombie getFirstZombie() {
        return this.firstZombie;
    }

    public void refresh(){
        findFirstBullet();
        findFirstPlant();
        findFirstZombie();
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

    //find the first plant in a line
    public void findFirstPlant() {
        if (plants.isEmpty()) {
            firstPlant = null;
            return;
        }
        firstPlant = plants.get(0);
        for (int i = 1; i < plants.size(); i++) {
            if(firstPlant.getPosition_x()<plants.get(i).getPosition_x())
                firstPlant=plants.get(i);
        }
    }

    //find the first plant before a zombie
    public Plant findFirstPlant(Zombie z){
        tmpPlant=null;
        if(plants.isEmpty())
            return null;
        for(i=0;i<plants.size();i++){
            if(plants.get(i).getPosition_x()<z.getPosition_x()){
                if(tmpPlant==null)
                    tmpPlant=plants.get(i);
                else
                    if(plants.get(i).getPosition_x()>tmpPlant.getPosition_x())
                        tmpPlant=plants.get(i);
            }
        }
        return tmpPlant;
    }

    //find the first zombie in a line
    public void findFirstZombie() {
        if (zombies.isEmpty()) {
            firstZombie = null;
            return;
        }
        firstZombie = zombies.get(0);
        for (int i = 1; i < zombies.size(); i++) {
            if(firstZombie.getPosition_x()>zombies.get(i).getPosition_x())
                firstZombie=zombies.get(i);
        }
    }

    //find the first zombie before a bullet
    public Zombie findFirstZombie(Bullet b){
        tmpZombie=null;//reset tmpZombie
        if(zombies.isEmpty())
            return null;
        for(i=0;i<zombies.size();i++){
            if(zombies.get(i).getPosition_x()>b.getPosition_x()){
                if(tmpZombie==null)
                    tmpZombie=zombies.get(i);
                else
                    if(zombies.get(i).getPosition_x()<tmpZombie.getPosition_x())
                        tmpZombie=zombies.get(i);
            }

        }
        return tmpZombie;
    }

    //view all the bullets
    public void bulletCheck(){
        if(bullets.isEmpty())
            return;
        for(i=0;i<bullets.size();i++){
            tmpBullet=bullets.get(i);
            //it fly away
//            if(tmpBullet.getPosition_x()>?){
//                deleteBullet(tmpBullet);
//                tmpBullet=null;
//                continue;;
//            }

            //it hits a zombie
            tmpZombie=findFirstZombie(tmpBullet);
            if(tmpZombie!=null){
                if(tmpZombie.getPosition_x()-tmpBullet.getPosition_x()<gap){
                    tmpBullet.collision(tmpZombie);
                    deleteBullet(tmpBullet);
                    tmpBullet=null;
                }
            }

        }
    }

    public void addBullet(int position_x, int position_y,boolean ice) {
        tmpBullet = new Bullet(position_x,position_y, ice);
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

    //undone
    //everything goes
    public boolean move(){


        return false;
    }


}