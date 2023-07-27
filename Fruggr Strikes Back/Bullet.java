import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int Direction = 0;
    int damage = 35;
    
    public void act()
    {        
        setRotation(Direction);
        move(5);
    }
}
