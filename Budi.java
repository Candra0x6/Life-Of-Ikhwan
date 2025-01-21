import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Budi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Budi extends NPC
{
    @Override
    protected void setupDialogs() {
        // Dialog awal (0)
        dialogManager.addDialog(new DialogLine(
            "Halo! Selamat datang di kebunku.",
            new String[]{"Apa yang kamu tanam?", "Bagaimana hasil panen?", "Sampai jumpa"},
            new int[]{1, 4, 7},
            false
        ));
        
        // Cabang "Apa yang kamu tanam?" (1-3)
        dialogManager.addDialog(new DialogLine(
            "Aku menanam berbagai sayuran disini. Terutama wortel dan kentang.",
            null,
            new int[]{2},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Wortel sangat mudah ditanam dan menguntungkan!",
            null,
            new int[]{3},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Mau mencoba menanam juga?",
            new String[]{"Ya, ajari aku!", "Lain kali saja"},
            new int[]{8, 0},  // ID 8 mengarah ke tutorial menanam
            false
        ));
        
        // Cabang "Bagaimana hasil panen?" (4-6)
        dialogManager.addDialog(new DialogLine(
            "Panen kali ini sangat bagus!",
            null,
            new int[]{5},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Cuaca sangat mendukung tahun ini.",
            null,
            new int[]{6},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Kamu harus mencoba wortel hasil panenku!",
            new String[]{"Boleh, aku mau beli!", "Mungkin lain kali"},
            new int[]{9, 0},
            false
        ));
        
        // Dialog "Sampai jumpa" (7)
        dialogManager.addDialog(new DialogLine(
            "Sampai jumpa lagi! Datang lagi ya!",
            null,
            null,
            true
        ));
        
        // Dialog mengajar menanam (8)
        dialogManager.addDialog(new DialogLine(
            "Baiklah! Pertama-tama kamu perlu bibit wortel.",
            null,
            new int[]{10},  // Mengarah ke dialog bibit
            false
        ));
        
        // Dialog beli hasil panen (9)
        dialogManager.addDialog(new DialogLine(
            "Tentu! Aku punya wortel segar hasil panen.",
            null,
            new int[]{12},
            false
        ));
        
        // Dialog bibit (10) - Dialog yang tidak muncul sebelumnya
        dialogManager.addDialog(new DialogLine(
            "Bibit wortel harganya 20 gold. Mau beli berapa?",
            new String[]{"Beli 5 bibit", "Beli 10 bibit", "Tidak jadi"},
            new int[]{15, 16, 0},
            false
        ));
        
        // Dialog wortel (11-12)
        dialogManager.addDialog(new DialogLine(
            "Ini wortel segarnya! Harganya 100 gold per wortel.",
            null,
            new int[]{12},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Mau beli berapa?",
            new String[]{"Beli 5 wortel", "Beli 10 wortel", "Tidak jadi"},
            new int[]{13, 14, 0},
            false
        ));
        
        // Hasil transaksi wortel (13-14)
        dialogManager.addDialog(new DialogLine(
            "Terima kasih sudah membeli 5 wortel! Ini wortelnya.",
            null,
            new int[]{0},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Terima kasih sudah membeli 10 wortel! Ini wortelnya.",
            null,
            new int[]{0},
            false
        ));
        
        // Hasil transaksi bibit (15-16)
        dialogManager.addDialog(new DialogLine(
            "Terima kasih sudah membeli 5 bibit! Ini bibitnya.",
            null,
            new int[]{0},
            false
        ));
        
        dialogManager.addDialog(new DialogLine(
            "Terima kasih sudah membeli 10 bibit! Ini bibitnya.",
            null,
            new int[]{0},
            false
        ));
    }
   
}
