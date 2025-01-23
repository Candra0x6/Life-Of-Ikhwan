import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends ScrollActor
{
     protected DialogManager dialogManager;
    protected boolean isInteracting;
    protected Player player;

    public Box() {
        dialogManager = new DialogManager();
        isInteracting = false;
        setupDialogs();
    }

    public void interact() { // Renamed to lowercase
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
      
    }
    }
