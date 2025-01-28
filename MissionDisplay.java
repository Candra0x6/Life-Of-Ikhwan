import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class MissionDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MissionDisplay extends ScrollActor
{
   
    private GreenfootImage background;
    private Font titleFont;
    private Font missionFont;
    private static final int PADDING = 10;
    private static final int LINE_HEIGHT = 25;
    
    public MissionDisplay() {
        titleFont = new Font("Arial", true, false, 20);
        missionFont = new Font("Arial", false, false, 16);
        createDisplay();
    }
    
    private void createDisplay() {
        try {
            // Load background image
            background = new GreenfootImage("mission-bg.png");
        } catch (Exception e) {
            // Create default background if image not found
            background = new GreenfootImage(250, 400);
            background.setColor(new Color(0, 0, 0, 160));
            background.fill();
            background.setColor(new Color(255, 255, 255, 100));
            background.fillRect(5, 5, 240, 390);
        }
        
        updateDisplay();
    }
    
    private void updateDisplay() {
        GreenfootImage display = new GreenfootImage(background);
        setLocation(200, 0 + 266);
        // Draw title
        display.setFont(titleFont);
        display.setColor(Color.WHITE);
        display.drawString("Active Missions", PADDING * 2, PADDING * 3);
        
        // Draw missions
        display.setFont(missionFont);
        int yPos = PADDING * 5;
        
        List<Mission> missions = MissionManager.getInstance().getMissions();
        for (Mission mission : missions) {
            String status = mission.isCompleted() ? "✓" : "□";
            String text = status + " " + mission.getDescription();
            
            // Set color based on completion
            if (mission.isCompleted()) {
                display.setColor(new Color(100, 255, 100));
            } else {
                display.setColor(Color.WHITE);
            }
            
            // Draw wrapped text
            List<String> lines = wrapText(text, display.getWidth() - (PADDING * 4));
            for (String line : lines) {
                display.drawString(line, PADDING * 2, yPos);
                yPos += LINE_HEIGHT;
            }
            yPos += PADDING;
        }
        
        setImage(display);
    }
    
    @Override
    public void act() {
        updateDisplay();
    }
    
    private List<String> wrapText(String text, int maxWidth) {
        List<String> lines = new ArrayList<>();
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();
        
        for (String word : words) {
            if (currentLine.length() + word.length() + 1 <= maxWidth / 8) { // Approximate character width
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            } else {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            }
        }
        
        if (currentLine.length() > 0) {
            lines.add(currentLine.toString());
        }
        
        return lines;
    }
}
