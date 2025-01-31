import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * The battlefield in which the player fights
 * 
 * @author Michael
 * @version 10/15/2014
 */
public class Battlefield extends ScrollWorld {
    Door doorToHome;
        /**
         * Constructor for objects of class Battlefield.
         * 
         */
        public Battlefield() {
                super(1280, 720, 1, 2500, 2500);
                Greenfoot.setSpeed(50);
                setPaintOrder(DialogManager.class, MissionDisplay.class, TextInfo.class, MoneyDisplay.class, BorderForest.class,
                                TreeTop.class, Player.class, PlayerHome.class, PrayerMat.class, Budi.class,
                                ZakatBox.class, Zero.class);
                int numTrees = 2;
                addObject(new BorderForest(), 1250, 1250);
              
                // adds mach

                Budi budi = new Budi(GameManager.getInstance().getMoneyManager());
                Zero zero = new Zero(GameManager.getInstance().getMoneyManager());
                PrayerMat prayerMat = new PrayerMat(GameManager.getInstance().getPlayer());
                addObject(prayerMat, 1200, 1000);
                    addObject(prayerMat.getPrayerMission(), 1200, 1000);

                
                DialogManager dialogManager = new DialogManager();
                                addObject(dialogManager, 0, 0);
                ZakatBox zakatBox = new ZakatBox(GameManager.getInstance().getMoneyManager());
                addObject(zakatBox, 1000, 900); // Tentukan posisi kotak zakat

            
                MoneyDisplay moneyDisplay = new MoneyDisplay(GameManager.getInstance().getMoneyManager());
                addObject(moneyDisplay, 0, 0);
                MissionDisplay missionDisplay = new MissionDisplay();
                addObject(missionDisplay, 0, 0);
                addObject(zero, 1400, 600);
                WalletMission mission = budi.getWalletMission();
                Yaya yaya = new Yaya(GameManager.getInstance().getMoneyManager());
                addObject(yaya, 1400, 1100);
                

                MissionManager.getInstance().addMission(budi.getWalletMission());
                MissionManager.getInstance().addMission(zero.getToleranceMission());
                MissionManager.getInstance().addMission(zakatBox.getAlmsMission());
                MissionManager.getInstance().addMission(prayerMat.getPrayerMission());
                MissionManager.getInstance().addMission(yaya.getSchoolMission());
                Wallet wallet = mission.getWallet();
                
                
                School school = new School("house06.png", "House1.png", yaya.getSchoolMission());
                addObject(school, 1200, 1800);


                addObject(budi, 1200, 900);

                addObject(wallet, 1200, 600); // Set appropriate coordinates

                PlayerHome playerHome = new PlayerHome();
                PlayerHomeTruck playerHomeTruck = new PlayerHomeTruck();
                addObject(playerHome, 1800, 600);
                
                addObject(playerHomeTruck, 1800, 550);

                // adds trees;
                Random rand = new Random();
                for (int i = 0; i < numTrees; i++) {
                        int randX = rand.nextInt(1900) + 300;
                        int randY = rand.nextInt(1900) + 300;
                        addObject(new TreeTruck(), randX, randY);
                        addObject(new TreeTop(), randX, randY - 10);
                }

        }
        
        // GameManager hasn't executed if it placed in constructor
        public void act(){ 
            if(doorToHome == null && GameManager.WorldState.INDOOR != null) {
                doorToHome = new DoorHitbox(GameManager.WorldState.INDOOR, 700, 500, true);
                addObject(doorToHome, 1800, 680);
            }
        }
}
