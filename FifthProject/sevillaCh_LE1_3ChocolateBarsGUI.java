/*
============================================================================
FILE : sevillaCh_LE1_3ChocolateBarsGUI.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : The program should then output the number of chocolate bars that should be consumed to maintain one’s weight for both a woman and a man of the input weight, height, and age.
COPYRIGHT : 22-08-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/
public class sevillaCh_LE1_3ChocolateBarsGUI {

    public static void main(String[] args) {
        // Create an object of ChocolateBars
        ChocolateBars chocolateBars = new ChocolateBars();

        // Call the methods in the correct order
        chocolateBars.readInputGUI();
        chocolateBars.calculateBMR();
        chocolateBars.calculateChocolateBars();
        chocolateBars.writeOutputGUI();
    }
}
