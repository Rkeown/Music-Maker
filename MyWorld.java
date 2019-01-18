import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{
    private int tempo = 99;
    private int noteLength = 4;

    private Actor[] notes = new Actor[]{ new A(), new B(), new C(), new D(), new E(), new F(), new G()};

    private int[] notesXLocations= new int[]{ 25, 75, 125, 25, 75, 125, 25, 75};

    private int[] notesYLocations = new int[]{375, 375, 375, 425, 425, 425, 475};

    private Actor[] noteSelection = new Actor[]{new WholeNote(), new HalfNote(), new QuaterNote(), new EighthNote()};

    private int[] noteSelectionX = new int[]{25, 25, 25, 25};
    private int[] noteSelectionY = new int[]{175, 225, 275, 325};
    private boolean mouseHeld = false;

    private Actor newNote;

    private Reset reset = new Reset();
    private Reader_Bar readerBar = new Reader_Bar();
    private TempoUp tempoUp = new TempoUp();
    private TempoDown tempoDown = new TempoDown();
    private WholeNote wholeNote = new WholeNote();

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
        addAll();
        displayTempo();
        increaseTempo();
        displayNoteType();
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

    public int noteLengthReturn()
    {
        return noteLength;
    }

    private void addAll()
    {

        addObject(reset,25,25);
        addObject(readerBar, 154, getHeight()/2);
        addObject(tempoUp,75, 475);
        addObject(tempoDown, 125, 475);
        for( int i = 0; i < notes.length; i++)
        {
            addObject( notes[i], notesXLocations[i], notesYLocations[i]);
        }
        for( int i = 0; i < noteSelection.length; i++)
        {
            addObject( noteSelection[i], noteSelectionX[i], noteSelectionY[i]);
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

            if( Greenfoot.mousePressed(reset) == false && Greenfoot.mousePressed(readerBar) == false && 
            Greenfoot.mousePressed(tempoUp) == false && Greenfoot.mousePressed(tempoDown) == false &&
            Greenfoot.mousePressed(wholeNote) == false)
            {

                if( mouseLocation.getX() > 0 && mouseLocation.getX() < 50 && mouseLocation.getY() > 350 && mouseLocation.getY() < 400)
                {
                    if(noteLength == 2)
                    {
                        newNote = new A2();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if(noteLength == 4)
                    {
                        newNote = new A4();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if( noteLength == 8)
                    {
                        newNote = new A8();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if (noteLength == 1)
                    {
                        newNote = new A();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
                    }
                }
                else if( mouseLocation.getX() > 50 && mouseLocation.getX() < 100 && mouseLocation.getY() > 350 && mouseLocation.getY() < 400 )
                {
                    if(noteLength == 2)
                    {
                        newNote = new B2();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if(noteLength == 4)
                    {
                        newNote = new B4();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if( noteLength == 8)
                    {
                        newNote = new B8();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else 
                    {
                        newNote = new B();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
                    }
                }
                else if( mouseLocation.getX() > 100 && mouseLocation.getX() < 150 && mouseLocation.getY() > 350 && mouseLocation.getY() < 400 )
                {
                             if(noteLength == 2)
                    {
                        newNote = new C2();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if(noteLength == 4)
                    {
                        newNote = new C4();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if( noteLength == 8)
                    {
                        newNote = new C8();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else
                    {
                    newNote = new C();
                    addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
                    }
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
        }
        else if( newNote != null && (Greenfoot.mouseClicked(null) || mouseLocation == null) )
        {

            snapToGrid();
            snapShift();
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

        if( newNote != null )
        {
            newNote.setLocation(snapX, snapY);
        }

    }

    private void snapShift()
    {
        if( noteLength == 2)
        {
            newNote.setLocation(newNote.getX()-13,newNote.getY());
        }
        else if( noteLength == 4)
        {
            newNote.setLocation(newNote.getX()-19,newNote.getY());
        }
        else if (noteLength == 8)
        {
            newNote.setLocation(newNote.getX()-22,newNote.getY());
        }

    }

    private void displayTempo()
    {
        showText("Tempo  " + tempo , 60, 90);

    }

    private void displayNoteType()
    {
        showText(" Note Length " + noteLength , 66, 115);
    }

    public void increaseTempo()
    {
        tempo++;
        displayTempo();
    }

    public void decreaseTempo()
    {
        tempo--;
        displayTempo();
    }

    public void reset()
    {
        List allObjects = getObjects(null);
        removeObjects(allObjects);
        addAll();
    }

    public void setNoteLength( int length )
    {
        noteLength = length;
        displayNoteType();
    }
}
