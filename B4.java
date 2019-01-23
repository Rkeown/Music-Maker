import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class B4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class B4 extends B
{
    /**
     * Act - do whatever the B4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveOver();
    }
    private void moveOver()
    {
        if( isTouching(A.class) && getX() > 149)
        {
            move(2); 
        }
        else if(isTouching(B.class)&& getX() > 149)
        {
            move(1);
        }
        else if(isTouching(C.class)&& getX() > 149)
        {
            move(1);
        }
        else if(isTouching(D.class)&& getX() > 149)
        {
            move(1);
        }
        else if(isTouching(E.class)&& getX() > 149)
        {
            move(1);
        }
        else if(isTouching(F.class)&& getX() > 149)
        {
            move(1);
        }
        else if(isTouching(G.class)&& getX() > 149)
        {
            move(1);
        }
    }
}
