import java.util.Scanner;

/** Class that group methods related to the console */
/**
 * Console
 */
public class Console 
{
    static private Scanner scanner = new Scanner(System.in);
      
    
    /** Closes the scanner */
    static public void closeScanner()
    {
        scanner.close();
    }


    /** Clears the Terminal */
    static public void clearTerminal()
    {
        // Constant existing within the method
        final String CLEAR_TERMINAL = "\033c";
        System.out.print(CLEAR_TERMINAL);
    }


    /**
     * Change the console title
     * @param title The new title
     */
    static public void setTitle(String title) 
    {
        // Constant that only exists within the method
        final String SET_TITLE = "\033]0;%s\007";

        // windows 10 fix
        try 
        {
            new ProcessBuilder("cmd", "/c").inheritIO().start().waitFor();
        } 
        catch (Exception exception) {};

        // Change the title
        System.out.printf(SET_TITLE, title);
    }


    /**
     * Generate a formatted banner
     * @param title
     * @return The formatted banner
     */
    static public String formatBanner(String title) 
    {
        // These variables only exists within this method formatBanner
        String line = "~~~~"; // The lines at the top and bottom of the banner
        String banner = ""; // The whole banner

        // Add one '=' for each letter in the title
        // Before the loop; condition to loop; after each iteration
        for(int count = 0; count < title.length(); count++)
        {
            line += '~';
        }

        // Format the banner and assign to a variable
        banner = line + "\n~ " + title + " ~\n" + line;

        return banner;
    }


    /**
     * Re-create the input() from python
     * @param prompt The string to be printed without ending new line 
     * @return A whole line of user input
     **/
    static public String input(String prompt)
    {
        System.out.print(prompt);
        return scanner.nextLine();
    }


    /**
     * Re-create the print() from python
     * @param prompt The text to be printed
     **/
    static void print(String prompt)
    {
        System.out.println(prompt);
    }
}