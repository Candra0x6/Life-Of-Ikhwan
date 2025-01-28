import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The tank that the player controls
 * 
 * @author Michael
 * @version 10/6/2014
 */
public class Player extends ScrollActor
{
    //creates variables
    private int myHealth;
    private int mySpeed;
    private int counter;
    private int reloadTime;
    private int score = 0;
    private int moveSpeed = 3;
    private boolean isInDialog;
    
    private MoneyManager moneyManager;
    private DialogManager dialogManager;
    private ZakatBox zakatBox;
    private ZakatInteraction zakatInteraction;
    private Box box;
    
    private int selectedOption; // Opsi yang dipilih oleh pemain

    

    private static final int MOVE_AMOUNT = 3;

    //constructer that initialize variables
    public Player(){
        myHealth = 1000;
        mySpeed = 4;
        counter = 0;
        reloadTime = 32;
        isInDialog = false;
        selectedOption = -1; // -1 berarti belum memilih
        
        moneyManager = new MoneyManager(1000.0);
        dialogManager = new DialogManager();  // Create this first
        zakatInteraction = new ZakatInteraction(moneyManager, dialogManager);
        box = new Box();
    }
    

    //act method
    public void act() 
    {
        if(!isInDialog){
            moveAround();
            checkCollisionObject();
            checkInteraction(); // Cek interaksi dengan objek lain
            handleInput();
        }
        
    }    

    //moves around
    public void moveAround(){
        if (Greenfoot.getMouseInfo() != null) {
            // flip the character depend on mouse position
            if (Greenfoot.getMouseInfo().getX() > getX()){
                setImage(new GreenfootImage("spr_dig_strip13.png"));
            } else if (Greenfoot.getMouseInfo().getX() < getX()){
                setImage(new GreenfootImage("spr_dig_strip13_flip.png"));
            }
        }
        
        if(Greenfoot.isKeyDown("W"))
            getWorld().setCameraLocation(getWorld().getCameraX(), getWorld().getCameraY() - MOVE_AMOUNT);
        if(Greenfoot.isKeyDown("A"))
            getWorld().setCameraLocation(getWorld().getCameraX() - MOVE_AMOUNT, getWorld().getCameraY());
        if(Greenfoot.isKeyDown("S"))
            getWorld().setCameraLocation(getWorld().getCameraX(), getWorld().getCameraY() + MOVE_AMOUNT);
        if(Greenfoot.isKeyDown("D"))
            getWorld().setCameraLocation(getWorld().getCameraX() + MOVE_AMOUNT, getWorld().getCameraY());
    }   

    //checks if collsion with an object
    public void checkCollisionObject(){
        Actor obj = getOneIntersectingObject(Objects.class);                 
        if(obj != null){
            if(Greenfoot.isKeyDown("W"))
                getWorld().moveCamera(-MOVE_AMOUNT);
            else if(Greenfoot.isKeyDown("S"))
                getWorld().moveCamera(MOVE_AMOUNT/2);
        }  
    }
    
     private void checkInteraction() {
        // Cek Interactable dalam radius interaksi
        List<IInteractable> nearbyInteractables = getObjectsInRange(50, IInteractable.class);
        
        if (!nearbyInteractables.isEmpty() && Greenfoot.isKeyDown("e")) {
            // Ambil Interactable terdekat
            IInteractable obj = nearbyInteractables.get(0);
            obj.Interact(); // Menjalankan method Interact dari obj tersebut
        }
    }
    
    public void setIsInDialog(boolean bool){
        isInDialog = bool;
    }
    
    public boolean isInDialog() {
        return isInDialog;
    }

    // Method untuk menangani input pemain (misalnya, memilih opsi dialog)
    private void handleInput() {
        if (isInDialog) {
            if (Greenfoot.isKeyDown("1")) { // Contoh: Memilih opsi 1
                selectedOption = 0;
            } else if (Greenfoot.isKeyDown("2")) { // Contoh: Memilih opsi 2
                selectedOption = 1;
            } else if (Greenfoot.isKeyDown("3")) { // Contoh: Memilih opsi 3
                selectedOption = 2;
            }
        }
    }


    // Method untuk mendapatkan opsi yang dipilih
    public int getSelectedOption() {
        return selectedOption;
    }

    // Method untuk mengecek apakah pemain sedang dalam dialog
   
    public MoneyManager getMoneyManager() {
        return moneyManager;
    }

    public DialogManager getDialogManager() {
        return dialogManager;
    }
}
