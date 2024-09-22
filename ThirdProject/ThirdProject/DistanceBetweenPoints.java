/*
============================================================================
FILE : DistanceBetweenPoints.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : Prompts the user to enter two points (x1, y1) and (x2, y2) and displays their distance.
COPYRIGHT : 02-09-2024
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

package ThirdProject;

import java.util.Scanner;

public class DistanceBetweenPoints {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first point (x1, y1)
        System.out.print("Enter x1 and y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        // Prompt the user to enter the second point (x2, y2)
        System.out.print("Enter x2 and y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        // Calculate the distance between the two points
        double distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);

        // Display the result
        System.out.println("The distance between the two points is " + distance);
        input.close();
    }
}