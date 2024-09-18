/*
============================================================================
FILE :	GradeDistributionDemo.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that represents a grade distribution for a given course. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

public class GradeDistributionDemo {

    public static void main(String[] args) {
        // Create an instance of GradeDistribution
        GradeDistribution distribution = new GradeDistribution();

        // Read input from the user
        distribution.readInput();

        // Display the grades and the bar graph
        distribution.writeOutput();
        
        // Draw the bar graph
        distribution.createBarGraph();
    }
}