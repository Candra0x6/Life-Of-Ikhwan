import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class MissionManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MissionManager extends ScrollActor
{
    /**
     * Act - do whatever the MissionManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
       private static MissionManager instance;
    private List<Mission> missions;
    public void act()
    {
        // Add your action code here.
    }
    private MissionManager() {
        missions = new ArrayList<>();
    }
    
    public static MissionManager getInstance() {
        if (instance == null) {
            instance = new MissionManager();
        }
        return instance;
    }
    
    public void addMission(Mission mission) {
        missions.add(mission);
    }
    
    public List<Mission> getMissions() {
        return missions;
    }
}
