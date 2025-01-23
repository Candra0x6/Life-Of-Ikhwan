import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoneyManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoneyManager extends ScrollActor
{
     private double balance;
    
    public MoneyManager(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public boolean addMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
    
    public boolean subtractMoney(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean hasEnoughMoney(double amount) {
        return balance >= amount;
    }
}
