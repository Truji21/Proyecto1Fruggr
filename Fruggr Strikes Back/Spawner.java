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
    int newtimer = 150;
    int x = 1;
    int y = 1;
    int timerlimit = 70;
    
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
            Car CarSpawn = new Car();
            getWorld().addObject(CarSpawn,getX(),getY());
            CarSpawn.Direction = 0;
            CarSpawn.Speed = x;
            timer = newtimer;
            if(newtimer > timerlimit)
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