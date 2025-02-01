import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InsideHome here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class InsideHome extends ScrollWorld {
    Door doorToOutside;

    /**
     * Constructor for objects of class InsideHome.
     * 
     */
    public InsideHome() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, 1500, 1000);
        setBackground(new GreenfootImage("BaseHole.png"));
        getBackground().scale(getBackground().getWidth() * 4, getBackground().getHeight() * 4);
        
    }

    public void act() {
        if (doorToOutside == null && GameManager.WorldState.VILLAGE != null) {
            doorToOutside = new DoorHitbox(GameManager.WorldState.VILLAGE, 2392, 583, true);
            addObject(doorToOutside, 700, 500);
        }
    }
}
