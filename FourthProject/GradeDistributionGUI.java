/*
============================================================================
FILE :  GradeDistributionGUI.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that represents a grade distribution for a given course. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

import javax.swing.JOptionPane;

public class GradeDistributionGUI {
    // Main method to test the program using JOptionPane
    public static void main(String[] args) {
        GradeDistribution distribution = new GradeDistribution();

        // Continuously ask for input until valid values are entered
        int gradeA = getValidGrade("Enter the number of A grades:");
        distribution.setGradeA(gradeA);

        int gradeB = getValidGrade("Enter the number of B grades:");
        distribution.setGradeB(gradeB);

        int gradeC = getValidGrade("Enter the number of C grades:");
        distribution.setGradeC(gradeC);

        int gradeD = getValidGrade("Enter the number of D grades:");
        distribution.setGradeD(gradeD);

        int gradeF = getValidGrade("Enter the number of F grades:");
        distribution.setGradeF(gradeF);

        // Create the bar graph and display it using JOptionPane
        String result = distribution.createBarGraph2();
        JOptionPane.showMessageDialog(null, result);
    }

    /**
     * Continuously prompts the user for a valid non-negative integer input
     * @param message The message to display in the input dialog
     * @return A valid non-negative integer entered by the user
     */
    private static int getValidGrade(String message) {
        int grade = -1;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                String input = JOptionPane.showInputDialog(message);
                grade = Integer.parseInt(input);
                
                if (grade < 0) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a non-negative integer.");
                } else {
                    validInput = true;  // Input is valid, exit loop
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid integer.");
            }
        }

        return grade;
    }
}
