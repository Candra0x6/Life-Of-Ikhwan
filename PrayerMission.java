import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PrayerMission here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class PrayerMission extends Mission {

    private Player player;
    private int prayerTimer;
    private boolean isPraying;
    private boolean textDisplayed;
    private static final int PRAYER_DURATION = 600; // 10 seconds (60 frames per second)
    private static final int TEXT_DISPLAY_DURATION = 60; // 1 second for completion text

    public PrayerMission() {
        super("Misi Salat: Lakukan simulasi salat");
        this.id = 2;
        this.prayerTimer = 0;
        this.isPraying = false;
        this.textDisplayed = false;
    }

    @Override
    public void act() {
        if (isPraying && !isCompleted) {
            updatePrayerStatus();
        }
    }

    public void startPrayer(Player player) {
        this.player = player;
        if (!isPraying && !isCompleted) {
            isPraying = true;
            textDisplayed = true;
            prayerTimer = 0;
            player.setCanMove(true);
            updatePrayerText();
        }
    }

    private void updatePrayerStatus() {
        prayerTimer++;

        if (prayerTimer < PRAYER_DURATION) {
            // Update timer text
            updatePrayerText();
        } else if (prayerTimer == PRAYER_DURATION) {
            // Show completion text when prayer duration is reached
            player.setCanMove(false);
            showTextAbovePlayer("Selesai salat!");

        } else if (prayerTimer >= PRAYER_DURATION + TEXT_DISPLAY_DURATION) {
            // Complete the prayer after showing completion text
            completePrayer();
        }
    }

    private void updatePrayerText() {
        int secondsLeft = (PRAYER_DURATION - prayerTimer) / 60; // Convert frames to seconds
        showTextAbovePlayer("Sedang salat... " + secondsLeft + " detik tersisa");
    }

    private void showTextAbovePlayer(String text) {
        World world = player.getWorld();
        if (world != null) {
            // Remove any existing text
            world.removeObjects(world.getObjects(TextInfo.class));

            // Add new text above player
            TextInfo textInfo = new TextInfo(text);
            world.addObject(textInfo, player.getX(), player.getY() - 30);
        }
    }

    private void completePrayer() {
        isPraying = false;
        textDisplayed = false;
        player.setCanMove(true);

        // Remove text and complete mission
        World world = player.getWorld();
        if (world != null) {
            world.removeObjects(world.getObjects(TextInfo.class));
        }
        complete();
    }

    public boolean isPraying() {
        return isPraying;
    }
}
