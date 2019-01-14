import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{
    private int tempo = 5;

    private Actor[] notes = new Actor[]{ new A(), new B(), new C(), new D(), new E(), new F(), new G()};

    private int[] notesXLocations= new int[]{ 25, 75, 125, 25, 75, 125, 25, 75};

    private int[] notesYLocations = new int[]{375, 375, 375, 425, 425, 425, 475};

    private boolean mouseHeld = false;

    private Actor newNote;
    private int snapX;
    private int snapY;
    
    private boolean added = false;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1150, 500, 1); 
        choose();
        addObject(new Reset(),25,25);
        addObject(new Reader_Bar(), 154, getHeight()/2);
    }
    public boolean addedAgain()
    {
        return added;
    }
    public boolean mouseHeldAgain()
    {
        return mouseHeld;
    }
    public int snaps()
    {
        return snapX;
        
    }
    public int snapsAgain()
    {
        return snapY;
    }

    public int getTempo()
    {
        return tempo;
    }

    public void setTempo(int t)
    {
        tempo = t;
    }

    private void choose()
    {
        //addObject(new A(), 25, 375);
        //addObject(new B(), 75, 375);
        //addObject(new C(), 125, 375);
        //addObject(new D(), 25, 425);
        //addObject(new E(), 75, 425);
        //addObject(
        for( int i = 0; i < notes.length; i++)
        {
            addObject( notes[i], notesXLocations[i], notesYLocations[i]);
        }
    }

    public void act()
    {
        dragAndDrop();
    }

    public void dragAndDrop()
    {
        MouseInfo mouseLocation = Greenfoot.getMouseInfo();

        if( mouseHeld == false && Greenfoot.mousePressed(null) )
        {
            mouseHeld = true;

            if( mouseLocation.getX() > 0 && mouseLocation.getX() < 50 && mouseLocation.getY() > 350 && mouseLocation.getY() < 400)
            {
                newNote = new A();
                
                addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
            }
            else if( mouseLocation.getX() > 50 && mouseLocation.getX() < 100 && mouseLocation.getY() > 350 && mouseLocation.getY() < 400 )
            {
                newNote = new B();
                addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
            }
            else if( mouseLocation.getX() > 100 && mouseLocation.getX() < 150 && mouseLocation.getY() > 350 && mouseLocation.getY() < 400 )
            {
                newNote = new C();
                addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
            }
            else if( mouseLocation.getX() > 0 && mouseLocation.getX() < 50 && mouseLocation.getY() > 400 && mouseLocation.getY() < 450 )
            {
                newNote = new D();
                addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
            }
            else if( mouseLocation.getX() > 50 && mouseLocation.getX() < 100 && mouseLocation.getY() > 400 && mouseLocation.getY() < 450 )
            {
                newNote = new E();
                addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
            }
            else if( mouseLocation.getX() > 100 && mouseLocation.getX() < 150 && mouseLocation.getY() > 400 && mouseLocation.getY() < 450 )
            {
                newNote = new F();
                addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
            }
            else if( mouseLocation.getX() > 0 && mouseLocation.getX() < 50 && mouseLocation.getY() > 450 && mouseLocation.getY() < 500  )
            {
                newNote = new G();
                addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
            }
        }
        else if( Greenfoot.mouseClicked(null) || mouseLocation == null )
        {
            snapToGrid();
            
            mouseHeld = false;
            added = true;
            newNote = null;
        }

        if( mouseHeld == true && newNote != null )
        {
            newNote.setLocation( mouseLocation.getX(), mouseLocation.getY() );
        }
    }

    public void snapToGrid()
    {
        MouseInfo mouseLocation = Greenfoot.getMouseInfo();

        

        
        if(mouseLocation.getX() < 150 || mouseLocation.getX() > 150 && mouseLocation.getX() < 200)
        {
            snapX = 175; 
        }
        else if( mouseLocation.getX() > 200 && mouseLocation.getX() < 250)
        {
            snapX = 225;
        }
        else if( mouseLocation.getX() > 250 && mouseLocation.getX() < 300)
        {
            snapX = 275;
        }
        else if( mouseLocation.getX() > 300 && mouseLocation.getX() < 350)
        {
            snapX = 325;
        }
        else if( mouseLocation.getX() > 350 && mouseLocation.getX() < 400)
        {
            snapX = 375;
        }
        else if( mouseLocation.getX() > 400 && mouseLocation.getX() < 450)
        {
            snapX = 425;
        }
        else if( mouseLocation.getX() > 450 && mouseLocation.getX() < 500)
        {
            snapX = 475;
        }
        else if( mouseLocation.getX() > 500 && mouseLocation.getX() < 550)
        {
            snapX = 525;
        }
        else if( mouseLocation.getX() > 550 && mouseLocation.getX() < 600)
        {
            snapX = 575;
        }
                else if( mouseLocation.getX() > 600 && mouseLocation.getX() < 650)
        {
            snapX = 625;
        }
                else if( mouseLocation.getX() > 650 && mouseLocation.getX() < 700)
        {
            snapX = 675;
        }
        else if( mouseLocation.getX() > 700 && mouseLocation.getX() < 750)
        {
            snapX = 725;
        }
        else if( mouseLocation.getX() > 750 && mouseLocation.getX() < 800)
        {
            snapX = 775;
        }
        else if( mouseLocation.getX() > 800 && mouseLocation.getX() < 850)
        {
            snapX = 825;
        }
        else if( mouseLocation.getX() > 850 && mouseLocation.getX() < 900)
        {
            snapX = 875;
        }
        else if( mouseLocation.getX() > 900 && mouseLocation.getX() < 950)
        {
            snapX = 925;
        }
        else if( mouseLocation.getX() > 950 && mouseLocation.getX() < 1000)
        {
            snapX = 975;
        }
        else if( mouseLocation.getX() > 1000 && mouseLocation.getX() < 1050)
        {
            snapX = 1025;
        }
        else if( mouseLocation.getX() > 1050 && mouseLocation.getX() < 1100)
        {
            snapX = 1075;
        }
        else 
        {
            //if (mouseLocation.getX() > 1100 && mouseLocation.getX() < 1150)
            snapX = 1125;
        }
        
        if(mouseLocation.getY() > 0 && mouseLocation.getY() < 50)
        {
            snapY = 25;
        }
        else if(mouseLocation.getY() > 50 && mouseLocation.getY() < 100)
        {
            snapY = 75;
        }
        else if(mouseLocation.getY() > 100 && mouseLocation.getY() < 150)
        {
            snapY = 125;
        }
        else if(mouseLocation.getY() > 150 && mouseLocation.getY() < 200)
        {
            snapY = 175;
        }
        else if(mouseLocation.getY() > 200 && mouseLocation.getY() < 250)
        {
            snapY = 225;
        }
        else if(mouseLocation.getY() > 250 && mouseLocation.getY() < 300)
        {
            snapY = 275;
        }
        else if(mouseLocation.getY() > 300 && mouseLocation.getY() < 350)
        {
            snapY = 325;
        }
        else if(mouseLocation.getY() > 350 && mouseLocation.getY() < 400)
        {
            snapY = 375;
        }
        else if(mouseLocation.getY() > 400 && mouseLocation.getY() < 450)
        {
            snapY = 425;
        }
        else 
        {
            //if(mouseLocation.getY() > 450 && mouseLocation.getY() < 500)
            snapY = 475;
        }
        
        newNote.setLocation(snapX, snapY);
        
    }
}
