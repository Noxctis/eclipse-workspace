/*
============================================================================
FILE : sevillaCh_LE1_1ChangeDenomination.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : Determines the change to be dispenses from a vending machine. The user enters an amount between 1 cent and 99 cents. The program determines a combination of coins equal to that amount. Denominations is in a formed of: quarter, dime, nickel and penny.
COPYRIGHT : 22-09-2024
REVISION HISTORY
Date: By: Description:
revision date author description of the change
revision date author description of the change
.
.
.
revision date author description of the change
============================================================================
*/


public class sevillaCh_LE1_1ChangeDenomination {
	
	public static void main(String[] args) {
		// Create an object of ChangeDenomination
        ChangeDenomination changeDenomination = new ChangeDenomination();

        // Call methods in the correct order
        changeDenomination.readInput();
        changeDenomination.calculateChange();
        changeDenomination.writeOutput();
	}
}
