import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Boat extends Vehicle
{
    int Direction = 0;
    int Health = 100;
    int smoketimer = 0;
    int Speed = 3;
    int WallIF = 200;
    MyWorld Game;
    
    public void act()
    {
        setRotation(Direction);
        move(Speed);
        leavesmoke();
        smoketimer--;
        wallcheck(); //get walled idiot
        WallIF--;
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
    
    public void leavesmoke(){
        Smoke Puff = new Smoke();
        
        if(smoketimer<=0)
        {
            getWorld().addObject(Puff,getX(),getY());
            smoketimer = 20;
        }
    }
    
    private void wallcheck(){
        if(getX() == 0 || getX() == 639){
            getWorld().removeObject(this);
        }
    }
}
