/*
============================================================================
FILE : MultiplytheDigits.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : Reads an integer between 0 and 1000. Display and multiplies all the digits in the integer
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

public class MultiplytheDigits {

    // Instance variables
    private int originalAmount;
    private int n1, n2, n3;

    /**
     * Reads the input amount from the user and validates it.
     * 
     * Precondition: The user must enter a valid integer between 0 and 1000.
     * 
     * Postcondition: The `originalAmount` is initialized with the user input if it is valid.
     */
    public void readInput() {
        Scanner keyInput = new Scanner(System.in);

        System.out.println("Enter amount (from 0-1000):");
        String s1 = keyInput.nextLine(); // Input
        originalAmount = Integer.parseInt(s1); // Converts string into int

        // Input validation
        while (originalAmount < 0 || originalAmount > 1000) {
            System.out.println("Invalid input. Please enter an amount between 0 and 1000:");
            s1 = keyInput.nextLine();
            originalAmount = Integer.parseInt(s1);
        }

        keyInput.close(); // Close the scanner
    }
    
    /**
     * Reads the input amount from the user via `JOptionPane` and validates it.
     * 
     * Precondition: The user must enter a valid integer between 0 and 1000.
     * 
     * Postcondition: The `originalAmount` is initialized with the user input if it is valid.
     */
    public void readInputGUI() {
        boolean validInput = false;

        // Loop to get valid input
        while (!validInput) {
            try {
                String s1 = JOptionPane.showInputDialog(null, "Enter amount (from 0-1000):", "Input", JOptionPane.QUESTION_MESSAGE);
                if (s1 == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                originalAmount = Integer.parseInt(s1); // Convert string into int

                // Input validation for range 0-1000
                if (originalAmount >= 0 && originalAmount <= 1000) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 0 and 1000.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /**
     * Extracts the individual digits of the original amount and multiplies them together.
     * 
     * Precondition: `originalAmount` must be initialized with a valid number.
     * 
     * Postcondition: Returns the product of the digits.
     * 
     * @return the product of the digits of the original amount.
     */
    private int calculateProduct() {
        int temp = (originalAmount / 100) % 10; // Get the first digit (hundreds place)
        int temp2 = (originalAmount / 10) % 10; // Get the second digit (tens place)
        int product;
        if (temp == 0) {
            n1 = 1; // If the first digit is 0, treat it as 1 for multiplication
        } else {
            n1 = temp; // Otherwise, use the original value
        }
        
        if (temp2 == 0) {
            n2 = 1; // If the first digit is 0, treat it as 1 for multiplication
        } else {
            n2 = temp2; // Otherwise, use the original value
        }
        
        n3 = originalAmount % 10; // Get the third digit (ones place)
        product = n1 * n2 * n3;
        
        n1 = temp;
        n2 = temp2;
        // Calculate the product of the digits and return it
        return product;
    }

    /**
     * Outputs the individual digits and their product.
     * 
     * Precondition: The digits must be extracted from `originalAmount`.
     * 
     * Postcondition: The individual digits and their product are displayed to the user.
     */
    public void writeOutput() {
        int product = calculateProduct(); // Call the private method to get the product
        System.out.println("First digit: " + n1);
        System.out.println("Second digit: " + n2);
        System.out.println("Third digit: " + n3);
        System.out.println("The product of the digits is: " + product);
    }
    
    /**
     * Outputs the individual digits and their product using `JOptionPane`.
     * 
     * Precondition: The digits must be extracted from `originalAmount`.
     * 
     * Postcondition: The individual digits and their product are displayed in a `JOptionPane` dialog.
     */
    public void writeOutputGUI() {
        int product = calculateProduct(); // Call the private method to get the product
        String result = String.format("First digit: %d\nSecond digit: %d\nThird digit: %d\nThe product of the digits is: %d", n1, n2, n3, product);
        JOptionPane.showMessageDialog(null, result, "Multiplied Digits Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
