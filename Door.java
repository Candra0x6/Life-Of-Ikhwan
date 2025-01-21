import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends ScrollActor implements IInteractable
{
    private World world;
    
    public Door(World world){
        this.world = world;
    }
    public void Interact(){
        Greenfoot.setWorld(world);
    }
}
