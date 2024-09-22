/*
============================================================================
FILE :LE2_3.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : A program that will convert inputted decimal number into hexadecimal number.
COPYRIGHT : 04-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

import java.util.Scanner;

public class sevillaCh_LE2_3 {
	public static void main(String args[]) {
		//Declaration of variables
		String str = ""; 
		int num,rem;
		Scanner input = new Scanner( System.in );
		
		System.out.print("Enter a decimal number : "); //input for decimal number
		while (!input.hasNextInt()) { // input validation if it is not a number
			System.out.println("Input is not a number.");
			input.nextLine();
		}
		
		num = input.nextInt(); // gets the input
		
		while(num>0) //while number greater than 0
		{
        rem=num%16; //gets remainder modulo 16 the number
        switch(rem) {
			case 10: 
				str = "A" + str; // Appends A to the string
				break;
			case 11: 
				str = "B" + str; // Appends B to the string
				break;
			case 12: 
				str = "C" + str; // Appends C to the string
				break;
			case 13: 
				str = "D" + str; // Appends D to the string
				break;
			case 14: 
				str = "E" + str; // Appends E to the string
				break;
			case 15: 
				str = "F" + str; // Appends F to the string
				break;
			default:
				str = rem + str; // Appends remainder to the string
				break;
			}
        
        num=num/16; // Divides the number by 16
        }
		//Displays the output
		System.out.println("Hexadecimal Number: " + str.toUpperCase());
		
		input.close();
    }
}
