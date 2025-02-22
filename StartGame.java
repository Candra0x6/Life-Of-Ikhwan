import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartGame extends World
{

    /**
     * Constructor for objects of class LevelSelect.
     * 
     */
    public StartGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        Greenfoot.setSpeed(100);
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        PlayButton playbutton = new PlayButton();
        addObject(playbutton, 850, 200);
    }
}
