/*
============================================================================
FILE : DistanceBetweenPoints.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : Prompts the user to enter two points (x1, y1) and (x2, y2) and displays their distance.
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

public class DistanceBetweenPoints {

    // Instance variables to store the points
    private double x1, y1, x2, y2;

    /**
     * Reads the input coordinates for two points (x1, y1) and (x2, y2) from the user.
     * 
     * Preconditions: The user must provide valid numeric input for the coordinates.
     * Postconditions: The coordinates are stored in the instance variables.
     */
    public void readInput() {
        Scanner keyInput = new Scanner(System.in);
        boolean validInput = false;

        // Loop until valid input is entered for x1 and y1
        while (!validInput) {
            System.out.print("Enter x1 and y1: ");
            try {
                x1 = keyInput.nextDouble();
                y1 = keyInput.nextDouble();
                validInput = true; // Input is valid, break out of the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter valid numbers for x1 and y1.");
                keyInput.next(); // Clear the invalid input
            }
        }

        validInput = false; // Reset for x2, y2 input

        // Loop until valid input is entered for x2 and y2
        while (!validInput) {
            System.out.print("Enter x2 and y2: ");
            try {
                x2 = keyInput.nextDouble();
                y2 = keyInput.nextDouble();
                validInput = true; // Input is valid, break out of the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter valid numbers for x2 and y2.");
                keyInput.next(); // Clear the invalid input
            }
        }
        keyInput.close(); // Close the scanner
    }
    
    /**
     * Reads the input coordinates for two points (x1, y1) and (x2, y2) from the user via `JOptionPane`.
     * 
     * Precondition: 
     * - The user must provide valid numeric input for the coordinates (x1, y1, x2, y2).
     * 
     * Postcondition: 
     * - The coordinates for the points are stored in the instance variables `x1`, `y1`, `x2`, and `y2`.
     */
    public void readInputGUI() {
        boolean validInput = false;

        // Read x1 and y1
        while (!validInput) {
            try {
                String inputX1 = JOptionPane.showInputDialog(null, "Enter x1:", "Input", JOptionPane.QUESTION_MESSAGE);
                if (inputX1 == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                String inputY1 = JOptionPane.showInputDialog(null, "Enter y1:", "Input", JOptionPane.QUESTION_MESSAGE);
                if (inputY1 == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                x1 = Double.parseDouble(inputX1);
                y1 = Double.parseDouble(inputY1);
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers for x1 and y1.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        validInput = false;

        // Read x2 and y2
        while (!validInput) {
            try {
                String inputX2 = JOptionPane.showInputDialog(null, "Enter x2:", "Input", JOptionPane.QUESTION_MESSAGE);
                if (inputX2 == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                String inputY2 = JOptionPane.showInputDialog(null, "Enter y2:", "Input", JOptionPane.QUESTION_MESSAGE);
                if (inputY2 == null) {
                    JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                x2 = Double.parseDouble(inputX2);
                y2 = Double.parseDouble(inputY2);
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers for x2 and y2.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Calculates the distance between the two points (x1, y1) and (x2, y2).
     * 
     * Preconditions: The instance variables `x1`, `y1`, `x2`, and `y2` must be initialized with valid values.
     * Postconditions: The distance between the two points is calculated and returned as a `double` value.
     * 
     * @return the distance between the two points as a `double`.
     */
    private double calculateDistance() {
        double distance;
        distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
        return distance;
    }

    /**
     * Outputs the calculated distance between the two points.
     * 
     * Preconditions: The `calculateDistance()` method must be called beforehand to ensure the distance is computed.
     * Postconditions: The distance between the two points is displayed on the console.
     */
    public void writeOutput() {
        System.out.println("The distance between the two points is " + calculateDistance());
    }

    /**
     * Outputs the calculated distance between the two points using `JOptionPane`.
     * 
     * Precondition: 
     * - The method `calculateDistance()` must be called beforehand to compute the distance.
     * 
     * Postcondition: 
     * - The calculated distance is displayed in a `JOptionPane` dialog.
     */
    public void writeOutputGUI() {
        double distance = calculateDistance();
        JOptionPane.showMessageDialog(null, "The distance between the two points is " + distance, "Distance Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
