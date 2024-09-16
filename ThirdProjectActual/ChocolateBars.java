/*
============================================================================
FILE : ChocolateBars.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : The program should then output the number of chocolate bars that should be consumed to maintain one’s weight for both a woman and a man of the input weight, height, and age.
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

import java.util.Scanner;

public class ChocolateBars {
	
	public static void main(String[] args) {
		//declaring constant
		final int CHOCOCALO=230;
		//declaration of variables
		double weightInPounds = 0, heightInInches = 0,ageInYears = 0;
		double BMRwomen,BMRmen;
		double womenCalo,menCalo;
		
		Scanner keyInput = new Scanner(System.in);
		System.out.println("Enter weight in pounds:"); //Input for Weight in pounds
		weightInPounds = keyInput.nextDouble();
		System.out.println("Enter height in inches:"); // Input for height in inches
		heightInInches = keyInput.nextDouble();
		System.out.println("Enter age in years: "); // Input for age in Years
		ageInYears = keyInput.nextDouble(); 
		System.out.println(weightInPounds); //prints weight in pounds
		System.out.println(heightInInches); // prints height in inches
		System.out.println(ageInYears);
		if (weightInPounds>0&& heightInInches>0 && ageInYears>0) { // input validation
			BMRwomen = 655+(4.3*weightInPounds)+(4.7 * heightInInches) - (4.7 * ageInYears); // calculate for bmr for women
			BMRmen = 66+(6.3*weightInPounds)+(12.9 * heightInInches) - (6.8 * ageInYears); // calculate for bmr for men
			System.out.println("BMR for women " + BMRwomen); // prints bmr for women
			System.out.println("BMR for men " + BMRmen); // prints bmr for men
			womenCalo=BMRwomen/CHOCOCALO; // calculates number of chocolate bars for women
			menCalo=BMRmen/CHOCOCALO; // calculates number of chocolate bars for men
			System.out.println("Chocolate for women " + womenCalo); // prints chocolate bars for women not integer
			System.out.println("Chocolate for women " + (int)womenCalo); // prints chocolate bars for women in integer
			System.out.println("Chocolate for men " + menCalo); // prints chocolate bars for men
			System.out.println("Chocolate for men " + (int)menCalo); // prints chocolate bars for men in integer
		}
		else {
			System.out.println("Wrong Input!"); // error message
		}
		keyInput.close();
	}
}
