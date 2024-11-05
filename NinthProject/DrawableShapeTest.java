public class DrawableShapeTest {
    public static void main(String[] args) {
        // Create a Square object
        Square square = new Square(5, 5, "blue", 5);

        // Display the initial properties
        System.out.println("Square properties:");
        System.out.println("Center: (" + square.getCenterX() + ", " + square.getCenterY() + ")");
        System.out.println("Color: " + square.getColor());
        System.out.println("Side Length: " + square.getSideLength());

        // Calculate and display the area and perimeter
        System.out.println("Area: " + square.calculateArea());
        System.out.println("Perimeter: " + square.calculatePerimeter());

        // Draw the square
        square.draw();

        // Move the square and update its side length
        square.move(2, 3);
        square.setSideLength(7);
        square.setColor("red");

        // Display updated properties and redraw
        System.out.println("\nUpdated square properties:");
        System.out.println("New Center: (" + square.getCenterX() + ", " + square.getCenterY() + ")");
        System.out.println("New Color: " + square.getColor());
        System.out.println("New Side Length: " + square.getSideLength());
        System.out.println("New Area: " + square.calculateArea());
        System.out.println("New Perimeter: " + square.calculatePerimeter());

        square.draw();
    }
}
