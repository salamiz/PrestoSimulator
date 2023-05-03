/**
 * PrestoCard class to create an object of a card
 */
public class PrestoCard 
{
    // variables only accessible within the class
    private double balance;
    private String name;

    /**
     * Constructor to be accessible outide the class, i.e., an Object of the class
     * @param balance the balance of an object of the PrestoCard
     * @param name the name of an object of the PrestoCard
     */
    public PrestoCard(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    /**
     * Generate the PrestoCard object balance
     * @return the card balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Generate the PrestoCard object name
     * @return the cards name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to tap presto card
     * @param fare
     * @return boolean true if sufficient funds for fare, or false if insufficient funds for fare
     */
    boolean tap(double fare)
    {
        fare = 2.50;
        if (balance >= fare){
            balance -= fare; // deduct the fixed fare of $2.50
            return true;
        }
        else{
            return false; // insufficient funds to tap
        }
        
    }

    /**
     * Method to add funds to the card balance
     * @param funds amount to be added to card object
     */
    void topUp(double funds)
    {
        balance += funds;
    }
    
    
}
