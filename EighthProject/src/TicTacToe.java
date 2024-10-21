/*
============================================================================
FILE : TicTacToe.java
AUTHOR : Chrys Sean T. Sevilla
DESCRIPTION : The program should be a TicTacToe game
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

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The TicTacToe class represents a single game of Tic-Tac-Toe. It allows two players to take turns
 * placing their marks on a 3x3 board and checks for a winner or a draw.
 */
public class TicTacToe {
    private char[][] board;       // 3x3 board
    private char currentPlayer;   // Current player ('X' or 'O')
    private char winner;          // Winner of the game
    private int movesCount;       // Count of moves made so far

    /**
     * Constructor: Initializes the game board and starting player.
     * The board is initialized with empty cells ('-'), and the current player starts as 'X'.
     */
    public TicTacToe() {
        board = new char[3][3];       // 3x3 game board
        currentPlayer = 'X';          // 'X' starts the game
        winner = '-';                 // No winner initially
        movesCount = 0;               // Move count starts at 0
        reinitialize();               // Reset the board to initial state
    }

    /**
     * Reinitialize the game board and reset values to the starting state.
     * All cells in the board are set to '-' and player is reset to 'X'.
     */
    public void reinitialize() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';    // All board cells are empty
            }
        }
        currentPlayer = 'X';          // Reset to 'X' player
        winner = '-';                 // No winner
        movesCount = 0;               // Reset moves count
    }

    /**
     * Display the current state of the game board in the console.
     */
    public void displayBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Adds a move to the game board at the specified row and column for the current player.
     * @param row The row (0-2) where the player wants to place their mark.
     * @param col The column (0-2) where the player wants to place their mark.
     * @return true if the move is valid and was made, false if the move was invalid.
     */
    public boolean addMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            movesCount++;
            return true;
        }
        return false; // Invalid move
    }

    /**
     * Checks if there is a winner in the game by checking rows, columns, and diagonals.
     * @return true if there is a winner, false otherwise.
     */
    public boolean checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                winner = currentPlayer;
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                winner = currentPlayer;
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            winner = currentPlayer;
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            winner = currentPlayer;
            return true;
        }

        return false;
    }

    /**
     * Checks if the game is a draw (i.e., the board is full with no winner).
     * @return true if the game is a draw, false otherwise.
     */
    public boolean isDraw() {
        return movesCount == 9 && winner == '-';
    }

    /**
     * Returns the current player ('X' or 'O').
     * @return The current player.
     */
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Switches the current player's turn.
     */
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    /**
     * Reads player input for the row and column of their move.
     * Continuously prompts for input until a valid move is made.
     */
    public void readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        while (!addMove(row, col)) {
            System.out.println("Invalid move. Try again.");
            row = scanner.nextInt();
            col = scanner.nextInt();
        }
    }

    /**
     * Returns the winner of the game.
     * @return The winner ('X', 'O', or '-' if no winner).
     */
    public char getWinner() {
        return winner;
    }

    /**
     * Main method to run the game.
     * Alternates player turns until there is a winner or a draw.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        while (!game.isDraw() && game.getWinner() == '-') {
            game.displayBoard();
            game.readInput();

            if (game.checkWinner()) {
                game.displayBoard();
                System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                break;
            }

            game.switchPlayer();
        }

        if (game.isDraw()) {
            System.out.println("It's a draw!");
        }
    }
}

/**
 * The TicTacToeGUI class represents a graphical user interface (GUI) for the Tic-Tac-Toe game.
 * It allows two players to play the game on a 3x3 grid using buttons for input.
 */
class TicTacToeGUI extends JFrame {
    private TicTacToe game;
    private JButton[][] buttons;  // 3x3 array of buttons
    private JLabel statusLabel;   // Status label to display game status

    /**
     * Constructor: Initializes the Tic-Tac-Toe GUI and sets up the board.
     */
    public TicTacToeGUI() {
        game = new TicTacToe();   // Create a new TicTacToe game
        buttons = new JButton[3][3];

        // Set up the GUI window
        setTitle("Tic-Tac-Toe");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Create a panel for the buttons
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));

        // Initialize the buttons and add them to the panel
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("-");
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 40));
                final int r = row;
                final int c = col;

                // Add action listener to each button
                buttons[row][col].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (game.addMove(r, c)) {
                            buttons[r][c].setText(String.valueOf(game.getCurrentPlayer()));
                            if (game.checkWinner()) {
                                statusLabel.setText("Player " + game.getCurrentPlayer() + " wins!");
                                disableButtons();
                            } else if (game.isDraw()) {
                                statusLabel.setText("It's a draw!");
                                disableButtons();
                            } else {
                                game.switchPlayer();
                                statusLabel.setText("Player " + game.getCurrentPlayer() + "'s turn");
                            }
                        }
                    }
                });
                boardPanel.add(buttons[row][col]);  // Add button to panel
            }
        }

        // Add a status label at the bottom
        statusLabel = new JLabel("Player X's turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        // Add components to the window
        add(boardPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setVisible(true);  // Make the GUI visible
    }

    /**
     * Disables all buttons once the game is over (i.e., no further moves can be made).
     */
    private void disableButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setEnabled(false);
            }
        }
    }

    /**
     * Main method to run the GUI Tic-Tac-Toe application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new TicTacToeGUI();  // Start the TicTacToe GUI
    }
}
