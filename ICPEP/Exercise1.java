import java.util.Scanner;

import javax.swing.JOptionPane;

public class Exercise1 {

    public static void main(String[] args) {
    	int number;
    	int i;
    	Scanner keyInput = new Scanner(System.in);
		
		System.out.println("Enter positive integer :");
		
		number = keyInput.nextInt();
		
		for(i=1;i<=number;i++) {
			if((i%3 == 0) && (i%5 == 0)) {
				System.out.println("FizzBuzz");
			}
			else if(i%3 == 0) {
				System.out.println("Fizz");
			}
			else if(i%5 ==0) {
				System.out.println("Buzz");
			}
			else {
				System.out.println(i);
			}
		}
        
        }
    }
