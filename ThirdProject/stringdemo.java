

import java.util.Scanner;

public class stringdemo{
	
	public static void main (String[] args){
		
		String greeting = "Text processing is hard!";
		String numbers = "012345678901234567890123";
		
		int position = greeting.lastIndexOf("hard");
			
			System.out.println(greeting);
			System.out.println(numbers);
			System.out.println("The word \"hard\" starts at index " + position);
			System.out.println("The changed string is: ");
			String greeting2 = greeting.substring(0,position) + "easy";
			System.out.println(greeting2.toUpperCase());
			
		int n;
		String s1,s2;
		Scanner keyboard = new Scanner(System.in);
		n = keyboard.nextInt();
		s1 = keyboard.nextLine();
		s2 = keyboard.nextLine();
		System.out.println(s1);
		System.out.println(s2);
		keyboard.close();
	}
}