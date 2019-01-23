import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * MyWorld has all the code for the notes to know who they are, what length they are, and where they are, as well as the snapping map and variables.
 * 
 * @author Rory Keown
 * @version v10, January 22 2019
 */
public class MyWorld extends greenfoot.World
{
    //tempo of your song
    private int tempo = 99;
    //changes depending on the note length to tell the game which note to add
    private int noteLength = 4;
    //array for adding each note to the selection area
    private Actor[] notes = new Actor[]{ new A(), new B(), new C(), new D(), new E(), new F(), new G()};
    //array for the X location of the selector notes
    private int[] notesXLocations= new int[]{ 25, 75, 125, 25, 75, 125, 25, 75};
    //array for the Y location of the selector 
    private int[] notesYLocations = new int[]{375, 375, 375, 425, 425, 425, 475};
    //array for the Names of each note to be added over top
    private String[] noteNames = new String[]{"A", "B", "C", "D", "E", "F", "G"};
    // array that adds the note length selectors
    private Actor[] noteSelection = new Actor[]{new WholeNote(), new HalfNote(), new QuaterNote(), new EighthNote()};
    //array for the note selection boxes X locations
    private int[] noteSelectionX = new int[]{25, 25, 25, 25};
    //array for the note selection boxes Y locations
    private int[] noteSelectionY = new int[]{175, 225, 275, 325};
    //boolean for telling the program to let go of the notes
    private boolean mouseHeld = false;
    // Tells the program which note has been selected so that it can add it
    private Actor newNote;
    //calls so that I don't get errors from clicking any of the action buttons
    private Reset reset = new Reset();
    private Reader_Bar readerBar = new Reader_Bar();
    private TempoUp tempoUp = new TempoUp();
    private TempoDown tempoDown = new TempoDown();
    private WholeNote wholeNote = new WholeNote();
    //the X location that each note uses to snap to the grid
    private int snapX;
    // the Y loaction that each note uses to snap to the grid
    private int snapY;
    //not quite sure what it does anymore but deleting it causes an error ¯\_(ツ)_/¯
    private boolean added = false;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        //sets up the sizd of the world
        super(1150, 500, 1); 
        //the method that adds everything to the world
        addAll();
        //method to show off my cool tempo counter(that's not actually that cool)
        displayTempo();
        // a method to increase the tempo
        increaseTempo();
        //a method that appears over the different notes to show which is which
        displayNoteType();
    }



 

   

   
    /**
     * getTempo returns the tempo so that the reader bar moves at the speed of the tempo
     * @param there are no parameters
     * @return it returns an intiger which just so happens to be the tempo
     */
    public int getTempo()
    {
        return tempo;
    }
    
     
    /**
     * noteLengthReturn lets other classes access noteLength
     * @param there are no parameters
     * @return it returns an intiger which is noteLength
     */
    public int noteLengthReturn()
    {
        return noteLength;
    }
    /**
     * addAll just adds everything to the world
     * @param there are no parameters
     * @return there are no returns
     */
    private void addAll()
    {

        addObject(reset,25,25);
        addObject(readerBar, 154, getHeight()/2);
        addObject(tempoUp,75, 475);
        addObject(tempoDown, 125, 475);
        for( int i = 0; i < notes.length; i++)
        {
         showText(noteNames[i], notesXLocations[i], notesYLocations[i]);
        }
        for( int i = 0; i < notes.length; i++)
        {
            addObject( notes[i], notesXLocations[i], notesYLocations[i]);
        }
        for( int i = 0; i < noteSelection.length; i++)
        {
            addObject( noteSelection[i], noteSelectionX[i], noteSelectionY[i]);
        }

    }
    /**
     *  the act method that runs what ever is in it once per cycle
     *  @param there are no parameters
     *  @return there is no returns
     */
    public void act()
    {
        dragAndDrop();
    }
    /**
     * dragAndDrop has all the code to tell the program how to drag and drop each type of note
     * @param there are no parmeters
     * @return there are no returns
     */
    public void dragAndDrop()
    {
        MouseInfo mouseLocation = Greenfoot.getMouseInfo();

        if( mouseHeld == false && Greenfoot.mousePressed(null) )
        {

            mouseHeld = true;

            if( Greenfoot.mousePressed(reset) == false && Greenfoot.mousePressed(readerBar) == false && 
            Greenfoot.mousePressed(tempoUp) == false && Greenfoot.mousePressed(tempoDown) == false &&
            Greenfoot.mousePressed(getObjects(NoteSelection.class)) == false)
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
                    if(noteLength == 2)
                    {

                        newNote = new D2();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if(noteLength == 4)
                    {
                        newNote = new D4();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if( noteLength == 8)
                    {
                        newNote = new D8();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if (noteLength == 1)
                    {
                        newNote = new D();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
                    }
                }
                else if( mouseLocation.getX() > 50 && mouseLocation.getX() < 100 && mouseLocation.getY() > 400 && mouseLocation.getY() < 450 )
                {
                    if(noteLength == 2)
                    {

                        newNote = new E2();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if(noteLength == 4)
                    {
                        newNote = new E4();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if( noteLength == 8)
                    {
                        newNote = new E8();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if (noteLength == 1)
                    {
                        newNote = new E();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
                    }
                }
                else if( mouseLocation.getX() > 100 && mouseLocation.getX() < 150 && mouseLocation.getY() > 400 && mouseLocation.getY() < 450 )
                {
                    if(noteLength == 2)
                    {

                        newNote = new F2();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if(noteLength == 4)
                    {
                        newNote = new F4();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if( noteLength == 8)
                    {
                        newNote = new F8();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if (noteLength == 1)
                    {
                        newNote = new F();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
                    }
                }
                else if( mouseLocation.getX() > 0 && mouseLocation.getX() < 50 && mouseLocation.getY() > 450 && mouseLocation.getY() < 500  )
                {
                    if(noteLength == 2)
                    {

                        newNote = new G2();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if(noteLength == 4)
                    {
                        newNote = new G4();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if( noteLength == 8)
                    {
                        newNote = new G8();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY());
                    }
                    else if (noteLength == 1)
                    {
                        newNote = new G();
                        addObject( newNote, mouseLocation.getX(), mouseLocation.getY() );
                    }
                }
            }
        }
        else if( Greenfoot.mouseClicked(null) || mouseLocation == null )
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
    /**
     * snapToGrid checks the mouse position when a block is being held and snaps it to the nearest grid
     * @param there are no parameters
     * @return nothing is returned
     */
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
    /**
     * snapShift runs along side snapToGrid but just offsets the blocks in accordance to the note length so that they fit
     * @param there are no parameters
     * @return nothing is returned
     */
    private void snapShift()
    {
        if( newNote != null )
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
    }
    /**
     * displayTempo shows what the tempo is so that you can easily tell
     *@param there are no parameters
     *@return nothing is returned
     */
    private void displayTempo()
    {
        showText("Tempo  " + tempo , 60, 90);

    }
    /**
     * displayNoteType is a counter similar to the tempo but instead display what the current note type selected is
     * @param there are no parameters
     * @return nothing is returned
     */
    private void displayNoteType()
    {
        showText(" Note Length " + noteLength , 66, 115);
    }
    /**
     * increaseTempo is accessed by an other classe so that it can increase the tempo
     * @param there are no parameters
     * @return nothing is returned
     */
    public void increaseTempo()
    {
        tempo++;
        displayTempo();
    }
    /**
     * decreaseTempo does the oposite of increase tempo
     * @param there are no parameters
     * @return nothing is returned
     */
    public void decreaseTempo()
    {
        tempo--;
        displayTempo();
    }
    /**
     * reset gets a list of everything in the world removes them then calls addAll to re-add everything
     * @param there are no parameters
     * @return nothing is returned
     */
    public void reset()
    {
        List allObjects = getObjects(null);
        removeObjects(allObjects);
        addAll();
        tempo = 100;
        noteLength = 4;
    }
    /**
     * setNoteLength allows other classes to change the note length
     * @param there is an intiger called length so that other classes can use it to quickly change the note lenght
     * @return nothing is returned
     */
    public void setNoteLength( int length )
    {
        noteLength = length;
        displayNoteType();
    }
}
