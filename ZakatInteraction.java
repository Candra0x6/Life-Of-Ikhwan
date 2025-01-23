import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZakatInteraction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZakatInteraction extends ScrollActor {
    private static final double[] ZAKAT_OPTIONS = {50.0, 100.0, 250.0, 500.0};
    private MoneyManager moneyManager;
    private DialogManager dialogManager;
    private double selectedAmount;

        public ZakatInteraction(MoneyManager moneyManager, DialogManager dialogManager) {
        this.moneyManager = moneyManager;
        this.dialogManager = dialogManager;
    }

    public void handleDialog(int currentDialogId, int selectedChoice) {
        switch (currentDialogId) {
            case 1: 
                if (selectedChoice >= 0 && selectedChoice < ZAKAT_OPTIONS.length) {
                    selectedAmount = ZAKAT_OPTIONS[selectedChoice];
                    updateConfirmationDialog();
                }
                break;
            case 2:
                if (selectedChoice == 0) { 
                    processPayment();
                } else { 
                    dialogManager.startDialog(4); 
                }
                break;
        }
    }

    private void updateConfirmationDialog() {
        DialogLine dialog = dialogManager.getDialog(2);
        if (dialog != null) {
            dialog.setMessage(String.format("Anda yakin ingin membayar zakat sebesar %.0f?", selectedAmount));
        }
    }
// Still bug in payment selectedAmount. PLZ FIX THIS :-[
    private void processPayment() {
        if (moneyManager.subtractMoney(selectedAmount)) {
            dialogManager.startDialog(3); // Pembayaran berhasil
        } else {
            dialogManager.startDialog(5); // Saldo tidak cukup
        }
    }

}
