/*
============================================================================
FILE :	GradeDistributionTest.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that represents a grade distribution for a given course. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

public class GradeDistributionTest {
    public static void main(String[] args) {
        GradeDistribution grades = new GradeDistribution();

        grades.setGrades(1, 4, 6, 2, 1);
        grades.writeOutput();
        
        // Output total number of grades
        System.out.println("Total Grades: " + grades.getTotalGrades());

        // Draw the bar graph
        grades.createBarGraph();
    }
}