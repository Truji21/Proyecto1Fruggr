import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Vehicle
{
    int Direction = 0;
    int Health = 100;
    int Speed = 3;
    MyWorld Game;
    
    public void act()
    {
        setRotation(Direction);
        move(Speed);
    }
    
    public void damage(){
        Bullet bullet = new Bullet();
            Health -= bullet.damage;
        
        if(Health<=0)
        {
            getWorld().removeObject(this);
            Game.score += 500;
        }
    }
}
