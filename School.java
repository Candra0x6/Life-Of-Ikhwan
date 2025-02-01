import greenfoot.*;

public class School extends Home implements IInteractable {
    private String defaultImage;
    private String interactedImage;
    private boolean hasInteracted;
    private SchoolMission schoolMission;
    public School(String defaultImage, String interactedImage, SchoolMission schoolMission) {
        this.defaultImage = defaultImage;
        this.interactedImage = interactedImage;
        this.hasInteracted = false;
        this.schoolMission = schoolMission;
        setImage(defaultImage);
                getImage().scale(400, 400);

        
        
    }
    
    public void act() {
    }
    
     public void Interact() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (!hasInteracted && schoolMission.isRewardGiven()) {
            setImage(interactedImage);
            hasInteracted = true;
            schoolMission.complete();
        } else {
            setImage(defaultImage);
            hasInteracted = false;
        }
    }
    public void reset() {
        hasInteracted = false;
        setImage(defaultImage);
    }
    
    public boolean isInteracted() {
        return hasInteracted;
    }
}