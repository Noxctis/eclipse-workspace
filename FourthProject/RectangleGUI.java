/*
============================================================================
FILE :	RectangleGUI.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that gets the area and perimeter of a rectangle. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

import javax.swing.JOptionPane;

public class RectangleGUI {
    public static void main(String[] args) {
        // Input and validation for the first rectangle
        double width1 = getValidatedInput("Enter the width of the first rectangle:");
        double height1 = getValidatedInput("Enter the height of the first rectangle:");

        // Input and validation for the second rectangle
        double width2 = getValidatedInput("Enter the width of the second rectangle:");
        double height2 = getValidatedInput("Enter the height of the second rectangle:");

        // Create two Rectangle objects with the user input
        Rectangle rectangle1 = new Rectangle(width1, height1);
        Rectangle rectangle2 = new Rectangle(width2, height2);

        // Calculate area and perimeter for both rectangles
        double area1 = rectangle1.getArea();
        double perimeter1 = rectangle1.getPerimeter();

        double area2 = rectangle2.getArea();
        double perimeter2 = rectangle2.getPerimeter();

        // Display the results in a JOptionPane for both rectangles
        String output = String.format(
                "First Rectangle Details:\n\nWidth: %.2f\nHeight: %.2f\nArea: %.2f\nPerimeter: %.2f\n\n"
                + "Second Rectangle Details:\n\nWidth: %.2f\nHeight: %.2f\nArea: %.2f\nPerimeter: %.2f",
                rectangle1.getWidth(), rectangle1.getHeight(), area1, perimeter1,
                rectangle2.getWidth(), rectangle2.getHeight(), area2, perimeter2
        );

        JOptionPane.showMessageDialog(null, output);
    }

    // Helper method to get and validate input for width and height
    public static double getValidatedInput(String message) {
        double value = 0;
        while (true) {
            try {
                String inputStr = JOptionPane.showInputDialog(message);
                if (inputStr == null) { // Handle cancellation
                    System.exit(0);
                }
                value = Double.parseDouble(inputStr);
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "Value cannot be negative. Please enter a non-negative number.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }
}
