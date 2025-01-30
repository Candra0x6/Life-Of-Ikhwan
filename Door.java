import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door extends ScrollActor implements IInteractable {
    private GameManager.WorldState world;

    public Door(GameManager.WorldState world) {
        this.world = world;
    }

    public void Interact() {
        GameManager.getInstance().changeWorld(world, 1000, 600);
    }
}
