import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends ScrollActor implements IInteractable
{
    protected DialogManager dialogManager;
    protected boolean isInteracting;
    protected Player player;

    public Box() {
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
        dialogManager.addDialog(new DialogLine(
            "Dialog Kosong",
            new String[]{},
            new int[]{},
            false
        ));
      
    }
    }
