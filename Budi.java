import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Budi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Budi extends NPC
{
     private WalletMission walletMission;
        private MoneyManager moneyManager;
        private boolean foundWallet = false;

    public Budi(MoneyManager moneyManager) {
        super();
        this.moneyManager = moneyManager;
        walletMission = new WalletMission(this);
    }
    
    @Override
    protected void setupDialogs() {
        // Dialog sebelum dompet ditemukan
        dialogManager.addDialog(new DialogLine(
            "Aduh... dompetku hilang. Apa kamu bisa membantuku mencarinya?",
            new String[]{"Tentu, akan kubantu mencari", "Maaf, aku sedang sibuk"},
            new int[]{1, 2},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Terima kasih! Terakhir kali aku ingat membawanya di sekitar sini.",
            null,
            null,
            true
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Baiklah, tidak apa-apa. Mungkin aku akan mencarinya sendiri.",
            null,
            null,
            true
        ));
    }
    
    public void updateDialogForWallet() {
        // Hapus dialog lama
        dialogManager.clearDialogs();
        foundWallet = true;
        
        // Tambah dialog baru setelah dompet ditemukan
        dialogManager.addDialog(new DialogLine(
            "Ah! Itu dompetku! Terima kasih banyak telah menemukannya!",
            null,
            new int[]{1},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Kamu sangat jujur dan baik hati. Ini hadiah untukmu!",
            null,
            null,
            true
        ));
       
    }
    
    @Override
    public void act() {
        super.act();
        if (walletMission != null) {
            walletMission.update();
        }
    }
    
    public boolean isFoundWallet(){
        return foundWallet;
    }
    
    public void addPoint() {
        moneyManager.addMoney(100.0);
    }
    public WalletMission getWalletMission() {
        return walletMission;
    }
}
