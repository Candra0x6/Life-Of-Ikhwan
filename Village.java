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
        addObject(new Path(), 2085, 1102);
        addObject(new VillageObject(), 1835, 1102);
        addObject(new Buildings(), 2085, 1102);
        addObject(new Beach(), 1835, 1102);

        // Building Colliders
        addObject(new PlayerHomeTruck(), 2390, 490);
        addObject(new NPCHouse(100, 100), 2115, 1145); // NPC House Red
        addObject(new NPCHouse(110, 100), 1844, 1110); // NPC House Purple
        addObject(new NPCHouse(100, 80), 1601, 1074); // NPC House Blue Small
        addObject(new NPCHouse(120, 100), 1289, 1095); // NPC House Orange
        addObject(new NPCHouse(150, 150), 866, 1110); // NPC House Blue Big

        // Tree Colliders
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
