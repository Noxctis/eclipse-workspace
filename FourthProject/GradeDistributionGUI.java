/*
============================================================================
FILE :	GradeDistributionGUI.java
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

        // Get input from the user using JOptionPane
        try {
            String inputA = JOptionPane.showInputDialog("Enter the number of A grades:");
            distribution.setGradeA(Integer.parseInt(inputA));

            String inputB = JOptionPane.showInputDialog("Enter the number of B grades:");
            distribution.setGradeB(Integer.parseInt(inputB));

            String inputC = JOptionPane.showInputDialog("Enter the number of C grades:");
            distribution.setGradeC(Integer.parseInt(inputC));

            String inputD = JOptionPane.showInputDialog("Enter the number of D grades:");
            distribution.setGradeD(Integer.parseInt(inputD));

            String inputF = JOptionPane.showInputDialog("Enter the number of F grades:");
            distribution.setGradeF(Integer.parseInt(inputF));

            // Create the bar graph and display it using JOptionPane
            String result = distribution.createBarGraph2();
            JOptionPane.showMessageDialog(null, result);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid integers.");
        }
    }
}