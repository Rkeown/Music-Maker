import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TempoUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempoUp extends Actor
{
    /**
     * Act - do whatever the TempoUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        changeTempo();
    }    
    private void changeTempo()
    {
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.mousePressed(this))
        {
          world.changeTempo();  
        }
    }
}
