import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AmmoPack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AmmoPack extends Actor
{
    MyWorld Game;
    
    public void act()
    {
        if(isTouching(Frogger.class)){
            getWorld().removeObject(this);
            Game.ammo += 25;
            Game.score += 200;
            Greenfoot.playSound("battery.wav");
        }
    }
}
