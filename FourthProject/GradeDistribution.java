/*
============================================================================
FILE :  GradeDistribution.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that represents a grade distribution for a given course. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

import java.util.Scanner;

/**
 * Class that represents a grade distribution for a course.
 */
public class GradeDistribution {
    // Fields to store the number of each letter grade
    private int gradeA;
    private int gradeB;
    private int gradeC;
    private int gradeD;
    private int gradeF;

    /**
     * Precondition: None.
     * Postcondition: Initializes all grade counts to 0.
     */
    public GradeDistribution() {
        gradeA = 0;
        gradeB = 0;
        gradeC = 0;
        gradeD = 0;
        gradeF = 0;
    }

    /**
     * Precondition: All grades must be non-negative integers.
     * Postcondition: Sets the number of each grade (A, B, C, D, F).
     * 
     * @param gradeA the number of A grades
     * @param gradeB the number of B grades
     * @param gradeC the number of C grades
     * @param gradeD the number of D grades
     * @param gradeF the number of F grades
     */
    public void setGrades(int gradeA, int gradeB, int gradeC, int gradeD, int gradeF) {
        this.gradeA = gradeA;
        this.gradeB = gradeB;
        this.gradeC = gradeC;
        this.gradeD = gradeD;
        this.gradeF = gradeF;
    }

    /**
     * Precondition: User input must be non-negative integers for each grade.
     * Postcondition: Reads the number of grades for A, B, C, D, and F from user input.
     */
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

    /**
     * Precondition: Grade values must be initialized.
     * Postcondition: Outputs the number of A, B, C, D, and F grades.
     */
    public void writeOutput() {
        System.out.println("Grade Distribution:");
        System.out.println("Number of A grades: " + gradeA);
        System.out.println("Number of B grades: " + gradeB);
        System.out.println("Number of C grades: " + gradeC);
        System.out.println("Number of D grades: " + gradeD);
        System.out.println("Number of F grades: " + gradeF);
    }

    /**
     * Precondition: The new grade count must be a non-negative integer.
     * Postcondition: Sets the number of A grades.
     * 
     * @param newGradeA the number of A grades
     */
    public void setGradeA(int newGradeA) {
        this.gradeA = newGradeA;
    }

    /**
     * Precondition: The new grade count must be a non-negative integer.
     * Postcondition: Sets the number of B grades.
     * 
     * @param newGradeB the number of B grades
     */
    public void setGradeB(int newGradeB) {
        this.gradeB = newGradeB;
    }

    /**
     * Precondition: The new grade count must be a non-negative integer.
     * Postcondition: Sets the number of C grades.
     * 
     * @param newGradeC the number of C grades
     */
    public void setGradeC(int newGradeC) {
        this.gradeC = newGradeC;
    }

    /**
     * Precondition: The new grade count must be a non-negative integer.
     * Postcondition: Sets the number of D grades.
     * 
     * @param newGradeD the number of D grades
     */
    public void setGradeD(int newGradeD) {
        this.gradeD = newGradeD;
    }

    /**
     * Precondition: The new grade count must be a non-negative integer.
     * Postcondition: Sets the number of F grades.
     * 
     * @param newGradeF the number of F grades
     */
    public void setGradeF(int newGradeF) {
        this.gradeF = newGradeF;
    }

    /**
     * Precondition: Grade counts must be initialized.
     * Postcondition: Returns the number of A grades.
     * 
     * @return the number of A grades
     */
    public int getGradeA() {
        return gradeA;
    }

    // Similar getters for B, C, D, F grades
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

    /**
     * Precondition: The grades must be initialized.
     * Postcondition: Returns the total number of grades.
     * 
     * @return the total number of grades
     */
    public int getTotalGrades() {
        return gradeA + gradeB + gradeC + gradeD + gradeF;
    }

    /**
     * Precondition: The total number of grades must be greater than 0.
     * Postcondition: Returns the percentage of a particular grade.
     * 
     * @param numGrades the number of grades to calculate the percentage for
     * @return the percentage of the grade
     */
    public double getPercentage(int numGrades) {
        double total = getTotalGrades();
        if (total == 0) {
            System.out.println("ERROR: Total Grades is 0. Division by 0.");
            System.exit(0);
        }
        return (numGrades * 100) / total;
    }

    /**
     * Precondition: Grade values must be initialized.
     * Postcondition: Prints the bar graph representation of the grade distribution.
     */
    public void createBarGraph() {
        System.out.println("Grade Distribution Bar Graph:");
        printBar('A', gradeA);
        printBar('B', gradeB);
        printBar('C', gradeC);
        printBar('D', gradeD);
        printBar('F', gradeF);
    }

    /**
     * Precondition: The total number of grades must be greater than 0.
     * Postcondition: Prints a bar for a particular grade.
     * 
     * @param grade the grade (A, B, C, D, F)
     * @param gradeCount the number of grades
     */
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
