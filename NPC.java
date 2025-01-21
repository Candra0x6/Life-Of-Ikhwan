import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class NPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class NPC extends ScrollActor implements IInteractable
{
    protected DialogManager dialogManager;
    protected boolean isInteracting;
    protected Player player;
    
    public NPC() {
        dialogManager = new DialogManager();
        isInteracting = false;
        setupDialogs();
    }
    
    public void Interact() {
        player = (Player) getOneIntersectingObject(Player.class);
        startDialog();
    }
    
   public void act() {
        if (isInteracting) {
            // Tambahkan pengecekan dialog
            if (dialogManager.hasDialogs()) {
                dialogManager.update();
                GreenfootImage img = getWorld().getBackground();
                dialogManager.draw(img);
                
                if (!dialogManager.isDialogActive) {
                    endDialog();
                }
            } else {
                // Jika tidak ada dialog, hentikan interaksi
                endDialog();
            }
        }
    }
    protected void startDialog() {
         if (dialogManager.hasDialogs()) {
            isInteracting = true;
            if (player != null) {
                player.setIsInDialog(true);
            }
            dialogManager.startDialog(0);
        }
    }
    
    protected void endDialog() {
        isInteracting = false;
        // Beritahu player bahwa dialog sudah selesai
        if (player != null) {
            player.setIsInDialog(false);
        }
    }
    protected void setupDialogs() {
        // Contoh setup dialog
        dialogManager.addDialog(new DialogLine(
            "Halo! Apa yang bisa saya bantu?",
            new String[]{"Beli sesuatu", "Tanya cuaca", "Sampai jumpa"},
            new int[]{1, 2, 3},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Ini adalah barang yang saya jual...",
            null,
            new int[]{0},
            true
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Cuaca hari ini cerah!",
            null,
            new int[]{0},
            true
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Sampai jumpa lagi!",
            null,
            null,
            true
        ));
    }
}
