import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Dialogue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogLine extends ScrollActor
{
   private String text;
    private String[] choices;
    private int[] nextDialogIds;
    private boolean isEnd;
    
    public DialogLine(String text, String[] choices, int[] nextDialogIds, boolean isEnd) {
        this.text = text;
        this.choices = choices;
        this.nextDialogIds = nextDialogIds;
        this.isEnd = isEnd;
    }
    
    // Getters
    public String getText() { return text; }
    public String[] getChoices() { return choices; }
    public int[] getNextDialogIds() { return nextDialogIds; }
    public boolean isEnd() { return isEnd; }
}
