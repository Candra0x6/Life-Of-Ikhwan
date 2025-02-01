
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Village here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Village extends ScrollWorld {

    /**
     * Constructor for objects of class Village.
     *
     */
    public Village() {
        super(1280, 720, 1, 4170, 1690);
        setBackground("WorldBase.png");
        Greenfoot.setSpeed(50);
        setPaintOrder( DialogManager.class, DialogLine.class, MissionDisplay.class, TextInfo.class, MoneyDisplay.class, BorderForest.class,
                TreeTop.class, Player.class, NPC.class, PlayerHome.class, PrayerMat.class, Budi.class, 
                ZakatBox.class, Zero.class, Beach.class);

        addObject(new Path(), 2085, 1102);
        addObject(new VillageObject(), 1835, 1102);
        addObject(new Buildings(), 2085, 1102);
        
        // Building Colliders
        addObject(new PlayerHomeTruck(), 2390, 490);
        addObject(new NPCHouse(100, 100), 2115, 1145); // NPC House Red
        addObject(new NPCHouse(110, 100), 1844, 1110); // NPC House Purple
        addObject(new NPCHouse(100, 80), 1601, 1074); // NPC House Blue Small
        addObject(new NPCHouse(120, 100), 1289, 1095); // NPC House Orange
        addObject(new NPCHouse(150, 150), 866, 1110); // NPC House Blue Big

        DialogManager dialogManager = new DialogManager();
    addObject(dialogManager, getWidth()/2, getHeight()/2); // Tambahkan DialogManager ke world
    
        // NPCs
        Budi budi = new Budi(GameManager.getInstance().getMoneyManager(), dialogManager);
        Zero zero = new Zero(GameManager.getInstance().getMoneyManager(), dialogManager);
        Yaya yaya = new Yaya(GameManager.getInstance().getMoneyManager(), dialogManager);
        PrayerMat prayerMat = new PrayerMat(GameManager.getInstance().getPlayer());
        ZakatBox zakatBox = new ZakatBox(GameManager.getInstance().getMoneyManager());
        Wallet wallet = budi.getWalletMission().getWallet();

        MoneyDisplay moneyDisplay = new MoneyDisplay(GameManager.getInstance().getMoneyManager());
        addObject(moneyDisplay, 0, 0);
        MissionDisplay missionDisplay = new MissionDisplay();
        addObject(missionDisplay, 0, 0);

        addObject((budi), 2210, 1236);
        addObject((zero), 1766, 1233);
        addObject((yaya), 1619, 1164);
        // addObject((prayerMat), 2390, 490);
        addObject((zakatBox), 2190, 809);
        addObject((wallet), 2637, 758);

        // MIssions
        MissionManager.getInstance().addMission(budi.getWalletMission());
        MissionManager.getInstance().addMission(zero.getToleranceMission());
        MissionManager.getInstance().addMission(zakatBox.getAlmsMission());
        MissionManager.getInstance().addMission(prayerMat.getPrayerMission());
        MissionManager.getInstance().addMission(yaya.getSchoolMission());
       
         addObject(new Masjid(), 2094 ,728 );
        addObject(new School("Sekolah1.png", "Sekolah0.png", yaya.getSchoolMission()), 3078, 563);
        // addObject(new PrayerMat(GameManager.getInstance().getPlayer()), 2390, 490);
        
        addObject(new Border(900, 500), 3200, 1100);
        addObject(new Border(100, 900), 3507, 850);
        addObject(new Border(300, 100), 3000, 360);
        addObject(new Border(300, 100), 3300, 360);
        addObject(new Border(300, 400), 2674, 400);
        addObject(new Border(1500, 400), 1350, 360);
        // addObject(new Border(650, 742), 639, 742);

        addObject(new DoorHitbox(GameManager.WorldState.INDOOR, 700, 500, true), 2392, 583);
        
    }
}
