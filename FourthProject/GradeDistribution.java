/*
============================================================================
FILE :	GradeDistribution.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that represents a grade distribution for a given course. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

import java.util.Scanner;
	/**
	Class for data on Person.
	*/
public class GradeDistribution {
    // Fields to store the number of each letter grade
    private int gradeA;
    private int gradeB;
    private int gradeC;
    private int gradeD;
    private int gradeF;

    // Constructor - no-arg to initialize everything to zero
    public GradeDistribution() {
        gradeA = 0;
        gradeB = 0;
        gradeC = 0;
        gradeD = 0;
        gradeF = 0;
    }

    // Setter to set all grades at once
    public void setGrades(int gradeA, int gradeB, int gradeC, int gradeD, int gradeF) {
        this.gradeA = gradeA;
        this.gradeB = gradeB;
        this.gradeC = gradeC;
        this.gradeD = gradeD;
        this.gradeF = gradeF;
    }
    
    public void readInput() {
        Scanner keyboard = new Scanner(System.in);

        // Input for A grades
        System.out.println("Enter the number of A grades:");
        gradeA = keyboard.nextInt();
        while (gradeA < 0) {
            System.out.println("The number of A grades cannot be negative. Please re-enter:");
            gradeA = keyboard.nextInt();
        }

        // Input for B grades
        System.out.println("Enter the number of B grades:");
        gradeB = keyboard.nextInt();
        while (gradeB < 0) {
            System.out.println("The number of B grades cannot be negative. Please re-enter:");
            gradeB = keyboard.nextInt();
        }

        // Input for C grades
        System.out.println("Enter the number of C grades:");
        gradeC = keyboard.nextInt();
        while (gradeC < 0) {
            System.out.println("The number of C grades cannot be negative. Please re-enter:");
            gradeC = keyboard.nextInt();
        }

        // Input for D grades
        System.out.println("Enter the number of D grades:");
        gradeD = keyboard.nextInt();
        while (gradeD < 0) {
            System.out.println("The number of D grades cannot be negative. Please re-enter:");
            gradeD = keyboard.nextInt();
        }

        // Input for F grades
        System.out.println("Enter the number of F grades:");
        gradeF = keyboard.nextInt();
        while (gradeF < 0) {
            System.out.println("The number of F grades cannot be negative. Please re-enter:");
            gradeF = keyboard.nextInt();
        }
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
    
 // Write output to display the grades and their percentages
    public void writeOutput() {
        System.out.println("Grade Distribution:");

        System.out.println("Number of A grades: " + gradeA);
        System.out.println("Number of B grades: " + gradeB);
        System.out.println("Number of C grades: " + gradeC);
        System.out.println("Number of D grades: " + gradeD);
        System.out.println("Number of F grades: " + gradeF);

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
        	System.out.println(
                    "ERROR: Total Grades is 0. Division by 0.");
         System.exit(0);
        }
        else {
        percentage = (numGrades * 100) / total;
        }
        return percentage;
    }

    // Method to print the bar graph
    public void createBarGraph() {
        System.out.println("Grade Distribution Bar Graph:");

        printBar('A', gradeA);
        printBar('B', gradeB);
        printBar('C', gradeC);
        printBar('D', gradeD);
        printBar('F', gradeF);
    }

    // Helper method to print each bar of the graph
    private void printBar(char grade, int gradeCount) {
        double percentage = getPercentage(gradeCount);
        int numAsterisks = (int) Math.round((percentage * 50) / 100); // 1 asterisk represents 2%

        System.out.print(grade + ": ");
        for (int i = 0; i < numAsterisks; i++) {
            System.out.print("*");
        }
        System.out.println(" (" + Math.round(percentage) + "%)");
    }
}
