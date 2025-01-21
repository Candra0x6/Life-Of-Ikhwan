import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a healthbar above the player
 * 
 * @author Michael 
 * @version 10/14/2014
 */
public class HealthBar extends ScrollActor
{ 
    private int buffer = 4;
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drawHealth();
        updateLocation();
    }    

    /**
     * Draws a healthbar above the player
     */
    public void drawHealth(){
        //gets player info
        double myHealth = ((Player) getWorld().getObjects(Player.class).get(0)).getHealth();
      
        buffer++;
        if(buffer % 2 == 0){
            GreenfootImage image = new GreenfootImage(601, 68);
            image.setColor(Color.BLACK);
            image.fillRect(72, 42, 601, 60); 
            image.setColor(new Color(255, 8, 45));
            image.fillRect(72, 42, (int) (myHealth/100*39), 59);  
            double length = 0;//image.setColor(new Color(0, 128, 255));
            //image.fillRect(2, 11, (int) length, 6);  

           
            image.setColor(new Color(255, 197, 8));

            setImage(image);  
        }
    }

    /**
     * Updates the location so it is at the bottom of the screen
     */
    public void updateLocation(){
        setLocation(300, 300 + 266);
    }
}
