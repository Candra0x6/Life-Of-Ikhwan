import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door extends ScrollActor implements IInteractable {
    private GameManager.WorldState world;
    protected int y, x;

    public Door(GameManager.WorldState world, int xDestination, int yDestination) {
        this.world = world;
        x = xDestination;
        y = yDestination;
    }

    public void Interact() {
        GameManager.getInstance().changeWorld(world, x, y);
    }
}
