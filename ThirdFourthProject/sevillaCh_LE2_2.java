/*
============================================================================
FILE :LE2_2.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that simulates flipping a coin two millions times and displays the number of heads and tails.
COPYRIGHT : 04-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

public class sevillaCh_LE2_2 {
	public static void main(String[] args) {
		//Declaration of variables
		int heads,tails,i; 				
		heads = 0;
		tails = 0;

		// Simulate flipping a coin two million times
		System.out.println("Fipping a coin two millon times..");
		for (i = 0; i < 2000000; i++) {
			//Generate randomly a 0 or 1. If 0 increment heads else increment tails
			if((int)(Math.random() * 2) == 0) {
				heads++; //increments heads
			}
			else {
				tails++; // increments tails
			}
		}
		
		// Display results
		System.out.println("Heads: " + heads + "\nTails: " + tails);
	}
}