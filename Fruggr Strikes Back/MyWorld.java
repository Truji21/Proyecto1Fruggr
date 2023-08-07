import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static int score = 0;
    public static int health = 3;
    public static int level = 1;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 576, 1);
        prepare();
    }
    
    public void act()
    {
        showText("Score: " + score,90,17);
        showText("Health: " + health, 200, 17);
        showText("Level: " + level, 88, 43);
        setPaintOrder(Frogger.class, Bullet.class, Boat.class, Smoke.class);
    }
    
    private void prepare()
    {
        Frogger player = new Frogger();
        addObject(player,307,276);
        player.setLocation(320,544);

        Wallhor wall = new Wallhor();
        addObject(wall, 307,0);
        wall.setLocation(320,50);

        Spawner spawner = new Spawner();
        addObject(spawner,0,417);

        Spawner2 spawner2 = new Spawner2();
        addObject(spawner2,639,484);

        BoatSpawner boatSpawner = new BoatSpawner();
        addObject(boatSpawner,5,158);

        BoatSpawner2 boatSpawner2 = new BoatSpawner2();
        addObject(boatSpawner2,639,226);

        Wallhor wallhor2 = new Wallhor();

        wallver wallver = new wallver();
        addObject(wallver,639,286);

        wallver wallver2 = new wallver();
        addObject(wallver2,0,286);
    }
    
    
}
