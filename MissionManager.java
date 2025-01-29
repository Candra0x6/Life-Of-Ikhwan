import java.util.ArrayList;
import java.util.List;

public class MissionManager extends ScrollActor {
    private static MissionManager instance;
    private List<Mission> missions;
    private List<Mission> completedMissions;
    
    private MissionManager() {
        missions = new ArrayList<>();
        completedMissions = new ArrayList<>();
    }
    
    public static MissionManager getInstance() {
        if (instance == null) {
            instance = new MissionManager();
        }
        return instance;
    }
    
    public List<Mission> getMissions() {
        return missions;
    }
    
    public void addMission(Mission mission) {
        missions.add(mission);
    }
    
    public void updateMissions() {
        for (Mission mission : missions) {
            if (mission.isCompleted() && !completedMissions.contains(mission)) {
                completedMissions.add(mission);
            }
        }
    }
    
    public List<Mission> getActiveMissions() {
        List<Mission> activeMissions = new ArrayList<>();
        for (Mission mission : missions) {
            if (!mission.isCompleted()) {
                activeMissions.add(mission);
            }
        }
        return activeMissions;
    }
    
    public List<Mission> getCompletedMissions() {
        return completedMissions;
    }
    
    public int getCompletedMissionCount() {
        return completedMissions.size();
    }
    
    @Override
    public void act() {
        updateMissions();
    }
}