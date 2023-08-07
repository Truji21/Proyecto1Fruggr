import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoatSpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoatSpawner extends Actor
{
    int timer = 30;
    int newtimer = 100;
    int x = 1;
    int y = 1;
    int timerlimit = 0;
    MyWorld Game;
    
    public void act()
    {
        SetTimerLimit();
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
    
    private void SetTimerLimit()
    {
        switch(Game.level){
            case 1:
                timerlimit = 100;
            case 2:
                timerlimit = 90;
            case 3:
                timerlimit = 80;
            case 4:
                timerlimit = 70;
            case 5:
                timerlimit = 60;
            case 6:
                timerlimit = 50;
            case 7:
                timerlimit = 40;
            case 8:
                timerlimit = 30;
            case 9:
                timerlimit = 20;
            case 10:
                timerlimit = 10;
            default:
                timerlimit = 100;
        }
    }
}
