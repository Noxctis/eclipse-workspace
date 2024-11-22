/**
 * Demonstrates the usage of MilkTea and PremiumMilktea classes.
 */
public class DemoMilktea {
    public static void main(String[] args) {
        // Create a standard MilkTea object
        MilkTea standardMilkTea = new MilkTea("Classic", "16oz");
        System.out.println("MilkTea Details:");
        System.out.println("Flavor: " + standardMilkTea.getFlavor());
        System.out.println("Size: " + standardMilkTea.getSize());
        System.out.println("Price: $" + standardMilkTea.getPrice());

        // Create a PremiumMilktea object
        PremiumMilktea premiumMilkTea = new PremiumMilktea("Matcha", "22oz", "Boba Pearls");
        System.out.println("\nPremium MilkTea Details:");
        System.out.println("Flavor: " + premiumMilkTea.getFlavor());
        System.out.println("Size: " + premiumMilkTea.getSize());
        System.out.println("Toppings: " + premiumMilkTea.getToppings());
        System.out.println("Price: $" + premiumMilkTea.getPrice());
    }
}
