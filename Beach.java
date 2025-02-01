import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Beach here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beach extends ScrollActor
{
    public Beach(){
        setImage("WorldOutsidefix.png");
        getImage().scale(getImage().getWidth() * 2, getImage().getHeight() * 2);
                getImage().setTransparency(255); // Pastikan gambar fully opaque

    }
}
