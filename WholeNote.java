import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WholeNote here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WholeNote extends NoteSelection
{
    /**
     * Act - do whatever the WholeNote wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        changeNote();
    }    
    private void changeNote()
    {
        MyWorld world = (MyWorld) getWorld();
        
        
        if(Greenfoot.mouseClicked(this))
        {
            world.setNoteLength(1);
        }
    }
}
