/**
 * The abstract base class DrawableShape represents a drawable shape with a center point and color.
 * It provides methods to access and modify the position and color of the shape, as well as a method to move it.
 */
public abstract class DrawableShape {
    protected int centerX;   // X-coordinate of the center
    protected int centerY;   // Y-coordinate of the center
    protected String color;  // Color of the shape

    /**
     * Constructor to initialize the DrawableShape with its center coordinates and color.
     * @param centerX The X-coordinate of the shape's center.
     * @param centerY The Y-coordinate of the shape's center.
     * @param color The color of the shape.
     */
    public DrawableShape(int centerX, int centerY, String color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.color = color;
    }

    /**
     * Gets the X-coordinate of the center.
     * @return The X-coordinate of the shape's center.
     */
    public int getCenterX() {
        return centerX;
    }

    /**
     * Sets the X-coordinate of the center.
     * @param centerX The new X-coordinate of the shape's center.
     */
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    /**
     * Gets the Y-coordinate of the center.
     * @return The Y-coordinate of the shape's center.
     */
    public int getCenterY() {
        return centerY;
    }

    /**
     * Sets the Y-coordinate of the center.
     * @param centerY The new Y-coordinate of the shape's center.
     */
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    /**
     * Gets the color of the shape.
     * @return The color of the shape.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets a new color for the shape.
     * @param color The new color of the shape.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Moves the shape by the specified delta values for X and Y.
     * @param deltaX The change in X-coordinate.
     * @param deltaY The change in Y-coordinate.
     */
    public void move(int deltaX, int deltaY) {
        this.centerX += deltaX;
        this.centerY += deltaY;
    }

    /**
     * Abstract method to draw the shape, to be implemented by subclasses.
     */
    public abstract void draw();
}
