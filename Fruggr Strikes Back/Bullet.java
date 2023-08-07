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
    boolean hitenemy = false;
    
    public void act()
    {        
        setRotation(Direction);
        move(5);
        hit();
    }
    
    //The worst way to code damage ever
    public void hit()
    {
        Car EnemyCar = (Car)getOneIntersectingObject(Car.class);
        Boat EnemyBoat = (Boat)getOneIntersectingObject(Boat.class);
        
        if (EnemyCar != null)
        {
            EnemyCar.damage();
            getWorld().removeObject(this);
        }else{
        if (EnemyBoat != null)
        {
            EnemyBoat.damage();
            getWorld().removeObject(this);
        }else{
            destroy();
        }
    }
    }
    
    public void destroy()
    {
        if(isTouching(Wall.class) || getY() == 575)
        {
            getWorld().removeObject(this);
        }
    }
}
