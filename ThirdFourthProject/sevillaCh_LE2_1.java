/*
============================================================================
FILE :LE2_1.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : Calculate the day of the week.
COPYRIGHT : 04-09-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/
import java.util.Scanner;

public class sevillaCh_LE2_1 {
	public static void main(String[] args) {
		
		//Declaration of variables
		int year,month,dayOfMonth,dayOfWeek;
		
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a year, month, and day of the month.
		System.out.print("Enter year: (e.g., 2012): "); // asks for the year
		while (!input.hasNextInt()) { // input validation if it is not a number
		      System.out.println("Input is not a number.");
		      input.nextLine();
		    }
		year = input.nextInt();
		while(year < 0) { // input validation for invalid input
			  System.out.println("Input is invalid");
		      year = input.nextInt();
		}
		
		
		System.out.print("Enter month: 1-12: "); // asks for the month
		while (!input.hasNextInt()) { // input validation if it is not a number
		      System.out.println("Input is not a number.");
		      input.nextLine();
		    }
		month = input.nextInt();
		
		while(month < 1 || month > 12) { // input validation for invalid input
			  System.out.println("Input is invalid");
		      month = input.nextInt();
		}
		
		System.out.print("Enter the day of the month: 1-31: "); //Ask for day of month
		while (!input.hasNextInt()) { // input validation if it is not a number
		      System.out.println("Input is not a number.");
		      input.nextLine();
		    }
		dayOfMonth = input.nextInt();
		
		while(dayOfMonth < 1 || dayOfMonth > 31) { // input validation for invalid inputs
			  System.out.println("Input is invalid");
			  dayOfMonth = input.nextInt();
		}

		// Convert January and February to months 13 and 14 of the previous year
		if (month == 1 || month == 2)
		{
			if(month == 1) {
				month = 13;
			}
			else {
				month = 14;
			}
			year--;
		}

		// Calculate day of the week
		dayOfWeek = (dayOfMonth + ((26 * (month + 1)) / 10) + (year % 100) 
				+ ((year % 100) / 4) + ((year / 100) / 4) + (5 * (year / 100))) % 7; 
		
		// Display result
		System.out.print("Day of the week is ");
		
		switch(dayOfWeek)
		{
			case 0: System.out.println("Saturday"); break;
			case 1: System.out.println("Sunday"); break;
			case 2: System.out.println("Monday"); break;
			case 3: System.out.println("Tuesday"); break;
			case 4: System.out.println("Wednesday"); break;
			case 5: System.out.println("Thursday"); break;
			case 6: System.out.println("Friday"); break;
		}
		
		input.close();
	}
}