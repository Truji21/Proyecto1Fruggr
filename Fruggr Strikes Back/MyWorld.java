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
    public static int ammo = 50;
    public static int timer = 55*100;
    GreenfootSound backgroundMusic = new GreenfootSound("Bit Shift.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 576, 1);
        prepare();
        backgroundMusic.playLoop();
    }   
    
    public void act()
    {
        scoremin();
        showText("Score: " + score,90,17);
        showText("Health: " + health, 200, 17);
        showText("Level: " + level, 88, 43);
        showText("Ammo: " + ammo, 450, 17);
        timerupdate();
        showText("Time: " + updatedtimervalue(), 450, 43);
        setPaintOrder(Frogger.class, Bullet.class, Boat.class, Smoke.class);
    }
    
    private void timerupdate(){
        if (timer > 0) timer--;
        if (timer % 55 == 0) updatedtimervalue();
    }
    
    private void scoremin(){
        if (score < 0) score = 0;
    }
    
    private int updatedtimervalue()
    {
        return timer/55;
}
    
    public void newammopack(){
        AmmoPack ammo = new AmmoPack();
        addObject(ammo, 10,10);
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
        Goal goal = new Goal();
        addObject(goal,324,93);
        goal.setLocation(322,98);
        goal.setLocation(327,100);
        goal.setLocation(327,94);
        goal.setLocation(322,94);
        goal.setLocation(325,91);
        goal.setLocation(324,99);
        goal.setLocation(326,94);
        Tree tree = new Tree();
        addObject(tree,267,94);
        Tree tree2 = new Tree();
        addObject(tree2,390,93);
        Tree tree3 = new Tree();
        addObject(tree3,212,93);
        Tree tree4 = new Tree();
        addObject(tree4,440,92);
        Tree tree5 = new Tree();
        addObject(tree5,491,92);
        Tree tree6 = new Tree();
        addObject(tree6,538,92);
        Tree tree7 = new Tree();
        addObject(tree7,581,92);
        Tree tree8 = new Tree();
        addObject(tree8,625,91);
        Tree tree9 = new Tree();
        addObject(tree9,163,92);
        Tree tree10 = new Tree();
        addObject(tree10,116,91);
        Tree tree11 = new Tree();
        addObject(tree11,65,90);
        Tree tree12 = new Tree();
        addObject(tree12,16,91);
    }
    
    
}
