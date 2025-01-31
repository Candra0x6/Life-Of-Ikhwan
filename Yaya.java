public class Yaya extends NPC {
    private SchoolMission schoolMission;
    private MoneyManager moneyManager;
    private boolean conflictResolved = false;
    public Yaya(MoneyManager moneyManager) {
        super();
        schoolMission = new SchoolMission(this);
        this.moneyManager = moneyManager;
    }
     
   @Override
protected void setupDialogs() {
    dialogManager.addDialog(new DialogLine(
        "Di desa ini, anak-anak punya semangat untuk belajar, tapi mereka belum punya tempat yang layak.",
        new String[]{"Bukankah mereka bisa belajar di rumah?", "Apa yang bisa kita lakukan?"},
        new int[]{1, 2},
        false
    ));

    dialogManager.addDialog(new DialogLine(
        "Belajar di rumah tentu bisa, tapi tanpa bimbingan yang baik dan tempat yang mendukung, sulit bagi mereka berkembang.",
        new String[]{"Mungkin ada solusi untuk ini.", "Ya, begitulah keadaan di desa."},
        new int[]{3, 4},
        false
    ));

    dialogManager.addDialog(new DialogLine(
        "Ya, begitulah... Tapi kalau ada tempat belajar yang lebih baik, pasti mereka bisa lebih berkembang.",
        null,
        null,
        true
    ));

    dialogManager.addDialog(new DialogLine(
        "Dulu, K.H. Ahmad Dahlan juga menghadapi hal yang sama. Beliau melihat anak-anak yang ingin belajar, tapi tidak punya tempat yang layak.",
        new String[]{"Apa yang beliau lakukan?", "Tapi membangun sekolah pasti sulit."},
        new int[]{4, 5},
        false
    ));

    dialogManager.addDialog(new DialogLine(
        "Beliau tak tinggal diam. Dengan segala keterbatasan, beliau mendirikan sekolah, walau awalnya dianggap aneh oleh banyak orang.",
        new String[]{"Bagaimana akhirnya?", "Itu pasti butuh banyak pengorbanan."},
        new int[]{6, 7},
        false
    ));

    dialogManager.addDialog(new DialogLine(
        "Tentu, membangun sekolah bukan hal yang mudah. Tapi kalau ada niat dan usaha bersama, pasti bisa diwujudkan.",
        null,
        null,
        true
    ));

    dialogManager.addDialog(new DialogLine(
        "Sekolah yang beliau bangun berkembang, dan akhirnya menjadi cikal bakal pendidikan modern yang tetap berpijak pada nilai-nilai Islam.",
        new String[]{"Jadi kita juga bisa melakukan hal yang sama?", "Itu luar biasa."},
        new int[]{8, 9},
        false
    ));

    dialogManager.addDialog(new DialogLine(
        "Betul, beliau berkorban banyak. Tapi beliau yakin, pendidikan adalah jalan untuk membangun masa depan yang lebih baik.",
        new String[]{"Jadi bagaimana kita bisa membantu?", "Itu memang penting."},
        new int[]{10, 11},
        false
    ));

    dialogManager.addDialog(new DialogLine(
        "Kita mungkin tidak bisa melakukan sebesar yang beliau lakukan, tapi kita bisa mulai dengan langkah kecil.",
        new String[]{"Seperti apa?", "Tapi apakah ini mungkin?"},
        new int[]{10, 11},
        false
    ));

    dialogManager.addDialog(new DialogLine(
        "Tentu. Membangun sekolah bukan sekadar mendirikan bangunan, tapi memberikan harapan dan ilmu bagi mereka yang membutuhkan.",
        null,
        null,
        true
    ));

    dialogManager.addDialog(new DialogLine(
        "Sebuah ruang sederhana, beberapa perlengkapan, dan dukungan dari banyak pihak. Itu saja sudah cukup untuk memulai.",
        new String[]{"Itu terdengar seperti sesuatu yang bisa diwujudkan.", "Tapi kita butuh lebih dari sekadar niat."},
        new int[]{13, 12},
        false
    ));

    dialogManager.addDialog(new DialogLine(
        "Ya, dengan sedikit usaha dan kepedulian, kita bisa membuat perubahan seperti yang beliau lakukan.",
        null,
        null,
        true
    ));

    dialogManager.addDialog(new DialogLine(
        "Memang, tapi kalau kita menunggu semua sempurna, kita tak akan pernah mulai. Yang terpenting adalah langkah pertama.",
        null,
        null,
        true
    ));

    dialogManager.addDialog(new DialogLine(
        "Setiap langkah kecil bisa membawa perubahan besar. Seperti yang dilakukan K.H. Ahmad Dahlan, kita hanya perlu keberanian untuk memulai.",
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
            "Semoga Sehat selalu",
            null,
            null,
            true
        ));
        
        if (player != null) {
            moneyManager.addMoney(500); // Memberikan reward 500 koin
            schoolMission.setRewardGiven(true);
        }
    }
    
    @Override
    public void act() {
        super.act();
         if (dialogManager.isDialogActive()) {
              
            DialogLine currentDialog = dialogManager.getDialog(dialogManager.getCurrentDialogId());
            System.out.println(dialogManager.getCurrentDialogId() );
            // Check if we're at the resolution dialog (ID 7) and conflict hasn't been rewarded yet
            if (dialogManager.getCurrentDialogId() == 13) {
                
                if (schoolMission != null) {
            schoolMission.update();
        }
                    moneyManager.addMoney(500);
                    conflictResolved = true;
                    
            }
        }
    }
    
    
    public SchoolMission getSchoolMission() {
        return schoolMission;
    }
}