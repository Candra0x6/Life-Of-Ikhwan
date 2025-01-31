public class SchoolMission extends Mission {
    private Yaya yaya;
    private boolean buildKeyGiven;
    private Player player;

    public SchoolMission(Yaya yaya) {
        super("Bangun Sekolah Baru di Desa");
        this.id = 5;
        this.yaya = yaya;
        this.buildKeyGiven = false;
    }

    public void act() {
        // Add your action code here.
        if (!isCompleted) {
            update();
        }
    }

    public void update() {

        if (!isCompleted && !buildKeyGiven) {
            yaya.updateDialogForSuccess();
        }
    }

    public void setRewardGiven(boolean given) {
        this.buildKeyGiven = given;
    }

    public boolean isRewardGiven() {
        return buildKeyGiven;
    }
    
    

    public Yaya getYaya() {
        return yaya;
    }
}