import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frogger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frogger extends Actor
{
    private int speed = 64; //The distance covered, don't touch this.
    public int tears = 15;
    public int newtears = 15; //The lower the faster you shoot
    public int health = 3; //Character health, you die when it reaches 0
    long curTime  = System.currentTimeMillis(); //Not used (yet)
    int weapon = 0; //Will be used if more weapons are added, currently useless
    int InvincibilityTimer = 0; //invincibility frames
    int HopCoolDown = 35; 
    int NewHop = 30; //The lower this is the faster you can move
    boolean PlayerAlive = true; //You're either dead or alive
    
    MyWorld Game;
    
    //Sprites
    GreenfootImage playerup = new GreenfootImage("PlayerU.png");
    GreenfootImage playerdown = new GreenfootImage("PlayerD.png");
    GreenfootImage playerleft = new GreenfootImage("PlayerL.png");
    GreenfootImage playerright = new GreenfootImage("PlayerR.png");
    GreenfootImage playerdead = new GreenfootImage("PlayerDead.png");
    
    public void act()
    {
        if(PlayerAlive == true)
        {
        movement();
        shoot();
        damage();
        checkdead();
        InvincibilityTimer--;
        tears--;
        HopCoolDown--;
        timesup();
        Goal();
        }
        else
        {
         setLocation(getX(), getY()-1);
         if(TouchingWall()){
                setLocation(getX(), getY()+speed);
                getWorld().removeObject(this);
            }
        }
        Game.health = health;
    }
    
    /**
     * These control the direction you're running in and the sprite that will be used
     * depending on the direction, 
     */
    private void movement(){      
        if (Greenfoot.isKeyDown("D") && HopCoolDown<=0)
        {
            setLocation(getX()+speed, getY());
            if(TouchingWall()){
                setLocation(getX()-speed, getY());
            }
            setImage(playerright);
            HopCoolDown = NewHop;
        }
        
        if (Greenfoot.isKeyDown("A") && HopCoolDown<=0)
        {
            setLocation(getX()-speed, getY());
            if(TouchingWall()){
                setLocation(getX()+speed, getY());
            }
            
            setImage(playerleft);
            HopCoolDown = NewHop;
        }
        
        if (Greenfoot.isKeyDown("W") && HopCoolDown<=0)
        {
            setLocation(getX(), getY()-speed);
            if(TouchingWall()){
                setLocation(getX(), getY()+speed);
            }
            
            setImage(playerup);
            HopCoolDown = NewHop;
        }
        
        if (Greenfoot.isKeyDown("S") && HopCoolDown<=0)
        {
            setLocation(getX(), getY()+speed);
            //set up like this so fruggr can move freely without a wall at the bottom
            if(getY() > 550){
                setLocation(getX(), 544); //set to 544 so fruggr can return to the lane correctly
            }
            
            setImage(playerdown);
            HopCoolDown = NewHop;
        }
    }
    
    /**
     * If you touch a wall you'll be sent back
     */
    private boolean TouchingWall(){
        if(isTouching(Wall.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * This is used forshooting, the character sprite will always face the direction you're
     * shooting, even if you're moving.
     */
    public void shoot(){
        if (Greenfoot.isKeyDown("right"))
        {
            setImage(playerright);
            Bullet bolt = new Bullet();
            weaponuse();
            if (tears > 0 && --tears > 0) return;
            if (Game.ammo == 0) return;
            bolt.Direction = 0;
            tears = newtears;
            getWorld().addObject(bolt,getX(),getY());
            Game.ammo --;
            Greenfoot.playSound("shoot.wav");
        }
        
        if (Greenfoot.isKeyDown("left"))
        {
            setImage(playerleft);
            Bullet bolt = new Bullet();
            weaponuse();
            if (tears > 0 && --tears > 0) return;
            if (Game.ammo == 0) return;
            bolt.Direction = 180;
            tears = newtears;
            getWorld().addObject(bolt,getX(),getY());
            Game.ammo --;
            Greenfoot.playSound("shoot.wav");
        }
        
        if (Greenfoot.isKeyDown("up"))
        {
            setImage(playerup);
            Bullet bolt = new Bullet();
            weaponuse();
            if (tears > 0 && --tears > 0) return;
            if (Game.ammo == 0) return;
            bolt.Direction = 270;
            tears = newtears;
            getWorld().addObject(bolt,getX(),getY());
            Game.ammo --;
            Greenfoot.playSound("shoot.wav");
        }
        
        if (Greenfoot.isKeyDown("down"))
        {
            setImage(playerdown);
            Bullet bolt = new Bullet();
            weaponuse();
            if (tears > 0 && --tears > 0) return;
            if (Game.ammo == 0) return;
            bolt.Direction = 90;
            tears = newtears;
            getWorld().addObject(bolt,getX(),getY());
            Game.ammo --;
            Greenfoot.playSound("shoot.wav");
        }
    }
    
    public void weaponuse()
    {
        switch(weapon){
            case 1:
                Bullet bolt = new Bullet();
            default:
                weapon = 1;
                //Only one weapon currently, might add more if there's time
        }
    }
    
    public void damage()
    {
        if(isTouching(Vehicle.class) || isTouching(Smoke.class)){
            if(InvincibilityTimer<=0)
            {
                health--;
                Game.score -= 1500;
                InvincibilityTimer = 50;
            }
        }
    }
    
    private void timesup(){
        if(Game.timer == 0) health = 0;
    }
    
    public void checkdead()
    {
        if(health <= 0){
            setImage(playerdead);
            PlayerAlive = false;
        }
    }
    
    /**
     * If you touch the goal you go to the start and begin the next level
     */
    private void Goal(){
        if(isTouching(Goal.class)){
            setLocation(320, 544);
            
            //Switch doesn't work for some reason so a bunch of ifs it is
            if(Game.level == 1) Game.timer = 55*100;
            if(Game.level == 2) Game.timer = 55*90;
            if(Game.level == 3) Game.timer = 55*80;
            if(Game.level == 4) Game.timer = 55*70;
            if(Game.level == 5) Game.timer = 55*60;
            if(Game.level == 6) Game.timer = 55*50;
            if(Game.level == 7) Game.timer = 55*40;
            if(Game.level == 8) Game.timer = 55*30;
            if(Game.level == 9) Game.timer = 55*20;
            if(Game.level == 10) Game.timer = 55*20;
            
            if(Game.level < 10) Game.level++; //lvl 10 is the end
            if(Game.level < 7) health = 3; //No health recovery from lvl 7 onwards
            
            int x = Greenfoot.getRandomNumber(620)+10;
            int y = Greenfoot.getRandomNumber(456)+100;
            AmmoPack ammo = new AmmoPack();
            getWorld().addObject(ammo,x,y);
            Game.score += 1000;
            Greenfoot.playSound("goal.wav");
        }
    }
}
