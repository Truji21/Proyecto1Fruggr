import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoatSpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoatSpawner extends Actor
{
    int timer = 50;
    int newtimer = 150;
    int x = 1;
    int y = 1;
    
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
            BoatSpawn.Direction = 0;
            BoatSpawn.Speed = x;
            timer = newtimer;
            if(newtimer>70)
            {
            newtimer-=10;
            }
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
