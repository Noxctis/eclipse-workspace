import java.util.Scanner;

public class Exercise2 {
	public static void main(String[] args) {
    	int number;
    	int ones;
    	int i;
    	Scanner keyInput = new Scanner(System.in);
		
		System.out.println("Enter positive integer :");
		
		number = keyInput.nextInt();
		
		while(number>0) {
			ones = number % 10;
			number = number/10;
			switch(ones) {
				case 1:
					System.out.println("ONE");
					break;
				case 2:
					System.out.println("TWO");
					break;
				case 3:
					System.out.println("THREE");
					break;
				case 4:
					System.out.println("FOUR");
					break;
				case 5:
					System.out.println("FIVE");
					break;
				case 6:
					System.out.println("SIX");
					break;
				case 7:
					System.out.println("SEVEN");
					break;
				case 8:
					System.out.println("EIGHT");
					break;
				case 9:
					System.out.println("NINE");
					break;
				default:
					System.out.println("ZERO");
					break;
				}

		}
		keyInput.close();
	}
}
