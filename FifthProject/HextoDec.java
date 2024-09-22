/*
============================================================================
FILE : HextoDec.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that will convert inputted decimal number into hexadecimal number.
COPYRIGHT : 22-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/
import javax.swing.JOptionPane;
import java.util.Scanner;

public class HextoDec {

    // Private instance variable to store the decimal number
    private int num;

    /**
     * Reads and validates a decimal number input from the user
     * 
     * Precondition: The user must input a valid integer.
     * 
     * Postcondition: The instance variable `num` is initialized with a valid decimal number.
     */
    public void readInput() {
        Scanner keyInput = new Scanner(System.in);
        boolean validInput = false;

        // Loop until valid input is provided
        while (!validInput) {
            System.out.print("Enter a decimal number: ");
            try {
                num = keyInput.nextInt(); // Attempt to read integer
                validInput = true; // Valid input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid decimal number.");
                keyInput.next(); // Clear the invalid input
            }
        }
        keyInput.close(); // Close the scanner
    }
    
    /**
     * Reads and validates a decimal number input from the user using `JOptionPane` and `try-catch`.
     * 
     * Precondition: The user must input a valid integer.
     * 
     * Postcondition: The instance variable `num` is initialized with a valid decimal number.
     */
    public void readInputGUI() {
        boolean validInput = false;

        // Loop until valid input is provided
        while (!validInput) {
            try {
                String inputStr = JOptionPane.showInputDialog(null, "Enter a decimal number:", "Input", JOptionPane.QUESTION_MESSAGE); // Input dialog
                if (inputStr == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                num = Integer.parseInt(inputStr); // Try to convert to integer
                validInput = true; // Valid input
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid decimal number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Converts the stored decimal number to its hexadecimal equivalent.
     * 
     * Precondition: The number must be a positive integer stored in `num`.
     * 
     * Postcondition: Returns the hexadecimal representation as a string.
     * 
     * @return the hexadecimal string representation of the decimal number.
     */
    public String convertToHexadecimal() {
        String hexStr = "";
        int rem;
        int tempNum = num; // Use a temporary variable for calculation

        while (tempNum > 0) { // While number greater than 0
            rem = tempNum % 16; // Get remainder (mod 16)
            switch (rem) {
                case 10:
                    hexStr = "A" + hexStr;
                    break;
                case 11:
                    hexStr = "B" + hexStr;
                    break;
                case 12:
                    hexStr = "C" + hexStr;
                    break;
                case 13:
                    hexStr = "D" + hexStr;
                    break;
                case 14:
                    hexStr = "E" + hexStr;
                    break;
                case 15:
                    hexStr = "F" + hexStr;
                    break;
                default:
                    hexStr = rem + hexStr; // Append remainder to string
                    break;
            }
            tempNum = tempNum / 16; // Divide the number by 16
        }

        return hexStr.toUpperCase();
    }

    /**
     * Displays the hexadecimal result.
     * 
     * Precondition: The hexadecimal string must be calculated beforehand.
     * 
     * Postcondition: Outputs the hexadecimal value to the console.
     * 
     */
    public void displayResult() {
    	// Convert to hexadecimal
        String hexResult = convertToHexadecimal();
        System.out.println("Hexadecimal Number: " + hexResult);
    }
    
    /**
     * Displays the hexadecimal result using `JOptionPane`.
     * 
     * Precondition: The hexadecimal string must be calculated beforehand.
     * 
     * Postcondition: Outputs the hexadecimal value using a `JOptionPane` dialog.
     * 
     * @param hexStr the hexadecimal string to display.
     */
    public void displayResultGUI() {
    	// Convert to hexadecimal
        String hexResult = convertToHexadecimal();
        JOptionPane.showMessageDialog(null,"Decimal Number: " + num + "\nHexadecimal Number: " + hexResult, "Hexadecimal to Decimal Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Create an object of the class
        HextoDec hexConverter = new HextoDec();

        // Read decimal input
        hexConverter.readInput();

        // Display the result
        hexConverter.displayResult();
    }
}
