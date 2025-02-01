    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class ZakatBox here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class ZakatBox extends Box {
          private MoneyManager moneyManager;
    private MoneyDisplay moneyDisplay;
    private AlmsMission almsMission;
    
    public ZakatBox(MoneyManager moneyManager) {
        super();
        
        this.moneyManager = moneyManager;
        almsMission = new AlmsMission(this);
        moneyDisplay = new MoneyDisplay(moneyManager);
        setupDialogs();
    }
    
        protected void setupDialogs() {
            // Dialog 0: Initial question
            dialogManager.addDialog(new DialogLine(
                "Sedekah Ke Mushola?",
                new String[]{"Ya", "Tidak"},
                new int[]{1, 3},
                false
            ));
    
          
    
            // Dialog 2: Confirmation (message updated dynamically)
            dialogManager.addDialog(new DialogLine(
                "Anda yakin ingin membayar zakat?",
                new String[]{"Ya", "Tidak"},
                new int[]{2, 3},
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
        
          
    public void updateDialogForSuccess() {
        dialogManager.clearDialogs();
        
        dialogManager.addDialog(new DialogLine(
            "Jazakallah khair! Terima kasih telah sedekah.",
            null,
            new int[]{1},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Semoga Sehat selalu",
            null,
            null,
            true
        ));
        

    }
        public MoneyManager getMoneyManager() {
            return moneyManager;
        }
    
     @Override
    public void act() {
        super.act();
         if (dialogManager.isDialogActive()) {
              
            DialogLine currentDialog = dialogManager.getDialog(dialogManager.getCurrentDialogId());
            
            // Check if we're at the resolution dialog (ID 7) and conflict hasn't been rewarded yet
            if (dialogManager.getCurrentDialogId() == 2) {
                
                if (almsMission != null) {
                    almsMission.update();
                    moneyManager.subtractMoney(50.0);
                }

            }
        }
    }
    public AlmsMission getAlmsMission() {
        return almsMission;
    }
    }
