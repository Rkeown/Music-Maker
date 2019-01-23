import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reset extends Actor
{
    /**
     * Act - do whatever the Reset wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        resetObjects();
    }    
    /**
     * calls the reset function in world when clicked
     * @param there are no parameters
     * @return nothing is returned
     */
    private void resetObjects()
    {
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.mouseClicked(this))
        {
            world.reset();
        }
    }
}
