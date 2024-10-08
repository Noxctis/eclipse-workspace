/*
============================================================================
FILE : ChocolateBars.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : The program should then output the number of chocolate bars that should be consumed to maintain one’s weight for both a woman and a man of the input weight, height, and age.
COPYRIGHT : 28-08-2024
REVISION HISTORY
Date: By: Description:

============================================================================
*/

package ThirdProject;
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
		System.out.println("Enter weight in pounds:");
		
		weightInPounds = keyInput.nextDouble();
		System.out.println("Enter height in inches:");
		
		heightInInches = keyInput.nextDouble();
		System.out.println("Enter age in years: ");
		
		ageInYears = keyInput.nextDouble();
		
		System.out.println(weightInPounds);
		System.out.println(heightInInches);
		System.out.println(ageInYears);
		
		if (weightInPounds>0&& heightInInches>0 && ageInYears>0) {
			BMRwomen = 655+(4.3*weightInPounds)+(4.7 * heightInInches) - (4.7 * ageInYears);
			BMRmen = 66+(6.3*weightInPounds)+(12.9 * heightInInches) - (6.8 * ageInYears);
			
			System.out.println("BMR for women " + BMRwomen);
			System.out.println("BMR for men " + BMRmen);
			
			womenCalo=BMRwomen/CHOCOCALO;
			menCalo=BMRmen/CHOCOCALO;
			
			System.out.println("Chocolate for women " + womenCalo);
			System.out.println("Chocolate for women " + (int)womenCalo);
			System.out.println("Chocolate for women " + womenCalo);
			System.out.println("Chocolate for men " + (int)menCalo);
		}
		else {
			System.out.println("Wrong Input!"); // error message
		}
		keyInput.close();
	}
}
