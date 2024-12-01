package javaprogramming;

import java.util.Scanner;

public class ValidDecimal {
    public static boolean isValidDecimal(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        try {
            Double.valueOf(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it is a valid decimal: ");
        String userInput = scanner.nextLine();
        
        if (isValidDecimal(userInput)) {
            System.out.println(userInput + " is a valid decimal.");
        } else {
            System.out.println(userInput + " is not a valid decimal.");
        }
        
        scanner.close();
    }
}
