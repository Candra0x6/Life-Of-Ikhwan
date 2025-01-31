import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Home here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Home extends ScrollActor implements IInteractable {
    public void Interact() {
        GameManager.getInstance().changeWorld(GameManager.WorldState.INDOOR, 700, 500, true);
    }
}
