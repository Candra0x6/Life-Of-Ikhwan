import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PrayerMat here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class PrayerMat extends Box {
    private PrayerMission prayerMission;
    private Player player;
    /**
     * Act - do whatever the PrayerMat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public PrayerMat(Player player) {
        setImage("Sajadah.png");
          prayerMission = new PrayerMission(player);
          this.player = player;
    }

    public void act() {
        if (!prayerMission.isPraying() && isInteracting) {
            
            prayerMission.startPrayer();
        }
    }
    
    public PrayerMission getPrayerMission(){
        return prayerMission;
    }
}
