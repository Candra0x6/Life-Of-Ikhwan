import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WalletMission here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class WalletMission extends Mission {

    private Wallet wallet;
    private Budi budi;

    public void act() {
        // Add your action code here.
    }

    public WalletMission(Budi budi) {
        super("Temukan dompet Budi yang hilang");
        this.budi = budi;
        this.wallet = new Wallet();
        this.id = 1;
    }

    public void update() {
        if (!isCompleted && wallet.isCollected()) {
            complete();
            budi.updateDialogForWallet();
        }
    }

    public Wallet getWallet() {
        return wallet;
    }
}
