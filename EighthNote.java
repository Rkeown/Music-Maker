import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EighthNote here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EighthNote extends NoteSelection
{
    /**
     * Act - do whatever the EighthNote wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        changeNote();
    }  
    /**
     * changeNote access the noteLength variable from world and sets it equal to the name of this class
     * @param there are no parameters
     * @return nothing is returned
     */
        private void changeNote()
    {
        MyWorld world = (MyWorld) getWorld();
        
        
        if(Greenfoot.mouseClicked(this))
        {
            world.setNoteLength(8);
        }
    }
}
