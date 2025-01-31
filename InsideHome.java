import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InsideHome here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class InsideHome extends ScrollWorld {
    /**
     * Constructor for objects of class InsideHome.
     * 
     */
    public InsideHome() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, 1500, 1000);
        addObject(new Door(GameManager.WorldState.BATTLEFIELD, 1800, 700), 700, 500);
    }
}
