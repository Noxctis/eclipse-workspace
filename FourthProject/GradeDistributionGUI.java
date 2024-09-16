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
    // Fields to store the number of each letter grade
    private int gradeA;
    private int gradeB;
    private int gradeC;
    private int gradeD;
    private int gradeF;

    // Constructor - no-arg to initialize everything to zero
    public GradeDistributionGUI() {
        gradeA = 0;
        gradeB = 0;
        gradeC = 0;
        gradeD = 0;
        gradeF = 0;
    }

    // Setters for each grade
    public void setGradeA(int newGradeA) {
        this.gradeA = newGradeA;
    }

    public void setGradeB(int newGradeB) {
        this.gradeB = newGradeB;
    }

    public void setGradeC(int newGradeC) {
        this.gradeC = newGradeC;
    }

    public void setGradeD(int newGradeD) {
        this.gradeD = newGradeD;
    }

    public void setGradeF(int newGradeF) {
        this.gradeF = newGradeF;
    }

    // Getters for each grade
    public int getGradeA() {
        return gradeA;
    }

    public int getGradeB() {
        return gradeB;
    }

    public int getGradeC() {
        return gradeC;
    }

    public int getGradeD() {
        return gradeD;
    }

    public int getGradeF() {
        return gradeF;
    }

    // Method to return the total number of grades
    public int getTotalGrades() {
        return gradeA + gradeB + gradeC + gradeD + gradeF;
    }

    // Method to calculate the percentage of a particular grade
    public double getPercentage(int numGrades) {
        double total = getTotalGrades();
        double percentage = 0;
        if (total == 0) {
            JOptionPane.showMessageDialog(null, "ERROR: Total Grades is 0. Division by 0.");
            System.exit(0);
        } else {
            percentage = (numGrades * 100) / total;
        }
        return percentage;
    }

    // Method to create the bar graph as a string
    public String createBarGraph() {
        StringBuilder barGraph = new StringBuilder();
        barGraph.append("Grade Distribution Bar Graph:\n\n");

        barGraph.append(printBar('A', gradeA));
        barGraph.append(printBar('B', gradeB));
        barGraph.append(printBar('C', gradeC));
        barGraph.append(printBar('D', gradeD));
        barGraph.append(printBar('F', gradeF));

        return barGraph.toString();
    }

    // Helper method to print each bar of the graph
    private String printBar(char grade, int gradeCount) {
        double percentage = getPercentage(gradeCount);
        int numAsterisks = (int) Math.round((percentage * 50) / 100); // 1 asterisk represents 2%
        
        StringBuilder bar = new StringBuilder();
        bar.append(grade + ": ");
        for (int i = 0; i < numAsterisks; i++) {
            bar.append("*");
        }
        bar.append(" (" + Math.round(percentage) + "%)\n");
        return bar.toString();
    }

    // Main method to test the program using JOptionPane
    public static void main(String[] args) {
        GradeDistributionGUI distribution = new GradeDistributionGUI();

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
            String result = distribution.createBarGraph();
            JOptionPane.showMessageDialog(null, result);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid integers.");
        }
    }
}
