import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The tank that the player controls
 * 
 * @author Michael
 * @version 10/6/2014
 */
public class Player extends ScrollActor {
    // creates variables
    private int myHealth;
    private int mySpeed;
    private int counter;
    private int reloadTime;
    private int score = 0;
    private int moveSpeed = 3;
    private int animationIndex = 0;
    private int animationDelay = 5; // Ubah nilai ini untuk mengatur kecepatan animasi
    private int delayCounter = 0;
    private boolean isInDialog;
    private boolean canMove = true;

    private Direction playerDirection;

    private enum Direction {
        UP(new GreenfootImage[] {
                new GreenfootImage("Walk_up0.png"),
                new GreenfootImage("Walk_up1.png"),
                new GreenfootImage("Walk_up2.png"),
                new GreenfootImage("Walk_up3.png"),
                new GreenfootImage("Walk_up4.png"),
                new GreenfootImage("Walk_up5.png"),
                new GreenfootImage("Walk_up6.png"),
                new GreenfootImage("Walk_up7.png")
        }),
        LEFT(new GreenfootImage[] {
                new GreenfootImage("Walk_left0.png"),
                new GreenfootImage("Walk_left1.png"),
                new GreenfootImage("Walk_left2.png"),
                new GreenfootImage("Walk_left3.png"),
                new GreenfootImage("Walk_left4.png"),
                new GreenfootImage("Walk_left5.png"),
                new GreenfootImage("Walk_left6.png"),
                new GreenfootImage("Walk_left7.png")
        }),
        RIGHT(new GreenfootImage[] {
                new GreenfootImage("Walk_right0.png"),
                new GreenfootImage("Walk_right1.png"),
                new GreenfootImage("Walk_right2.png"),
                new GreenfootImage("Walk_right3.png"),
                new GreenfootImage("Walk_right4.png"),
                new GreenfootImage("Walk_right5.png"),
                new GreenfootImage("Walk_right6.png"),
                new GreenfootImage("Walk_right7.png")
        });

        private GreenfootImage[] playerImages;

        private Direction(GreenfootImage[] playerImages) {
            this.playerImages = playerImages;
        }

        public GreenfootImage[] getPlayerImages() {
            return playerImages;
        }
    }

    private int selectedOption; // Opsi yang dipilih oleh pemain

    private static final int MOVE_AMOUNT = 3;

    // constructer that initialize variables
    public Player() {
        myHealth = 1000;
        mySpeed = 4;
        counter = 0;
        reloadTime = 32;
        isInDialog = false;
        playerDirection = Direction.RIGHT;
        selectedOption = -1; // -1 berarti belum memilih
    }

    // act method
    public void act() {
        if (!isInDialog || canMove) {
            moveAround();

    //act method
    public void act() {
        if (!isInDialog) {
            moveAround();

            checkCollisionObject();
            checkInteraction(); // Cek interaksi dengan objek lain
            handleInput();
        }

    }

    private boolean isMoving() {
        return !isInDialog && (Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("S")
                || Greenfoot.isKeyDown("D"));
    }

    // moves around
    public void moveAround() {
        if (Greenfoot.isKeyDown("W")) {
            getWorld().setCameraLocation(getWorld().getCameraX(), getWorld().getCameraY() - MOVE_AMOUNT);
            playerDirection = Direction.UP;
        }
        if (Greenfoot.isKeyDown("A")) {
            getWorld().setCameraLocation(getWorld().getCameraX() - MOVE_AMOUNT, getWorld().getCameraY());
            playerDirection = Direction.LEFT;
        }
        if (Greenfoot.isKeyDown("S")) {
            getWorld().setCameraLocation(getWorld().getCameraX(), getWorld().getCameraY() + MOVE_AMOUNT);
            if (playerDirection == Direction.UP) {
                if (Greenfoot.isKeyDown("A"))
                    playerDirection = Direction.LEFT;
                else {
                    playerDirection = Direction.RIGHT;
                }
                if (Greenfoot.isKeyDown("D"))
                    playerDirection = Direction.RIGHT;
            }
        }
        if (Greenfoot.isKeyDown("D")) {
            getWorld().setCameraLocation(getWorld().getCameraX() + MOVE_AMOUNT, getWorld().getCameraY());
            playerDirection = Direction.RIGHT;
        }

        moveAnimation();
    }

    private void moveAnimation() {
        getImage().scale(100, 100);
        if (isMoving()) {
            delayCounter++;
            if (delayCounter >= animationDelay) {
                delayCounter = 0;
                animationIndex = (animationIndex + 1) % playerDirection.getPlayerImages().length;
                setImage(playerDirection.getPlayerImages()[animationIndex]);
            }
        } else {
            // reset animasi jika player berhenti bergerak
            animationIndex = 0;
            setImage(playerDirection.getPlayerImages()[animationIndex]);
        }
    }

    // checks if collsion with an object
    public void checkCollisionObject() {
        Actor obj = getOneIntersectingObject(Objects.class);
        if (obj != null) {
            if (Greenfoot.isKeyDown("W"))
                getWorld().moveCamera(-MOVE_AMOUNT);
            else if (Greenfoot.isKeyDown("S"))
                getWorld().moveCamera(MOVE_AMOUNT / 2);
        }

    // checks if collsion with an object
    public void checkCollisionObject() {
        Actor obj = getOneIntersectingObject(Objects.class);
        if (obj != null) {
            if (Greenfoot.isKeyDown("W"))
                getWorld().setCameraLocation(getWorld().getCameraX(), getWorld().getCameraY() + MOVE_AMOUNT + 1);
            else if (Greenfoot.isKeyDown("S"))
                getWorld().setCameraLocation(getWorld().getCameraX(), getWorld().getCameraY() - MOVE_AMOUNT - 1);
            else if (Greenfoot.isKeyDown("D"))
                getWorld().setCameraLocation(getWorld().getCameraX() - MOVE_AMOUNT - 1, getWorld().getCameraY());
            else if (Greenfoot.isKeyDown("A"))
                getWorld().setCameraLocation(getWorld().getCameraX() + MOVE_AMOUNT + 1, getWorld().getCameraY());

        }
    }

    private void checkInteraction() {
        // Cek Interactable dalam radius interaksi
        List<IInteractable> nearbyInteractables = getObjectsInRange(50, IInteractable.class);

        if (!nearbyInteractables.isEmpty() && Greenfoot.isKeyDown("e")) {
            // Ambil Interactable terdekat
            IInteractable obj = nearbyInteractables.get(0);
            obj.Interact(); // Menjalankan method Interact dari obj tersebut
            Greenfoot.delay(10); // Mencegah input berulang
        }
    }

    public void setIsInDialog(boolean bool) {
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

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }
    // Method untuk mengecek apakah pemain sedang dalam dialog
}
