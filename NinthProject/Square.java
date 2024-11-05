import java.util.Scanner;

/**
 * The Square class represents a square shape with a specified side length, center, and color.
 * It extends the DrawableShape class and provides methods to calculate the area and perimeter,
 * as well as methods to access and modify the side length.
 */
public class Square extends DrawableShape {
    private int sideLength;  // Length of the sides of the square

    /**
     * No-argument constructor to create a Square with default values.
     */
    public Square() {
        super(0, 0, "black");
        this.sideLength = 1; // Default side length
    }

    /**
     * Constructor to initialize the Square with center coordinates, color, and side length.
     * @param centerX The X-coordinate of the square's center.
     * @param centerY The Y-coordinate of the square's center.
     * @param color The color of the square.
     * @param sideLength The length of the sides of the square.
     */
    public Square(int centerX, int centerY, String color, int sideLength) {
        super(centerX, centerY, color);
        this.sideLength = sideLength;
    }

    /**
     * Gets the length of the sides of the square.
     * @return The length of the sides of the square.
     */
    public int getSideLength() {
        return sideLength;
    }

    /**
     * Sets the length of the sides of the square.
     * @param sideLength The new length of the sides of the square.
     */
    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * Calculates and returns the area of the square.
     * @return The area of the square.
     */
    public int calculateArea() {
        return sideLength * sideLength;
    }

    /**
     * Calculates and returns the perimeter of the square.
     * @return The perimeter of the square.
     */
    public int calculatePerimeter() {
        return 4 * sideLength;
    }

    /**
     * Draws the square using keyboard characters, displaying an outline based on the side length.
     * The drawing simulates the square by printing rows of characters.
     */
    public void draw() {
        System.out.println("Drawing square with color " + color + " at center (" + centerX + ", " + centerY + ")");
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                if (i == 0 || i == sideLength - 1 || j == 0 || j == sideLength - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Reads input values for the square's properties: center coordinates, color, and side length.
     */
    public void readInput() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the X-coordinate of the square's center: ");
        setCenterX(scanner.nextInt());
        
        System.out.print("Enter the Y-coordinate of the square's center: ");
        setCenterY(scanner.nextInt());
        
        System.out.print("Enter the color of the square: ");
        setColor(scanner.next());
        
        System.out.print("Enter the length of the square's side: ");
        setSideLength(scanner.nextInt());
    }

    /**
     * Outputs the square's properties, including center coordinates, color, side length, area, and perimeter.
     */
    public void writeOutput() {
        System.out.println("Square Properties:");
        System.out.println("Center: (" + getCenterX() + ", " + getCenterY() + ")");
        System.out.println("Color: " + getColor());
        System.out.println("Side Length: " + getSideLength());
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}
