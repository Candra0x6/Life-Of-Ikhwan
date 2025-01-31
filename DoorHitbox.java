import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InvisibleDoor here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class DoorHitbox extends Door {
    DoorHitbox(GameManager.WorldState world, int xDestination, int yDestination, boolean needPlayer) {
        super(world, xDestination, yDestination, needPlayer);
        getImage().clear();
    }
}
