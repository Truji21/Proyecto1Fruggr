import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smoke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smoke extends Actor
{
    int deltimer = 50;
    
    public void act()
    {
        delete();
        deltimer--;
    }
    
    public void delete()
    {
        if(deltimer<=0)
        {
            getWorld().removeObject(this);
            deltimer = 50;
        }
    }
}
