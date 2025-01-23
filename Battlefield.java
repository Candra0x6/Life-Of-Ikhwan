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
        setPaintOrder( BorderForest.class, Budi.class, TreeTop.class, Player.class, MoneyDisplay.class, ZakatBox.class);
        int numTrees = 2;
        
        addObject(new BorderForest(), 1250, 1250);
        ZakatBox zakatBox= new ZakatBox();
        addObject(zakatBox, 1000, 900); // Tentukan posisi kotak zakat
        
        //adds mach
        Budi petani = new Budi();
        Home home = new Home();
        
        addObject(home, 1000, 600);
        addObject(petani, 1000, 700);
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
        

    }
}
