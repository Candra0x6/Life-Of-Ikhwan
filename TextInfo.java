import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextInfo extends Actor
{
      public TextInfo(String text) {
        updateText(text);
    }
    
    public void updateText(String text) {
        // Membuat background transparan dengan padding
        GreenfootImage textImage = new GreenfootImage(text, 20, Color.BLACK, new Color(0, 0, 0, 0));
        // Menambah sedikit padding
        GreenfootImage image = new GreenfootImage(textImage.getWidth() + 10, textImage.getHeight() + 6);
        image.setColor(new Color(255, 255, 255, 180)); // Background putih semi-transparan
        image.fill();
        image.drawImage(textImage, 5, 3); // Posisi text di tengah dengan padding
        setImage(image);
    }
}
