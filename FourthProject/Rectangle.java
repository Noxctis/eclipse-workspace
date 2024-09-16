/*
============================================================================
FILE :	Rectangle.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that gets the area and perimeter of a rectangle. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

import java.util.Scanner;
	/**
	Class for data on Rectangle.
	 */
public class Rectangle {
    // Fields to store the width and height of the rectangle
    private double rectWidth;
    private double rectHeight;

    /**
     * No-arg constructor that sets default values for width and height.
     * Precondition: None.
     * Postcondition: The rectangle's width and height are set to default values (1.0).
     */
    public Rectangle() {
        this.rectWidth = 1.0;
        this.rectHeight = 1.0;
    }

    /**
     * Constructor that accepts specific width and height.
     * Precondition: The newWidth and newHeight should be non-negative values.
     * Postcondition: The rectangle's width and height are set to the specified values.
     * @param newWidth The width of the rectangle.
     * @param newHeight The height of the rectangle.
     */
    public Rectangle(double newWidth, double newHeight) {
        this.rectWidth = newWidth;
        this.rectHeight = newHeight;
    }

    /**
     * Reads the width and height from user input and validates that they are non-negative.
     * Precondition: The user must provide valid numeric input.
     * Postcondition: The rectangle's width and height are updated with valid, non-negative values.
     */
    public void readInput() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the rectangle's width?");
        rectWidth = keyboard.nextInt();
        while (rectWidth < 0) {
            System.out.println("Width cannot be negative.");
            System.out.println("Reenter Width:");
            rectWidth = keyboard.nextInt();
        }

        System.out.println("What is the rectangle's height?");
        rectHeight = keyboard.nextInt();
        while (rectHeight < 0) {
            System.out.println("Height cannot be negative.");
            System.out.println("Reenter Height:");
            rectHeight = keyboard.nextInt();
        }
    }

    /**
     * Displays the width and height of the rectangle.
     * Precondition: The rectangle's width and height are initialized.
     * Postcondition: The width and height are printed to the console.
     */
    public void writeOutput() {
        System.out.println("Width = " + rectWidth);
        System.out.println("Height = " + rectHeight);
    }

    /**
     * Calculates the area of the rectangle.
     * Precondition: The rectangle's width and height must be initialized and non-negative.
     * Postcondition: Returns the calculated area of the rectangle.
     * @return The area of the rectangle (width * height).
     */
    public double getArea() {
        return rectWidth * rectHeight;
    }

    /**
     * Calculates the perimeter of the rectangle.
     * Precondition: The rectangle's width and height must be initialized and non-negative.
     * Postcondition: Returns the calculated perimeter of the rectangle.
     * @return The perimeter of the rectangle (2 * (width + height)).
     */
    public double getPerimeter() {
        return 2 * (rectWidth + rectHeight);
    }

    /**
     * Returns the width of the rectangle.
     * Precondition: The rectangle's width must be initialized.
     * Postcondition: Returns the current width of the rectangle.
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return rectWidth;
    }

    /**
     * Returns the height of the rectangle.
     * Precondition: The rectangle's height must be initialized.
     * Postcondition: Returns the current height of the rectangle.
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return rectHeight;
    }

    /**
     * Sets the width of the rectangle.
     * Precondition: The newWidth must be a non-negative value.
     * Postcondition: The rectangle's width is updated to the specified value.
     * @param newWidth The new width to set.
     */
    public void setWidth(double newWidth) {
        this.rectWidth = newWidth;
    }

    /**
     * Sets the height of the rectangle.
     * Precondition: The newHeight must be a non-negative value.
     * Postcondition: The rectangle's height is updated to the specified value.
     * @param newHeight The new height to set.
     */
    public void setHeight(double newHeight) {
        this.rectHeight = newHeight;
    }
}
