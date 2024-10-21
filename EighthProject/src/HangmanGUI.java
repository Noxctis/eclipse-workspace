/*
============================================================================
FILE : HangmanGUI.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : The progam should be a hangman game.
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * The HangmanGUI class represents a graphical user interface (GUI) version of the classic Hangman game.
 * The player attempts to guess a randomly selected word by guessing one letter at a time.
 * The player loses if they exceed a number of incorrect guesses.
 */
public class HangmanGUI extends JFrame {
    private String[] words;       // The list of words for the game
    private String selectedWord;  // The selected word for the game
    private String guessedWord;   // Current guessed word with asterisks
    private int misses;           // Counter for incorrect guesses

    private JLabel wordLabel;     // Label to display the current guessed word
    private JTextField guessField; // Text field for user input
    private JButton guessButton;  // Button to submit a guess
    private JLabel statusLabel;   // Label to display game status
    private JButton resetButton;  // Button to reset the game

    /**
     * Constructor: Initializes the GUI components, the game state, and the word list.
     * @param words A list of words for the Hangman game.
     */
    public HangmanGUI(String[] words) {
        this.words = words;  // Set the words through the constructor
        
        setTitle("Hangman Game");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Initialize GUI components first
        wordLabel = new JLabel(); // Initialize wordLabel before using it
        statusLabel = new JLabel("Misses: 0"); // Initialize statusLabel with default text

        // Word display panel
        JPanel wordPanel = new JPanel();
        wordLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        wordPanel.add(wordLabel);

        // Guess input panel
        JPanel inputPanel = new JPanel();
        guessField = new JTextField(5);
        guessButton = new JButton("Guess");
        inputPanel.add(new JLabel("Enter a letter: "));
        inputPanel.add(guessField);
        inputPanel.add(guessButton);

        // Status panel
        JPanel statusPanel = new JPanel();
        resetButton = new JButton("Reset Game");
        statusPanel.add(statusLabel);
        statusPanel.add(resetButton);

        // Add panels to the frame
        add(wordPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        // Initialize the game state after GUI components are set up
        resetGame();

        // Action listener for the guess button
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });

        // Action listener for the reset button
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        setVisible(true);
    }

    /**
     * Handles the player's guess input. Updates the game state and checks for the result of the guess.
     */
    private void handleGuess() {
        String input = guessField.getText();
        if (input.length() == 1) {
            char guess = input.charAt(0);
            if (!correctGuess(guess)) {
                misses++;
                statusLabel.setText("Misses: " + misses);
            }
            wordLabel.setText(guessedWord);
            if (isWordFinish()) {
                JOptionPane.showMessageDialog(null, "You guessed the word: " + selectedWord);
                resetGame();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a single letter.");
        }
        guessField.setText("");
    }

    /**
     * Resets the game state, selects a new random word, and sets up the word to be guessed with asterisks.
     * The number of misses is reset to 0.
     */
    private void resetGame() {
        Random random = new Random();
        selectedWord = words[random.nextInt(words.length)];
        fillAsterisk();
        misses = 0;
        statusLabel.setText("Misses: 0");
        wordLabel.setText(guessedWord);
    }

    /**
     * Fills the guessed word with asterisks to hide the letters of the selected word.
     */
    private void fillAsterisk() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < selectedWord.length(); i++) {
            sb.append('*');
        }
        guessedWord = sb.toString();
    }

    /**
     * Checks if the guessed letter is correct and updates the guessed word.
     * @param guess The guessed letter entered by the player.
     * @return true if the guessed letter is correct, false otherwise.
     */
    private boolean correctGuess(char guess) {
        boolean found = false;
        StringBuilder newGuessedWord = new StringBuilder(guessedWord);

        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == guess && guessedWord.charAt(i) == '*') {
                newGuessedWord.setCharAt(i, guess);
                found = true;
            }
        }

        guessedWord = newGuessedWord.toString();
        return found;
    }

    /**
     * Checks if the word has been fully guessed by the player.
     * @return true if the word has been fully guessed, false otherwise.
     */
    private boolean isWordFinish() {
        return !guessedWord.contains("*");
    }

    /**
     * Main method to run the Hangman game.
     * Creates an instance of HangmanGUI with a custom list of words to start the game.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Sample word list to be passed into the constructor
        String[] wordList = {
            "write", "that", "program", "java", "object", 
            "class", "inheritance", "encapsulation", 
            "polymorphism", "abstraction"
        };

        new HangmanGUI(wordList);
    }
}
