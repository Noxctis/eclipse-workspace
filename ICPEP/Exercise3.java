import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (n): ");
        
        int n = scanner.nextInt();
        int height = 2 * n + 1;
        
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < (2 * (n - i) + 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
        System.out.println("*");


        for (int i = n - 1; i >= 0; i--) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < (2 * (n - i) + 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
