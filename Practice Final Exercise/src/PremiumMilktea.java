/**
 * Represents a premium milk tea with additional toppings.
 * Extends the MilkTea class and overrides setSize() to adjust pricing.
 */
public class PremiumMilktea extends MilkTea {
    private String toppings;

    /**
     * Default constructor initializes default values.
     */
    public PremiumMilktea() {
        super();
        this.toppings = "None";
    }

    /**
     * Constructor initializes flavor, size, toppings, and calculates price.
     * @param flavor The flavor of the PremiumMilktea.
     * @param size The size of the PremiumMilktea (12oz, 16oz, 22oz).
     * @param toppings The toppings for the PremiumMilktea.
     */
    public PremiumMilktea(String flavor, String size, String toppings) {
        super(flavor, size);
        this.toppings = toppings;
        setSize(size); // Recalculate price with $2 per oz
    }

    /**
     * Gets the toppings of the PremiumMilktea.
     * @return The toppings of the PremiumMilktea.
     */
    public String getToppings() {
        return toppings;
    }

    /**
     * Sets the toppings of the PremiumMilktea.
     * @param toppings The new toppings to set.
     */
    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    /**
     * Overrides the setSize() method to set price as $2 per oz.
     * @param size The size of the PremiumMilktea (12oz, 16oz, 22oz).
     */
    @Override
    public void setSize(String size) {
        super.setSize(size);
        switch (size.toLowerCase()) {
            case "12oz" -> super.price = 12 * 2.0;
            case "16oz" -> super.price = 16 * 2.0;
            case "22oz" -> super.price = 22 * 2.0;
            default -> super.price = 0.0; // Invalid size
        }
    }
}
