/*
============================================================================
FILE : ChangeDenomination.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : Determines the change to be dispenses from a vending machine. The user enters an amount between 1 cent and 99 cents. The program determines a combination of coins equal to that amount. Denominations is in a formed of: quarter, dime, nickel and penny.
COPYRIGHT : 22-09-2024
REVISION HISTORY
Date: By: Description:
revision date author description of the change
revision date author description of the change
.
.
.
revision date author description of the change
============================================================================
*/
import javax.swing.JOptionPane;
import java.util.Scanner;

public class ChangeDenomination {

    // Instance variables for storing the amount entered by the user and the coin counts
    private int amount;
    private int quarters, dimes, nickels, pennies;

    // Constants for coin values
    private static final int QUARTER = 25;
    private static final int DIME = 10;
    private static final int NICKEL = 5;
    @SuppressWarnings("unused")
	private static final int PENNY = 1;

    /**
     * Reads the input amount from the user through the command line interface.
     * 
     * Preconditions: None.
     * Postconditions: The amount is stored in the `amount` variable. 
     * If the amount is invalid (outside the range of 1-99 cents), 
     * the user will be prompted to re-enter a valid amount.
     */
    public void readInput() {
    	boolean validInput = false;
        Scanner keyInput = new Scanner(System.in);

        // Input validation for amount between 1 and 99
        while (!validInput) {
            System.out.println("Enter amount (from 1-99 cents):");

            try {
                amount = Integer.parseInt(keyInput.nextLine()); // Try to parse the input as an integer

                // Check if amount is within the valid range
                if (amount < 1 || amount > 99) {
                    System.out.println("Invalid input. Please enter an amount between 1 and 99 cents.");
                } else {
                    validInput = true; // Valid input, exit the loop
                }

            } catch (NumberFormatException e) {
                // Handle non-integer input
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
        keyInput.close(); // Close the scanner
    }

    /**
     * Reads the input amount from the user through a graphical user interface (GUI).
     * 
     * Preconditions: None.
     * Postconditions: The amount is stored in the `amount` variable. 
     * If the input is invalid (empty, null, or outside the range of 1-99), 
     * an error message is shown, and the user is prompted to enter a valid amount.
     * 
     * If the user clicks cancel, the program exits.
     */
    public void readInputGUI() {
        boolean validInput = false;

        while (!validInput) {
            String input = JOptionPane.showInputDialog(null, "Enter amount (from 1-99 cents):", "Input", JOptionPane.QUESTION_MESSAGE);

            // Check for null (if the user clicks Cancel) or empty input
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            try {
                amount = Integer.parseInt(input);

                // Input validation for amount between 1 and 99
                if (amount >= 1 && amount <= 99) {
                    validInput = true; // Valid input received, exit loop
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter an amount between 1 and 99 cents.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Calculates the number of quarters, dimes, nickels, and pennies based on the amount.
     * 
     * Preconditions: The `amount` variable must be initialized and valid (between 1 and 99).
     * Postconditions: The number of quarters, dimes, nickels, and pennies are calculated and stored 
     * in their respective instance variables (`quarters`, `dimes`, `nickels`, and `pennies`).
     */
    public void calculateChange() {
        quarters = amount / QUARTER;
        amount = amount % QUARTER;  // Update amount after quarters are taken out

        dimes = amount / DIME;
        amount = amount % DIME;  // Update amount after dimes are taken out

        nickels = amount / NICKEL;
        amount = amount % NICKEL;  // Update amount after nickels are taken out

        pennies = amount;  // Remaining amount is the number of pennies
    }

    /**
     * Outputs the calculated values of quarters, dimes, nickels, and pennies to the console.
     * 
     * Preconditions: The `calculateChange()` method must be called beforehand to ensure the 
     * values of quarters, dimes, nickels, and pennies are computed.
     * Postconditions: The calculated values of quarters, dimes, nickels, and pennies are printed 
     * to the command line.
     */
    public void writeOutput() {
        System.out.println("The number of QUARTERS is: " + quarters);
        System.out.println("The number of DIMES is: " + dimes);
        System.out.println("The number of NICKELS is: " + nickels);
        System.out.println("The number of PENNIES is: " + pennies);
    }

    /**
     * Outputs the calculated values of quarters, dimes, nickels, and pennies to a graphical user interface (GUI).
     * 
     * Preconditions: The `calculateChange()` method must be called beforehand to ensure the 
     * values of quarters, dimes, nickels, and pennies are computed.
     * Postconditions: The calculated values of quarters, dimes, nickels, and pennies are shown 
     * in a GUI message box.
     */
    public void writeOutputGUI() {
        String result = "The number of QUARTERS is: " + quarters + "\n" +
                        "The number of DIMES is: " + dimes + "\n" +
                        "The number of NICKELS is: " + nickels + "\n" +
                        "The number of PENNIES is: " + pennies;
        JOptionPane.showMessageDialog(null, result, "Change Denomination Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
