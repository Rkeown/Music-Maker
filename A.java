import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class A here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class A extends Actor
{
    public void act()
    {
        snap();

    }

    public void snap()
    {
        MyWorld world = (MyWorld) getWorld();
        
        world.addedAgain();

        MouseInfo mouseLocation = Greenfoot.getMouseInfo();

        boolean added = world.addedAgain();
        boolean mouseHeld = world.mouseHeldAgain();
        int snapX = world.snaps();
        int snapY = world.snapsAgain();
        if(mouseHeld == true && added == false   )
        {
            added = true;
        }
  

    }
}
