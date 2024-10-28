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
class TicTacToeGUI2 extends JFrame {
    private TicTacToe game;
    private JButton[][] buttons;  // 3x3 array of buttons
    private JLabel statusLabel;   // Status label to display game status
    private final JButton resetButton;   // Reset button

    public TicTacToeGUI2() {
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

        // Create the reset button
        resetButton = new JButton("Reset Board");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 20));
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        // Create a panel for the status label and reset button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(statusLabel, BorderLayout.CENTER);
        bottomPanel.add(resetButton, BorderLayout.SOUTH);

        // Add components to the window
        add(boardPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);  // Make the GUI visible
    }

    private void resetGame() {
        game.reinitialize();  // Reset the game logic
        statusLabel.setText("Player X's turn");  // Reset status label
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("-");  // Reset button texts
                buttons[row][col].setEnabled(true);  // Enable buttons
            }
        }
    }

    private void disableButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToeGUI2();  // Start the TicTacToe GUI
    }
}
