/**
 * Write a description of class GameManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager  
{
    
    
    private static GameManager instance;

    /**
     * Constructor for objects of class GameManager
     */
    private GameManager()
    {
    }
    
    // create a singleton
    public static GameManager getInstance(){
        if (instance == null){
            instance = new GameManager();
        }
        return instance;
    }

    
}
