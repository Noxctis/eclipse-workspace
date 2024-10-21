/*
============================================================================
FILE : RandomPINAuthenticatorGUI.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : The program should then randomize the pin.
COPYRIGHT : 21-10-2024
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

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * This class represents a Random PIN Authentication System with a graphical user interface (GUI).
 * Users can input their PIN and then enter the mapped PIN corresponding to a randomized mapping of digits 0-9.
 * The system will authenticate the user's input based on the random mapping of the actual PIN.
 */
public class RandomPINAuthenticatorGUI extends JFrame {
    private int[] pin;               // Store the user's actual 5-digit PIN
    private int[] randomMapping;     // Store the random number mapping for digits 0-9

    private JLabel pinLabel;         // Label to display the PIN digits (0-9)
    private JLabel numLabel;         // Label to display the randomized numbers (1-3)
    private JTextField inputPinField; // Text field for user input of their PIN
    private JButton submitPinButton;  // Button to submit the PIN input
    private JTextField inputField;   // Text field for user input of the mapped PIN
    private JButton submitButton;    // Button to submit the mapped PIN input
    private JButton resetButton;     // Button to reset the mapping
    private JLabel statusLabel;      // Label to display the authentication status

    /**
     * Constructor: Initializes the GUI components and sets up the random PIN system.
     */
    public RandomPINAuthenticatorGUI() {
        setTitle("Random PIN Authentication");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window on the screen

        randomMapping = new int[10];

        // Input field for PIN
        JPanel pinInputPanel = new JPanel();
        pinInputPanel.setLayout(new FlowLayout());
        inputPinField = new JTextField(5);
        submitPinButton = new JButton("Submit PIN");
        pinInputPanel.add(new JLabel("Enter your 5-digit PIN:"));
        pinInputPanel.add(inputPinField);
        pinInputPanel.add(submitPinButton);
        add(pinInputPanel);

        // Action listener for submitting PIN
        submitPinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String inputPin = inputPinField.getText();
                if (inputPin.length() == 5 && inputPin.matches("\\d+")) {
                    pin = new int[5];
                    for (int i = 0; i < 5; i++) {
                        pin[i] = Character.getNumericValue(inputPin.charAt(i));
                    }
                    generateRandomMapping();  // Generate a random mapping after inputting the PIN
                    pinLabel.setText("PIN : 0 1 2 3 4 5 6 7 8 9");
                    numLabel.setText(getMappingAsString());
                    statusLabel.setText("Enter the mapped numbers for your PIN.");
                } else {
                    statusLabel.setText("Please enter a valid 5-digit PIN.");
                }
            }
        });

        // PIN Label (show digits 0-9)
        pinLabel = new JLabel("", SwingConstants.CENTER);
        pinLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(pinLabel);

        // Randomized numbers label (for the corresponding digits)
        numLabel = new JLabel("", SwingConstants.CENTER);
        numLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(numLabel);

        // Input field for mapped PIN
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputField = new JTextField(5);
        inputPanel.add(new JLabel("Enter mapped PIN:"));
        inputPanel.add(inputField);
        add(inputPanel);

        // Submit button to authenticate the input
        submitButton = new JButton("Submit Mapped PIN");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String input = inputField.getText();
                if (input.length() == 5 && input.matches("\\d+")) {
                    int[] userInput = new int[5];
                    for (int i = 0; i < 5; i++) {
                        userInput[i] = Character.getNumericValue(input.charAt(i));
                    }
                    if (authenticate(userInput)) {
                        statusLabel.setText("Access granted!");
                    } else {
                        statusLabel.setText("Access denied!");
                    }
                } else {
                    statusLabel.setText("Please enter exactly 5 digits.");
                }
            }
        });
        add(submitButton);

        // Reset button to regenerate the random mapping
        resetButton = new JButton("Reset");
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (pin != null) {
                    generateRandomMapping();
                    numLabel.setText(getMappingAsString());
                    statusLabel.setText("New random mapping generated.");
                    inputField.setText("");
                } else {
                    statusLabel.setText("Enter your PIN first.");
                }
            }
        });
        add(resetButton);

        // Status label to display results (access granted or denied)
        statusLabel = new JLabel("Enter your PIN and generate the mapping.", SwingConstants.CENTER);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(statusLabel);

        setVisible(true);
    }

    /**
     * Generates a random mapping for digits 0-9.
     * Each digit is randomly mapped to a number between 1 and 3.
     */
    public void generateRandomMapping() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            randomMapping[i] = random.nextInt(3) + 1;  // Random number between 1 and 3
        }
    }

    /**
     * Retrieves the random mapping as a formatted string for display.
     * @return A string representation of the random mapping for digits 0-9.
     */
    public String getMappingAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NUM: ");
        for (int i = 0; i < 10; i++) {
            sb.append(randomMapping[i]).append(" ");
        }
        return sb.toString();
    }

    /**
     * Authenticates the user input by matching it against the randomized mapping.
     * @param userInput An array of integers representing the user's entered mapped PIN.
     * @return true if the input matches the randomized mapping, false otherwise.
     */
    public boolean authenticate(int[] userInput) {
        for (int i = 0; i < 5; i++) {
            int pinDigit = pin[i];  // Get the digit from the actual PIN
            int mappedValue = randomMapping[pinDigit];  // Get the mapped value for the digit

            if (userInput[i] != mappedValue) {
                return false;  // Authentication failed
            }
        }
        return true;  // Authentication successful
    }

    /**
     * Main method to run the application. Initializes the GUI.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new RandomPINAuthenticatorGUI();
    }
}
