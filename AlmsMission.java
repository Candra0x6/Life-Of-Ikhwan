import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AlmsMission here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlmsMission extends Mission
{
    private ZakatBox zakatBox;
    private Player player;

    public AlmsMission(ZakatBox zakatBox) {
        super("Misi Sedekah: Bersedekah ke mushola");
        this.id = 2;
        this.zakatBox = zakatBox;
    }

    public void act() {
        // Add your action code here.
        if (!isCompleted) {
            update();
        }
    }

    public void update() {

        if (!isCompleted) {

            complete();
            zakatBox.updateDialogForSuccess();
        }
    }

    public ZakatBox getZakatBox() {
        return zakatBox;
    }
}
