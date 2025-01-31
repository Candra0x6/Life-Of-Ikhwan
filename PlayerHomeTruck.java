import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerHomeTruck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerHomeTruck extends Objects implements IInteractable
{
    /**
     * Act - do whatever the PlayerHomeTruck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PlayerHomeTruck(){
        getImage().scale(150, 200);
    }
    public void Interact() {
        GameManager.getInstance().changeWorld(GameManager.WorldState.INDOOR, 700, 500);
    }
}
