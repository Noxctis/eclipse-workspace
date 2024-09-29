import javax.swing.JOptionPane;

public class JuiceMachine {
    private CashRegister cashRegister;
    private DispenserType[] dispensers;

    /**
     * Initializes the Juice Machine with default products and costs.
     */
    public JuiceMachine() {
        cashRegister = new CashRegister();
        dispensers = new DispenserType[]{
            new DispenserType(10, 100), // Apple Juice
            new DispenserType(10, 120), // Orange Juice
            new DispenserType(10, 150), // Mango Lassi
            new DispenserType(10, 180)  // Fruit Punch
        };
    }

    /**
     * Displays the instructions and selection for the user to choose a product or exit.
     * @return A formatted string showing the selection with item count and cost
     */
    public String showSelection() {
        StringBuilder message = new StringBuilder("Select your drink:\n");
        message.append("1. Apple Juice - ").append(dispensers[0].getCost()).append(" cents (").append(dispensers[0].getNoOfItems()).append(" items left)\n");
        message.append("2. Orange Juice - ").append(dispensers[1].getCost()).append(" cents (").append(dispensers[1].getNoOfItems()).append(" items left)\n");
        message.append("3. Mango Lassi - ").append(dispensers[2].getCost()).append(" cents (").append(dispensers[2].getNoOfItems()).append(" items left)\n");
        message.append("4. Fruit Punch - ").append(dispensers[3].getCost()).append(" cents (").append(dispensers[3].getNoOfItems()).append(" items left)\n");
        message.append("5. Exit\n");
        message.append("Enter the number of the drink you want to purchase or press 5 to exit.");

        return message.toString();
    }

    /**
     * Handles the sale of the selected product. Verifies the dispenser has items available, prompts for payment, and processes the transaction.
     * @param productIndex The index of the selected product
     */
    public void sellProduct(int productIndex) {
        if (productIndex < 0 || productIndex >= dispensers.length) {
            JOptionPane.showMessageDialog(null, "Invalid selection.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DispenserType dispenser = dispensers[productIndex];
        if (dispenser.getNoOfItems() == 0) {
            JOptionPane.showMessageDialog(null, "Sorry, that item is sold out!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int totalDeposited = 0;
        int cost = dispenser.getCost();
        boolean successfulTransaction = false;

        // Continue asking for more deposit until totalDeposited covers the cost
        while (totalDeposited < cost) {
            int payment = getValidPayment("Please deposit the required amount", totalDeposited, cost, "Payment", JOptionPane.QUESTION_MESSAGE);
            totalDeposited += payment;

            if (totalDeposited >= cost) {
                successfulTransaction = true;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "You still need to deposit " + (cost - totalDeposited) + " more cents.", "Insufficient Payment", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (successfulTransaction) {
            int change = totalDeposited - cost;
            cashRegister.acceptAmount(cost);
            dispenser.makeSale();
            if (change > 0) {
                JOptionPane.showMessageDialog(null, "Enjoy your drink! Your change is " + change + " cents.", "Transaction Complete", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Enjoy your drink! Thank you for your purchase.", "Transaction Complete", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Handles the input for selecting a product or exiting. Prompts the user and ensures valid input is entered.
     * @return A valid selection (1-5) entered by the user
     */
    public int readInputGUI() {
        boolean validInput = false;
        int selection = -1;

        while (!validInput) {
            try {
                String inputStr = JOptionPane.showInputDialog(null, showSelection(), "Juice Machine", JOptionPane.QUESTION_MESSAGE);
                if (inputStr == null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Thank you for using the Juice Machine. Goodbye!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    } else {
                        continue; // Go back to the selection if they choose not to exit
                    }
                }
                selection = Integer.parseInt(inputStr);
                if (selection >= 1 && selection <= 5) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid selection! Please select a number between 1 and 5.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return selection;
    }

    /**
     * Prompts the user for a valid payment amount and ensures it adds to the total.
     * @param message The message to display
     * @param amountDeposited The amount the user has already deposited
     * @param totalCost The total cost of the selected product
     * @param title The title of the dialog box
     * @param messageType The type of message (JOptionPane constants)
     * @return The amount of money entered by the user
     */
    private int getValidPayment(String message, int amountDeposited, int totalCost, String title, int messageType) {
        int payment = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                String inputStr = JOptionPane.showInputDialog(null, message + " (Cost: " + totalCost + " cents, Already deposited: " + amountDeposited + " cents)", title, messageType);
                if (inputStr == null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirm == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Exiting program.", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    } else {
                        continue; // Go back to asking for payment
                    }
                }
                payment = Integer.parseInt(inputStr);
                if (payment > 0) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return payment;
    }

    /**
     * Main method that runs the Juice Machine program. Loops through the selection and allows the user to purchase multiple items.
     */
    public void run() {
        boolean keepRunning = true;
        while (keepRunning) {
            int selection = readInputGUI(); // Show selection and get user input

            if (selection == 5) { // Exit condition
                keepRunning = false;
                JOptionPane.showMessageDialog(null, "Thank you for using the Juice Machine. Goodbye!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
            } else {
                sellProduct(selection - 1); // Process product sale based on the selection
            }
        }
    }

    /**
     * Main entry point for the program.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        JuiceMachine machine = new JuiceMachine();
        machine.run();
    }
}
