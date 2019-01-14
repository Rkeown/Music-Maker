import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class B here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class B extends Actor
{
    /**
     * Act - do whatever the B wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //snap();
    }
    public void snap()
 {
     MyWorld world = (MyWorld) getWorld();
     world.snapToGrid();
     
     MyWorld world2 = (MyWorld) getWorld();
     world2.dragAndDrop();
     MyWorld world3 = (MyWorld)getWorld();
     world3.addedAgain();
     
     boolean added = ((MyWorld) getWorld()).addedAgain();
     boolean mouseHeld = ((MyWorld) getWorld()).mouseHeldAgain();
     int snapX = ((MyWorld) getWorld()).snaps();
     int snapY = ((MyWorld) getWorld()).snapsAgain();
     if(mouseHeld == true && added == false)
     {
         setLocation(snapX, snapY);
         added = true;
         
         if(mouseHeld == false)
         {
             getWorld().addObject(new A(),25, 375);
         }
     }
 }
}
