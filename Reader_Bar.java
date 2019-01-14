import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reader_Bar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reader_Bar extends Actor
{
    private int spaceDelay = 8;
    private boolean pause = true;
    //public int tempo = 100;
    /**
     * Act - do whatever the Reader_Bar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        startScrolling();
        wall();
        playSound();
    }    
    private void startScrolling()
    {
        MyWorld world = (MyWorld)getWorld();
        int tempo = world.getTempo();
        if(spaceDelay >= 8 && Greenfoot.isKeyDown("Space"))
        {
            pause = !pause;
            spaceDelay = 0;
        }
        
        if( pause == false)
        {
            move(tempo);
        }
        
        spaceDelay++;
    }
    private void wall()
    {
        if(isAtEdge())
        {
         setLocation(154, getWorld().getHeight()/2);
        }
    }
    private void playSound()
    {
        if(pause == false)
        {
            if(isTouching(A.class))
            {
                Greenfoot.playSound("piano-a_A_major.wav");
            }
            if(isTouching(B.class))
            {
                Greenfoot.playSound("piano-b_B_major.wav");
            }
            if(isTouching(C.class))
            {
                Greenfoot.playSound("piano-c_C_major.wav");
            }
            if(isTouching(D.class))
            {
                Greenfoot.playSound("piano-d_D_major.wav");
            }
            if(isTouching(E.class))
            {
                Greenfoot.playSound("piano-e_E_major.wav");
            }
            if(isTouching(F.class))
            {
                Greenfoot.playSound("piano-f_F_major.wav");
            }
            if(isTouching(G.class))
            {
                Greenfoot.playSound("piano-g_G_major.wav");
            }
        }
    }
    }

