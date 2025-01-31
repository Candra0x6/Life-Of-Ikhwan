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
                setPaintOrder(MissionDisplay.class, TextInfo.class, MoneyDisplay.class, BorderForest.class,
                                TreeTop.class, Player.class, PlayerHome.class, PrayerMat.class, Budi.class,
                                ZakatBox.class, Zero.class);
                int numTrees = 2;
                addObject(new BorderForest(), 1250, 1250);
                ZakatBox zakatBox = new ZakatBox(GameManager.getInstance().getMoneyManager());
                addObject(zakatBox, 1000, 900); // Tentukan posisi kotak zakat

                // adds mach

                Budi budi = new Budi();
                Zero zero = new Zero(GameManager.getInstance().getMoneyManager());
                PrayerMission prayerMission = new PrayerMission();
                addObject(prayerMission, 0, 0); // Posisi tidak penting jika tidak perlu ditampilkan
                PrayerMat prayerMat = new PrayerMat(prayerMission);
                addObject(prayerMat, 1200, 1000);

                MoneyDisplay moneyDisplay = new MoneyDisplay(zakatBox.getMoneyManager());
                addObject(moneyDisplay, 0, 0);
                MissionDisplay missionDisplay = new MissionDisplay();
                addObject(missionDisplay, 0, 0);

                addObject(zero, 1400, 600);
                WalletMission mission = budi.getWalletMission();

                MissionManager.getInstance().addMission(budi.getWalletMission());
                MissionManager.getInstance().addMission(zero.getToleranceMission());
                MissionManager.getInstance().addMission(prayerMission);

                Wallet wallet = mission.getWallet();
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
                doorToHome = new DoorHitbox(GameManager.WorldState.INDOOR, 700, 500);
                addObject(doorToHome, 1800, 650);
            }
        }
}
