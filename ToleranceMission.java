public class ToleranceMission extends Mission {
    private Zero zero;
    private boolean rewardGiven;
    private Player player;

    public ToleranceMission(Zero zero) {
        super("Misi Toleransi: Bantu menyelesaikan konflik antar umat");
        this.id = 4;
        this.zero = zero;
        this.rewardGiven = false;
    }

    public void act() {
        // Add your action code here.
        if (!isCompleted) {
            update();
        }
    }

    public void update() {

        if (!isCompleted && !rewardGiven) {

            complete();
            System.out.println(isCompleted);
            zero.updateDialogForSuccess();
        }
    }

    public void setRewardGiven(boolean given) {
        this.rewardGiven = given;
    }

    public boolean isRewardGiven() {
        return rewardGiven;
    }

    public Zero getZero() {
        return zero;
    }
}