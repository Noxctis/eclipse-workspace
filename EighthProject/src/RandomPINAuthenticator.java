import java.util.Random;
import java.util.Scanner;

public class RandomPINAuthenticator {
    private int[] pin;               // Store the user's actual 5-digit PIN
    private int[] randomMapping;     // Store the random number mapping for digits 0-9

    // Constructor: Initialize with the actual PIN and generate random mapping
    public RandomPINAuthenticator(int[] pin) {
        if (pin.length != 5) {
            throw new IllegalArgumentException("PIN must be exactly 5 digits.");
        }
        this.pin = pin;
        this.randomMapping = new int[10]; // Random numbers for digits 0-9
        generateRandomMapping();
    }

    // Generate random mapping for the digits 0-9 (each assigned a random number 1-3)
    public void generateRandomMapping() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            randomMapping[i] = random.nextInt(3) + 1;  // Random number between 1 and 3
        }
    }

    // Display the PIN digits and their corresponding random numbers
    public void displayMapping() {
        System.out.println("PIN : 0 1 2 3 4 5 6 7 8 9");
        System.out.print("NUM: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(randomMapping[i] + " ");
        }
        System.out.println();
    }

    // Authenticate the user input by matching it against the randomized mapping
    public boolean authenticate(int[] userInput) {
        if (userInput.length != 5) {
            return false;  // Invalid input length
        }

        // Check if each input corresponds to the mapped value of the actual PIN digits
        for (int i = 0; i < 5; i++) {
            int pinDigit = pin[i];  // Get the digit from the actual PIN
            int mappedValue = randomMapping[pinDigit];  // Get the mapped value for the digit

            if (userInput[i] != mappedValue) {
                return false;  // Authentication failed
            }
        }
        return true;  // Authentication successful
    }

    // Main method to run the authentication process
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example: Actual PIN is 12345
        int[] actualPin = {1, 2, 3, 4, 5};
        RandomPINAuthenticator authenticator = new RandomPINAuthenticator(actualPin);

        // Display the random mapping to the user
        authenticator.displayMapping();

        // Prompt the user to enter the mapped numbers corresponding to their PIN
        System.out.println("Enter the mapped numbers for your 5-digit PIN:");
        int[] userInput = new int[5];
        for (int i = 0; i < 5; i++) {
            userInput[i] = scanner.nextInt();
        }

        // Authenticate the user's input
        if (authenticator.authenticate(userInput)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }
}
