import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class DIalogManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogManager extends ScrollActor
{
     private List<DialogLine> dialogLines;
    private int currentDialogId;
    private int selectedChoice;
    public boolean isDialogActive;
    private Font dialogFont;
    private Color dialogBoxColor;
    private Color textColor;
    private GreenfootImage dialogBoxImage; // Background image untuk dialog box
    private int selectedOptionIndex;
    
    public DialogManager() {
        dialogLines = new ArrayList<>();
        currentDialogId = 0;
        selectedChoice = 0;
        isDialogActive = false;
        dialogFont = new Font("Arial", 16);
        dialogBoxColor = new Color(0, 0, 0, 180);
        textColor = Color.BLACK;
        
        setupDialogBoxImage();

    }
        public int getCurrentDialogId() { return currentDialogId; }
    public int getSelectedOptionIndex() { return selectedOptionIndex; }
    public boolean isDialogActive() { return isDialogActive; }
    
    public void addDialog(DialogLine dialog) {
        dialogLines.add(dialog);
    }
    
    public void startDialog(int dialogId) {
        currentDialogId = dialogId;
        isDialogActive = true;
        selectedChoice = 0;
    }
    
 
    public void update() {
    if (!isDialogActive) return;

    // Pastikan currentDialogId valid
    if (currentDialogId < 0 || currentDialogId >= dialogLines.size()) {
        isDialogActive = false; // Tutup dialog jika ID tidak valid
        return;
    }

    DialogLine current = dialogLines.get(currentDialogId);

    // Handle input untuk memilih opsi
    if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
        selectedChoice = Math.max(0, selectedChoice - 1);
        Greenfoot.delay(10); // Prevent multiple inputs
    }
    if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
        if (current.getChoices() != null && current.getChoices().length > 0) {
            selectedChoice = Math.min(current.getChoices().length - 1, selectedChoice + 1);
        }
        Greenfoot.delay(10);
    }

    // Handle input untuk memilih opsi atau melanjutkan dialog
    if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")) {
        if (current.isEnd()) {
            // Jika dialog selesai, tutup dialog
            isDialogActive = false;
        } else if (current.getChoices() == null || current.getChoices().length == 0) {
            // Jika tidak ada pilihan, lanjutkan ke dialog berikutnya (jika ada)
            if (current.getNextDialogIds() != null && current.getNextDialogIds().length > 0) {
                currentDialogId = current.getNextDialogIds()[0];
            } else {
                // Jika tidak ada dialog berikutnya, tutup dialog
                isDialogActive = false;
            }
        } else {
            // Jika ada pilihan, lanjutkan ke dialog yang sesuai dengan pilihan
            if (current.getNextDialogIds() != null && selectedChoice >= 0 && selectedChoice < current.getNextDialogIds().length) {
                int nextId = current.getNextDialogIds()[selectedChoice];
                if (nextId >= 0 && nextId < dialogLines.size()) {
                    currentDialogId = nextId;
                } else {
                    // Jika ID dialog berikutnya tidak valid, tutup dialog
                    isDialogActive = false;
                }
            } else {
                // Jika tidak ada dialog berikutnya yang valid, tutup dialog
                isDialogActive = false;
            }
        }
        selectedChoice = 0; // Reset pilihan
        Greenfoot.delay(10); // Prevent multiple inputs
    }
}
    
    private void setupDialogBoxImage() {
        try {
            // Load gambar dialog box
            dialogBoxImage = new GreenfootImage("dialogbox.png");  // Pastikan file ada di folder images
            // Anda bisa menyesuaikan ukuran gambar jika perlu
            // dialogBoxImage.scale(400, 150);
        } catch (Exception e) {
            // Fallback ke background solid jika gambar tidak ditemukan
            dialogBoxImage = new GreenfootImage(400, 150);
            dialogBoxImage.setColor(new Color(0, 0, 0, 180));
            dialogBoxImage.fill();
        }
    }
    
    public void draw(GreenfootImage image) {
        if (!isDialogActive || dialogLines.isEmpty() || currentDialogId >= dialogLines.size()) {
            return;
        }
        
        DialogLine current = dialogLines.get(currentDialogId);
        
        // Hitung posisi dialog box
        int boxX = 20;
        int boxY = image.getHeight() - dialogBoxImage.getHeight() - 20;
        
        // Draw dialog box background
        image.drawImage(dialogBoxImage, boxX, boxY);
        
        // Setup text drawing
        image.setFont(dialogFont);
        image.setColor(textColor);
        
        // Draw main dialog text
        drawWrappedText(image, current.getText(), boxX + 50, boxY + 80, dialogBoxImage.getWidth() - 40);
        
        // Draw choices if any
        if (current.getChoices() != null) {
            int choiceY = boxY + 100;
            for (int i = 0; i < current.getChoices().length; i++) {
                String prefix = (i == selectedChoice) ? "> " : "  ";
                image.drawString(prefix + current.getChoices()[i], boxX + 60, choiceY);
                choiceY += 25;
            }
        }
    }
    
    // Method untuk mengubah gambar dialog box saat runtime jika diperlukan
    public void setDialogBoxImage(String imagePath) {
        try {
            GreenfootImage newImage = new GreenfootImage(imagePath);
            dialogBoxImage = newImage;
        } catch (Exception e) {
            System.out.println("Error loading dialog box image: " + imagePath);
        }
    }
      public DialogLine getDialog(int dialogId) {
        if (dialogId >= 0 && dialogId < dialogLines.size()) {
            return dialogLines.get(dialogId);
        }
        return null; // Return null if the dialog ID is invalid
    } 
    // Method untuk mengatur opacity dialog box
    public void setDialogBoxOpacity(int opacity) {
        GreenfootImage newImage = new GreenfootImage(dialogBoxImage);
        newImage.setTransparency(opacity); // 0-255
        dialogBoxImage = newImage;
    }
     public boolean hasDialogs() {
        return !dialogLines.isEmpty();
    }
     private void drawWrappedText(GreenfootImage image, String text, int x, int y, int maxWidth) {
        // Simplified text wrapping menggunakan panjang string
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();
        int currentY = y;
        int approxCharWidth = 10; // Perkiraan lebar per karakter
        
        for (String word : words) {
            String testLine = line.toString() + " " + word;
            if (testLine.length() * approxCharWidth > maxWidth) {
                image.drawString(line.toString(), x, currentY);
                line = new StringBuilder(word);
                currentY += 25;
            } else {
                if (line.length() > 0) line.append(" ");
                line.append(word);
            }
        }
        image.drawString(line.toString(), x, currentY);
    }
}
