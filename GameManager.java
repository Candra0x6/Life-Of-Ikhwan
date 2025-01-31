import greenfoot.*;

/**
 * Write a description of class GameManager here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameManager {
    Player player;

    public enum WorldState {
        BATTLEFIELD(new Battlefield()),
        INDOOR(new InsideHome());

        public ScrollWorld world;

        WorldState(ScrollWorld world) {
            this.world = world;
        }
    }

    public WorldState worldState;

    private MoneyManager moneyManager;
    private DialogManager dialogManager;
    private ZakatBox zakatBox;
    private Box box;

    private static GameManager instance;

    /**
     * Constructor for objects of class GameManager
     */
    private GameManager() {
        moneyManager = new MoneyManager(1000.0);
        player = new Player();
        dialogManager = new DialogManager(); // Create this first
        box = new Box();
    }

    // create a singleton
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void changeWorld(WorldState worldDest, int x, int y) {
        worldState = worldDest;

        Greenfoot.setWorld(worldState.world);
        worldState.world.addCameraFollower(player, 0, 0);
        worldState.world.setCameraLocation(x, y);
    }

    public MoneyManager getMoneyManager() {
        return moneyManager;
    }
    
    public Player getPlayer(){
        return player;
    }

    public DialogManager getDialogManager() {
        return dialogManager;
    }
}
