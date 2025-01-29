import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mission here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mission extends ScrollActor {

    public void act() {
        // Add your action code here.
    }

    public int id;
    protected boolean isCompleted;
    protected String description;

    public Mission(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getDescription() {
        return description;
    }

    public void complete() {
        isCompleted = true;
    }
}
