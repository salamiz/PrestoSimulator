// Name: Zulkifli Salami
// Date: March 27th, 2023
// App Name: Presto Simulator
// Description: App to simulate some functions in the Presto card system in Canada

import java.util.ArrayList;
import java.util.Scanner;

public class PrestoSimulator 
{
    static final int TWO_SECOND = 2000; // 1s = 1000ms

    /**
     * Stop for a second
     */
    static void waitAsecond()
    {
        try {
            Thread.sleep(TWO_SECOND);
        } catch (Exception exception) {
        }
    }

    static final String DESCRIPTION = """
        Program that simulates Presto Cards    
        """;
    public static void main(String[] args) 
    {
        // Set the App title from the Console Class
        Console.setTitle("Presto Simulator - Zulkifli Salami");

        // An array list of PrestoCard
        ArrayList<PrestoCard> prestoCards = new ArrayList<PrestoCard>();
        // Add cards
        prestoCards.add(new PrestoCard(5, "Fred"));
        prestoCards.add(new PrestoCard(15, "Lilly"));
        prestoCards.add(new PrestoCard(2, "Jimmy"));
        
        // Variables 
        Scanner scanner = new Scanner(System.in);
        String banner;
        boolean running = true;
        boolean numeric; // for numeric validation
        String command;
        String name;
        double balance = 0;
        int index = 0; // prestoCard index
        double amount = 0;

        // Print the App Banner from the console class
        banner = Console.formatBanner("Presto Simulator");

        // CLI main loop
        do {
            // Clear terminal from the Console class
            Console.clearTerminal();
            System.out.println(banner);
            System.out.println(DESCRIPTION);
            // Show how many cards we have 
            System.out.print("\nWe currently have "+prestoCards.size()+" Cards!\n");

            // Using a for loop to print out each of the prestoCards detail
            for(int count = 0; count < prestoCards.size(); count++)
            {
                System.out.printf("%s - %s - Balance: $ %.2f\n", count+1,prestoCards.get(count).getName(),prestoCards.get(count).getBalance());
            }

            // Prompt user for a command
            System.out.print("\nEnter a command: ");
            command = scanner.next(); // gets a word before the whitespace

            // Quit app
            if (command.equals("quit")) 
            {
                // exit prompt
                Console.print("Shutting Down !");  
                running = false; // stop running 
            }

            // Add a prestoCards
            else if (command.equals("add")) 
            {
                name = scanner.next();
                // Try to get a double balance
                try {
                    balance = scanner.nextDouble();
                    numeric = true;
                } catch (Exception exception) {
                    numeric = false;
                }

                // if balance is not numeric
                if(!numeric) System.out.println("Error - Invalid input!");
                // Valid balance
                else prestoCards.add(new PrestoCard(balance,name));
            }
            
            // remove a prestoCard 
            else if (command.equals("del")) 
            {
                // Try to get a int index
                try {
                    index = scanner.nextInt();
                    numeric = true;
                } catch (Exception exception) {
                    numeric = false;
                }

                // Convert from log ID to index
                index--;

                // if index is not numeric or out of bounds
                if(!numeric || index < 0 || index >= prestoCards.size()) System.out.println("Error - Invalid index input!");
                // Valid index
                else prestoCards.remove(index);
            }

            // tap card
            else if (command.equals("tap"))
            {
                // Try to get a int index
                try {
                    index = scanner.nextInt();
                    numeric = true;
                } catch (Exception exception) {
                    numeric = false;
                }
                // Convert from log ID to index
                index--;

                // if index is not numeric or out of bounds
                if(!numeric || index < 0 || index >= prestoCards.size()) System.out.println("Error - Invalid index input!");
                // Valid index
                else {
                    PrestoCard card = prestoCards.get(index);
                    if (card.tap(index)==true){
                        System.out.println("Tap successful. Fare deducted: $2.50");
                    } else{
                        System.out.println("Not enough funds to tap.");
                    }
                }
            }

            // topUp card
            else if (command.equals("topup"))
            {
                // Try to get a int index
                try {
                    index = scanner.nextInt();
                    numeric = true;
                } catch (Exception exception) {
                    numeric = false;
                }

                // Convert from log ID to index
                index--;

                // Try to get a double amount
                try {
                    amount = scanner.nextInt();
                    numeric = true;
                } catch (Exception exception) {
                    numeric = false;
                }

                // if index is not numeric or out of bounds
                if(!numeric || index < 0 || amount < 0 || index >= prestoCards.size()) System.out.println("Error - Invalid index input!");
                // Valid index
                else {
                    PrestoCard card = prestoCards.get(index);
                    card.topUp(amount);
                }
            }

            // Invalid command
            else
                System.out.println("Error - Invalid command");

            // Get rid of extra input
            scanner.nextLine();

            // wait for a second
            waitAsecond();

        } while (running);
        
        // Closing the Scanner from the Console Class 
        Console.closeScanner();  
        scanner.close(); 
    }
}
