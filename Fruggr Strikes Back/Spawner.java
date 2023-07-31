import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    int timer = 50;
    int newtimer = 200;
    
    public void act()
    {
        SpawnEnemy();
        timer--;
    }
    
    public void SpawnEnemy()
    {
        if(timer<=0)
        {
            Car CarSpawn = new Car();
            getWorld().addObject(CarSpawn,getX(),getY());
            CarSpawn.Direction = 0;
            timer = newtimer;
            if(newtimer>70)
            {
            newtimer-=10;
            }
        }
    }
}
