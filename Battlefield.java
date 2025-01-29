import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * The battlefield in which the player fights
 * 
 * @author Michael
 * @version 10/15/2014
 */
public class Battlefield extends ScrollWorld
{
    /**
     * Constructor for objects of class Battlefield.
     * 
     */
    public Battlefield()
    {    
        super(1280, 720, 1, 2500, 2500);
        Greenfoot.setSpeed(50);
        setPaintOrder( BorderForest.class, Budi.class, TreeTop.class, Player.class, MoneyDisplay.class, ZakatBox.class, MissionDisplay.class, Zero.class);
        int numTrees = 2;
        MoneyManager moneyManager = new MoneyManager(1000.0);

        addObject(new BorderForest(), 1250, 1250);
        ZakatBox zakatBox= new ZakatBox(moneyManager);
        addObject(zakatBox, 1000, 900); // Tentukan posisi kotak zakat
        
        //adds mach
    
        Budi budi = new Budi();
        Zero zero = new Zero(moneyManager);
        addObject(zero, 1400, 600);
        WalletMission mission = budi.getWalletMission();
        MissionManager.getInstance().addMission(zero.getToleranceMission());
        Wallet wallet = mission.getWallet();
        addObject(budi, 1200, 900);

        addObject(wallet, 1200, 600); // Set appropriate coordinates
        Home home = new Home();        
        addObject(home, 1000, 600);
      
        //adds trees;
        Random rand = new Random();
        for(int i = 0; i<numTrees; i++){
            int randX = rand.nextInt(1900) + 300; 
            int randY = rand.nextInt(1900) + 300; 
            addObject(new TreeTruck(), randX, randY);
            addObject(new TreeTop(), randX, randY - 10);
        }
          Player player = new Player();
        addCameraFollower(player, 0, 0);

         MoneyDisplay moneyDisplay = new MoneyDisplay(zakatBox.getMoneyManager());
        addObject(moneyDisplay, 0, 0);
       MissionDisplay missionDisplay = new MissionDisplay();
        addObject(missionDisplay, 0, 0);
        MissionManager.getInstance().addMission(budi.getWalletMission());

    }
}
