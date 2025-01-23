import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZakatBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZakatBox extends Box {
    private MoneyManager moneyManager;
    private ZakatInteraction zakatInteraction;
    private MoneyDisplay moneyDisplay;
    public ZakatBox() {
        super();
        moneyManager = new MoneyManager(1000.0);
        zakatInteraction = new ZakatInteraction(moneyManager, dialogManager);
        moneyDisplay = new MoneyDisplay(moneyManager);
    }

    protected void setupDialogs() {
        // Dialog 0: Initial question
        dialogManager.addDialog(new DialogLine(
            "Sedekah Ke Mushola?",
            new String[]{"Ya", "Tidak"},
            new int[]{1, 4},
            false
        ));

        // Dialog 1: Amount selection
        dialogManager.addDialog(new DialogLine(
            "Pilih jumlah zakat:",
            new String[]{"50", "100", "250", "500"},
            new int[]{2, 2, 2, 2},
            false
        ));

        // Dialog 2: Confirmation (message updated dynamically)
        dialogManager.addDialog(new DialogLine(
            "Anda yakin ingin membayar zakat sebesar %s?",
            new String[]{"Ya", "Tidak"},
            new int[]{3, 4},
            false
        ));

        // Dialog 3: Success message
        dialogManager.addDialog(new DialogLine(
            "Pembayaran berhasil. Terima kasih!",
            new String[]{},
            new int[]{},
            false
        ));

        // Dialog 4: Cancellation message
        dialogManager.addDialog(new DialogLine(
            "Baik, lain kali mungkin.",
            new String[]{},
            new int[]{},
            false
        ));
    }
    
    public MoneyManager getMoneyManager() {
        return moneyManager;
    }

    public void act() {
        super.act();
        if (isInteracting) {
            zakatInteraction.handleDialog(dialogManager.getCurrentDialogId(), dialogManager.getSelectedOptionIndex());
            moneyDisplay.updateDisplay();
        }
    }
}
