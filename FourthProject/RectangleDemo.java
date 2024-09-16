/*
============================================================================
FILE :	RectangleDemo.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that gets the area and perimeter of a rectangle. 
COPYRIGHT : 16-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/
public class RectangleDemo
{
    public static void main(String[] args)
    {
        Rectangle rectangle1 = new Rectangle( ), rectangle2 = new Rectangle( );
        
        System.out.println("Enter data of the first rectangle:");
        rectangle1.readInput( );
        
       
        System.out.println("Enter data of the second rectangle: ");
        rectangle2.readInput( );
        
        // Displaying details for rectangle1
        System.out.println("Rectangle 1:");
        System.out.println("Width: " + rectangle1.getWidth());
        System.out.println("Height: " + rectangle1.getHeight());
        System.out.println("Area: " + rectangle1.getArea());
        System.out.println("Perimeter: " + rectangle1.getPerimeter());

        // Displaying details for rectangle2
        System.out.println("\nRectangle 2:");
        System.out.println("Width: " + rectangle2.getWidth());
        System.out.println("Height: " + rectangle2.getHeight());
        System.out.println("Area: " + rectangle2.getArea());
        System.out.println("Perimeter: " + rectangle2.getPerimeter());

        
        
    }
}
