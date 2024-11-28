package javacodechum;
import java.util.Scanner;

public class UsernameGenerator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their full name on the same line
        System.out.print("Enter your full name: "); // Use print, not println

        // Read the full name input
        String fullName = scanner.nextLine();

        // Generate the username
        String username = generateUsername(fullName);

        // Display the generated username
        System.out.println("Generated Username: " + username);

        // Close the scanner
        scanner.close();
    }

    public static String generateUsername(String fullName) {
        // Split the full name into parts
        String[] nameParts = fullName.split(" ");

        // Extract initials from all but the last name
        StringBuilder initials = new StringBuilder();
        for (int i = 0; i < nameParts.length - 1; i++) {
            initials.append(nameParts[i].charAt(0));
        }

        // Extract the last name
        String lastName = nameParts[nameParts.length - 1];

        // Capitalize the first letter and keep the rest of the last name in lowercase
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

        // Generate the username in the required format
        return "Xx" + initials.toString() + lastName + "xX";
    }
}
