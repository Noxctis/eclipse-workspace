/*
============================================================================
FILE : ChocolateBars.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : The program should then output the number of chocolate bars that should be consumed to maintain one’s weight for both a woman and a man of the input weight, height, and age.
COPYRIGHT : 22-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/
import javax.swing.JOptionPane;
import java.util.Scanner;

public class ChocolateBars {

    // Instance variables for storing input values
    private double weightInPounds, heightInInches, ageInYears;
    private double BMRwomen, BMRmen;
    private double womenCalo, menCalo;

    // Constant for the calories in one chocolate bar
    private static final int CHOCOCALO = 230;

    /**
     * Reads input values for weight, height, and age using Scanner.
     * 
     * Preconditions: The input values for weight, height, and age must be positive numbers.
     * Postconditions: The user inputs valid weight, height, and age, which are stored in the instance variables.
     * 
     * The method prompts the user for input, validating that each value is positive. 
     * If invalid input is provided, the user is prompted again.
     */
    public void readInput() {
    	boolean validInput = false;
        Scanner keyInput = new Scanner(System.in);

        // Validate and read weight input
        while (!validInput) {
            System.out.println("Enter weight in pounds:");
            
            try {
                weightInPounds = keyInput.nextDouble(); // Try to read a double value
                
                if (weightInPounds <= 0) {
                    System.out.println("Weight must be a positive number. Please try again.");
                } else {
                    validInput = true; // Valid input, exit the loop
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                keyInput.next(); // Clear the invalid input
            }
        }
        validInput = false;
        // Validate and read height input
        while (!validInput) {
            System.out.println("Enter height in inches:");
            
            try {
                heightInInches = keyInput.nextDouble(); // Try to read a double value
                
                if (heightInInches <= 0) {
                    System.out.println("Height must be a positive number. Please try again.");
                } else {
                    validInput = true; // Valid input, exit the loop
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                keyInput.next(); // Clear the invalid input
            }
        }
        validInput = false;
        // Validate and read age input
        while (!validInput) {
            System.out.println("Enter age in years:");
            
            try {
                ageInYears = keyInput.nextDouble(); // Try to read a double value
                
                if (ageInYears <= 0) {
                    System.out.println("Age must be a positive number. Please try again.");
                } else {
                    validInput = true; // Valid input, exit the loop
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                keyInput.next(); // Clear the invalid input
            }
        }
        keyInput.close(); // Close the scanner
    }
    
    /**
     * Reads input values for weight, height, and age using JOptionPane.
     * 
     * Preconditions: The input values for weight, height, and age must be positive numbers.
     * Postconditions: The user inputs valid weight, height, and age, which are stored in the instance variables.
     * 
     * The method prompts the user for input, validating that each value is positive.
     * If invalid input is provided, the user is prompted again.
     */
    public void readInputGUI() {
        // Validate and read weight input
        boolean validInput = false;
        while (!validInput) {
            try {
                String weightInput = JOptionPane.showInputDialog(null, "Enter weight in pounds:", "Input", JOptionPane.QUESTION_MESSAGE);
                // Check for null (if the user clicks Cancel) or empty input
                if (weightInput == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                weightInPounds = Double.parseDouble(weightInput);
                if (weightInPounds > 0) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Weight must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for weight.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Validate and read height input
        validInput = false;
        while (!validInput) {
            try {
                String heightInput = JOptionPane.showInputDialog(null, "Enter height in inches:", "Input", JOptionPane.QUESTION_MESSAGE);
                if (heightInput == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                heightInInches = Double.parseDouble(heightInput);
                if (heightInInches > 0) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Height must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for height.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Validate and read age input
        validInput = false;
        while (!validInput) {
            try {
                String ageInput = JOptionPane.showInputDialog(null, "Enter age in years:", "Input", JOptionPane.QUESTION_MESSAGE);
                if (ageInput == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                ageInYears = Double.parseDouble(ageInput);
                if (ageInYears > 0) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Age must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for age.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /**
     * Calculates BMR (Basal Metabolic Rate) for men and women based on the input values of weight, height, and age.
     * 
     * Preconditions: The values for `weightInPounds`, `heightInInches`, and `ageInYears` must be positive and initialized.
     * Postconditions: The BMR values for women and men are calculated and stored in `BMRwomen` and `BMRmen`.
     * 
     * BMRwomen is calculated using the formula:
     * BMR = 655 + (4.3 * weightInPounds) + (4.7 * heightInInches) - (4.7 * ageInYears)
     * 
     * BMRmen is calculated using the formula:
     * BMR = 66 + (6.3 * weightInPounds) + (12.9 * heightInInches) - (6.8 * ageInYears)
     */
    public void calculateBMR() {
        BMRwomen = 655 + (4.3 * weightInPounds) + (4.7 * heightInInches) - (4.7 * ageInYears);
        BMRmen = 66 + (6.3 * weightInPounds) + (12.9 * heightInInches) - (6.8 * ageInYears);
    }

    /**
     * Calculates the number of chocolate bars needed to maintain weight based on BMR for men and women.
     * 
     * Preconditions: The BMR values for men and women (`BMRwomen` and `BMRmen`) must be calculated.
     * Postconditions: The number of chocolate bars required for men and women to maintain their weight is calculated
     * and stored in `womenCalo` and `menCalo`.
     * 
     * Each value is calculated by dividing the BMR by the constant calorie value per chocolate bar (`CHOCOCALO`).
     */
    public void calculateChocolateBars() {
        womenCalo = BMRwomen / CHOCOCALO;
        menCalo = BMRmen / CHOCOCALO;
    }

    /**
     * Outputs the calculated values for BMR and chocolate bar consumption for both men and women.
     * 
     * Preconditions: The methods `calculateBMR()` and `calculateChocolateBars()` must be called beforehand
     * to ensure the values are calculated.
     * Postconditions: The BMR and chocolate bar requirements are displayed to the console.
     * 
     * The output includes the BMR values for men and women and the number of chocolate bars needed to maintain weight.
     */
    public void writeOutput() {
        System.out.println("\nResults:");
        System.out.println("BMR for women: " + BMRwomen);
        System.out.println("BMR for men: " + BMRmen);
        System.out.println("Chocolate bars needed for women: " + (int) womenCalo);
        System.out.println("Chocolate bars needed for men: " + (int) menCalo);
    }
    
    /**
     * Outputs the calculated values for BMR and chocolate bar consumption for both men and women using JOptionPane.
     * 
     * Preconditions: The methods `calculateBMR()` and `calculateChocolateBars()` must be called beforehand
     * to ensure the values are calculated.
     * Postconditions: The BMR and chocolate bar requirements are displayed in a JOptionPane message dialog.
     */
    public void writeOutputGUI() {
        String result = String.format("Results:\n\n" +
                        "BMR for women: %.2f\n" +
                        "BMR for men: %.2f\n\n" +
                        "Chocolate bars needed for women: %d\n" +
                        "Chocolate bars needed for men: %d",
                BMRwomen, BMRmen, (int) womenCalo, (int) menCalo);
        JOptionPane.showMessageDialog(null, result, "Chocolate Bar Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
