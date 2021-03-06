import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TempoDown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempoDown extends Actor
{
    /**
     * Act - do whatever the TempoDown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        tempoDown();
    }    
    /**
     * tempoDown accesses the decreaseTempo method from world when clicked
     * @param there are no parameters
     * @return nothing is returned
     */
        private void tempoDown()
    {
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.mouseClicked(this))
        {
            world.decreaseTempo();
        }
    }
}
