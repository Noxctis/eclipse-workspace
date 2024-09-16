/*
============================================================================
FILE : ChangeDenomination.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : Determines the change to be dispenses from a vending machine. The user enters an amount between 1 cent and 99 cents. The program determines a combination of coins equal to that amount. Denominations is in a formed of: quarter, dime, nickel and penny.
COPYRIGHT : 28-08-2024
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

package ThirdProject;
import java.util.Scanner;

public class ChangeDenomination {
	
	public static void main(String[] args) {
		//declare constant
		final int QUARTER = 25;
		final int DIME = 10;
		final int NICKEL = 5;
		final int PENNY = 1;
		
		//declaration of variables
		int originalAmount;
		int Quarter = 0, Dime = 0,Nickel = 0,Penny = 0;
		
	
		Scanner keyInput = new Scanner(System.in);
		
		System.out.println("Enter amount (from 1-99 cents) :");
		String s1 = keyInput.nextLine();
		originalAmount = Integer.parseInt(s1);
		if (originalAmount >= 1 && originalAmount <= 99) { //input validation from 1-99 cents
			  System.out.println("It is from 1-99 cents");
				  Quarter = originalAmount / QUARTER; // gets the number of quarters in the number
				  originalAmount = originalAmount - (QUARTER*Quarter); // multiplies the number of quarters with values of quarters and subtracts from the original number
				  Dime = originalAmount / DIME; // gets the number of dimes in the number
				  originalAmount = originalAmount - (DIME*Dime); // multiplies the number of dimes with values of dimes and subtracts from the original number
				  Nickel = originalAmount / NICKEL; // gets the number of nickels in the number
				  originalAmount = originalAmount - (NICKEL*Nickel); // multiplies the number of nickels with values of nickels and subtracts from the original number
				  Penny = originalAmount / PENNY; //gets the number of pennies in the number
				  originalAmount = originalAmount - (PENNY*Penny); // multiplies the number of pennies with values of pennies and subtracts from the original number
			 System.out.println("The number of QUARTERS is: " + Quarter); // displays number of quarters
			 System.out.println("The number of DIME is: " + Dime); // display the number of quarters
			 System.out.println("The number of NICKEL is: " + Nickel); // display the number of quarters
			 System.out.println("The number of PENNY is: " + Penny); // display the number of pennies
			}
		else {
			System.out.println("Wrong Input!"); // error message
		}
		keyInput.close();
	}
}
