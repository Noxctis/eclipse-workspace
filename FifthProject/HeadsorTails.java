/*
============================================================================
FILE : HeadsorTails.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that simulates flipping a coin two millions times and displays the number of heads and tails.
COPYRIGHT : 22-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/
import javax.swing.JOptionPane;

public class HeadsorTails {

    private int heads, tails;

    /**
     * Simulates flipping a coin two million times.
     * 
     * Precondition: None.
     * 
     * Postcondition: The instance variables `heads` and `tails` are updated with the number of heads and tails, respectively.
     */
    public void flipCoin() {
        heads = 0;
        tails = 0;

        // Simulate flipping a coin two million times
        System.out.println("Flipping a coin two million times...");

        for (int i = 0; i < 2000000; i++) {
            // Generate randomly a 0 or 1. If 0, increment heads; else, increment tails
            if ((int) (Math.random() * 2) == 0) {
                heads++; // Increment heads
            } else {
                tails++; // Increment tails
            }
        }
    }

    /**
     * Displays the number of heads and tails.
     * 
     * Precondition: The method `flipCoin()` must be called beforehand to perform the coin flips.
     * 
     * Postcondition: The number of heads and tails is printed to the console.
     */
    public void displayResults() {
    	flipCoin();
        System.out.println("Heads: " + heads + "\nTails: " + tails);
    }
    
    /**
     * Displays the number of heads and tails using `JOptionPane`.
     * 
     * Precondition: The method `flipCoin()` must be called beforehand to perform the coin flips.
     * 
     * Postcondition: The number of heads and tails is shown in a `JOptionPane` dialog.
     */
    public void displayResultsGUI() {
    	flipCoin();
        String message = "Heads: " + heads + "\nTails: " + tails;
        JOptionPane.showMessageDialog(null, message, "Coin Flip Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
