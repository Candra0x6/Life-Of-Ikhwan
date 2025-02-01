public class Zero extends NPC {
    private ToleranceMission toleranceMission;
    private MoneyManager moneyManager;
    private boolean conflictResolved = false;
    public Zero(MoneyManager moneyManager, DialogManager dialogManager) {
        super(dialogManager);
          setImage("NPC6.png");
        getImage().scale(100, 100);
        toleranceMission = new ToleranceMission(this);
        this.moneyManager = moneyManager;
    }
     
    @Override
    protected void setupDialogs() {
        dialogManager.addDialog(new DialogLine(
            "Assalamualaikum, saya melihat ada konflik di dekat masjid. Beberapa orang sedang berdebat tentang perbedaan cara beribadah.",
            new String[]{"Saya akan membantu menengahi", "Biarkan saja, itu urusan mereka"},
            new int[]{1, 2},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Terima kasih! Mari kita bantu selesaikan dengan cara yang damai.",
            new String[]{"Dengarkan kedua belah pihak", "Langsung minta mereka berdamai"},
            new int[]{3, 4},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Baiklah, silahkan lanjutkan aktivitas Anda.",
            null,
            null,
            true
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Kita harus mendengarkan masalah dari kedua belah pihak terlebih dahulu.",
            new String[]{"Cari solusi bersama", "Menyalahkan salah satu pihak"},
            new int[]{5, 4},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Maaf, sepertinya cara ini kurang tepat. Konflik masih belum selesai.",
            null,
            null,
            true
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Alhamdulillah, kedua belah pihak setuju untuk membuat jadwal ibadah yang tidak bertabrakan.",
            null,
            null,
            false
        ));
    }
    
    public void updateDialogForSuccess() {
        dialogManager.clearDialogs();
        
        dialogManager.addDialog(new DialogLine(
            "Jazakallah khair! Terima kasih telah membantu menyelesaikan konflik dengan cara yang damai.",
            null,
            new int[]{1},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Semoga Sehat selalu 😲😲😲😲😲😲😲😲😲😲😲",
            null,
            null,
            true
        ));
        
        if (player != null) {
            moneyManager.addMoney(500); // Memberikan reward 500 koin
            toleranceMission.setRewardGiven(true);
        }
    }
    
    @Override
    public void act() {
        super.act();
         if (dialogManager.isDialogActive()) {
              
            DialogLine currentDialog = dialogManager.getDialog(dialogManager.getCurrentDialogId());
            
            // Check if we're at the resolution dialog (ID 7) and conflict hasn't been rewarded yet
            if (dialogManager.getCurrentDialogId() == 5 && !conflictResolved) {
                
                if (toleranceMission != null) {
            toleranceMission.update();
        }
                    moneyManager.addMoney(500);
                    conflictResolved = true;
                    
            }
        }
    }
    
    
    public ToleranceMission getToleranceMission() {
        return toleranceMission;
    }
}