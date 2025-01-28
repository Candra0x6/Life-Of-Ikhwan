import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wallet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wallet extends ScrollActor implements IInteractable
{
    private boolean isCollected;
    
    public Wallet() {
        isCollected = false;
        // Set wallet image
    }
    
    
    public void Interact() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            isCollected = true;
            getWorld().removeObject(this);
        }
    }
    
    public boolean isCollected() {
        return isCollected;
    }

    public void act()
    {
        // Add your action code here.
    }
    
}
