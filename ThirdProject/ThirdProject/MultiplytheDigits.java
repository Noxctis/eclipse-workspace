/*
============================================================================
FILE : MultiplytheDigits.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : Reads an integer between 0 and 1000. Display and multiplies all the digits in the integer
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

public class MultiplytheDigits {
	
	public static void main(String[] args) {
		
		//declaration of variables
		String s1;
		int n1 = 0, n2 = 0,n3 = 0,originalAmount,answer;
		
	
		Scanner keyInput = new Scanner(System.in);
		
		System.out.println("Enter amount (from 0-1000 cents) :");
		s1 = keyInput.nextLine(); // input
		originalAmount = Integer.parseInt(s1); // converts string into int
		if (originalAmount >= 0 && originalAmount <= 1000) { //input validation from 1-99 cents
			  System.out.println("It is from 0-1000 cents");
				  
			  n1 = (originalAmount/100)%10; // gets the first digit
			  n2 = (originalAmount/10)%10; // gets the second digit
			  n3 = (originalAmount%10); // gets the third digit
			  System.out.println(n1); //prints the first digit
			  System.out.println(n2); //prints the second digit
			  System.out.println(n3); // prints the third digit
			  answer = n1*n2*n3; // multiplies each individual digit together
			  System.out.println(answer); //prints the product of all digits
			}
		else {
			System.out.println("Wrong Input!"); // error message
		}
		keyInput.close();
	}
}
