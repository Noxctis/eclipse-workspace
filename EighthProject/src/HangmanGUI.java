import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class HangmanGUI extends JFrame {
    private final static String[] words = {
            "write", "that", "program", "java", "object", 
            "class", "inheritance", "encapsulation", 
            "polymorphism", "abstraction"
    };

    private String selectedWord;  // The selected word for the game
    private String guessedWord;   // Current guessed word with asterisks
    private int misses;           // Counter for incorrect guesses

    private JLabel wordLabel;     // Label to display the current guessed word
    private JTextField guessField; // Text field for user input
    private JButton guessButton;  // Button to submit a guess
    private JLabel statusLabel;   // Label to display game status
    private JButton resetButton;  // Button to reset the game

    // Constructor: Initialize the GUI components and game state
    public HangmanGUI() {
        setTitle("Hangman Game");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Initialize the game state
        resetGame();

        // Word display panel
        JPanel wordPanel = new JPanel();
        wordLabel = new JLabel(guessedWord);
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
        statusLabel = new JLabel("Misses: 0");
        resetButton = new JButton("Reset Game");
        statusPanel.add(statusLabel);
        statusPanel.add(resetButton);

        // Add panels to the frame
        add(wordPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        // Add action listener for the guess button
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });

        // Add action listener for the reset button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        setVisible(true);
    }

    // Reset the game state
    private void resetGame() {
        Random random = new Random();
        selectedWord = words[random.nextInt(words.length)];
        fillAsterisk();
        misses = 0;
        statusLabel.setText("Misses: 0");
        wordLabel.setText(guessedWord);
    }

    // Fill the guessed word with asterisks
    private void fillAsterisk() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < selectedWord.length(); i++) {
            sb.append('*');
        }
        guessedWord = sb.toString();
    }

    // Check if the guessed letter is correct and update the guessed word
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

    // Check if the word has been fully guessed
    private boolean isWordFinish() {
        return !guessedWord.contains("*");
    }

    // Main method to run the game
    public static void main(String[] args) {
        new HangmanGUI();
    }
}
