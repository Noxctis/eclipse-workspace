import javax.swing.*;

/**
 * Demonstrates the usage of MilkTea and PremiumMilktea classes using a GUI.
 * Allows users to order MilkTea or PremiumMilktea and view details.
 */
public class DemoMilkteaGUI {
    public static void main(String[] args) {
        while (true) {
            // Ask user to choose between MilkTea or PremiumMilktea
            String[] options = {"MilkTea", "Premium MilkTea", "Exit"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose the type of MilkTea to order:",
                    "Cafe Belle",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you for visiting Cafe Belle!");
                break;
            }

            // Input flavor and size
            String flavor = JOptionPane.showInputDialog("Enter the flavor of the MilkTea:");
            String[] sizes = {"12oz", "16oz", "22oz"};
            String size = (String) JOptionPane.showInputDialog(
                    null,
                    "Select the size:",
                    "Size",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    sizes,
                    sizes[0]
            );

            if (choice == 0) { // MilkTea
                MilkTea milkTea = new MilkTea(flavor, size);
                JOptionPane.showMessageDialog(
                        null,
                        "Order Details:\nFlavor: " + milkTea.getFlavor() +
                                "\nSize: " + milkTea.getSize() +
                                "\nPrice: $" + milkTea.getPrice(),
                        "MilkTea Order",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else if (choice == 1) { // Premium MilkTea
                String toppings = JOptionPane.showInputDialog("Enter toppings for the Premium MilkTea:");
                PremiumMilktea premiumMilkTea = new PremiumMilktea(flavor, size, toppings);
                JOptionPane.showMessageDialog(
                        null,
                        "Order Details:\nFlavor: " + premiumMilkTea.getFlavor() +
                                "\nSize: " + premiumMilkTea.getSize() +
                                "\nToppings: " + premiumMilkTea.getToppings() +
                                "\nPrice: $" + premiumMilkTea.getPrice(),
                        "Premium MilkTea Order",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
}
