/**
 * Represents a base class for MilkTea.
 * Contains flavor, size, and price information.
 */
public class MilkTea {
    private String flavor;
    private String size;
    protected double price; // Protected for subclass access

    /**
     * Default constructor initializes default values.
     */
    public MilkTea() {
        this.flavor = "Unknown";
        this.size = "Unknown";
        this.price = 0.0;
    }

    /**
     * Constructor initializes flavor and size, calculates price.
     * @param flavor The flavor of the MilkTea.
     * @param size The size of the MilkTea (12oz, 16oz, 22oz).
     */
    public MilkTea(String flavor, String size) {
        this.flavor = flavor;
        setSize(size); // Sets size and calculates price
    }

    /**
     * Gets the flavor of the MilkTea.
     * @return The flavor of the MilkTea.
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Gets the size of the MilkTea.
     * @return The size of the MilkTea.
     */
    public String getSize() {
        return size;
    }

    /**
     * Gets the price of the MilkTea.
     * @return The price of the MilkTea.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the flavor of the MilkTea.
     * @param flavor The new flavor to set.
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * Sets the size of the MilkTea and calculates the price as $1 per oz.
     * @param size The size to set (12oz, 16oz, 22oz).
     */
    public void setSize(String size) {
        this.size = size;
        switch (size.toLowerCase()) {
            case "12oz" -> this.price = 12 * 1.0;
            case "16oz" -> this.price = 16 * 1.0;
            case "22oz" -> this.price = 22 * 1.0;
            default -> this.price = 0.0; // Invalid size
        }
    }
}
