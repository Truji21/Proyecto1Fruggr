import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoatSpawner2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoatSpawner2 extends Actor
{
    int timer = 10;
    int newtimer = 100;
    int x = 1;
    int y = 1;
    int timerlimit = 0;
    MyWorld Game;
    
    public void act()
    {
        GetRandomNumber();
        TimerDecrease();
        SpawnEnemy();
    }
    
    public void SpawnEnemy()
    {
        if(timer<=0)
        {
            Boat BoatSpawn = new Boat();
            getWorld().addObject(BoatSpawn,getX(),getY());
            BoatSpawn.Direction = 180;
            BoatSpawn.Speed = x;
            if(newtimer>70)
            {
            newtimer-=10;
            }
            timer = newtimer;
        }
    }
    
    /**
     * Da números aleatorios para cambiar las condiciones bajo las que se crean autos
     */
    public void GetRandomNumber()
    {
        x = Greenfoot.getRandomNumber(3) + 2; // para cambiar la velocidad del auto creado
        y = Greenfoot.getRandomNumber(2); //Para cambiar un poco los intervalos de tiempo
    }
    
    public void TimerDecrease()
    {
        if(y == 1){
        timer--;
        }
    }
}
