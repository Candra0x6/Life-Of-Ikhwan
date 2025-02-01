import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VillageObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VillageObject extends ScrollActor
{
    public VillageObject(){
        setImage("WorldObject2.png");
        
        getImage().scale(getImage().getWidth() * 2, getImage().getHeight() * 2);
    }
}
