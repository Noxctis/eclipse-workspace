/*
============================================================================
FILE : sevillaCh_LE2_3HextoDecGUI.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that will convert inputted decimal number into hexadecimal number.
COPYRIGHT : 22-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

public class sevillaCh_LE2_3HextoDecGUI {

    public static void main(String[] args) {
        // Create an object of the class
    	HextoDec hexConverter = new HextoDec();

        // Read decimal input
        hexConverter.readInputGUI();

        // Display the result
        hexConverter.displayResultGUI();
    }
}
