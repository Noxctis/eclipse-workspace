import java.util.Scanner;

public class EggBasket2{
	public static void main (String[] args) {
		int eggsPerBasket = 0, numberOfBaskets = 0;
		int totalEggs = 0;
		
	try (Scanner keyboard = new Scanner (System.in)) {
		System.out.println("Enter the number of eggs: ");
		eggsPerBasket = keyboard.nextInt();

		System.out.println("Enter the number of Baskets: ");
		numberOfBaskets = keyboard.nextInt();
	}
		totalEggs = eggsPerBasket * numberOfBaskets;
		
		System.out.println("If you have ");
		System.out.println(eggsPerBasket + " per basket and ");
		System.out.println(numberOfBaskets + " baskets, then");
		System.out.println("then the total number of eggs is " + totalEggs);
		System.out.println("Now we take two eggs out of each basket");
		System.out.println("you now have");
		System.out.println(eggsPerBasket - 2 + " eggs per basket and");
		System.out.println(numberOfBaskets  + " Baskets");
		System.out.println("The new total number of eggs is " + (eggsPerBasket - 2)*(numberOfBaskets));
	}
}