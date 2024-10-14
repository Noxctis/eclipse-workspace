import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private char winner;
    private int movesCount;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        winner = ' ';
        movesCount = 0;
        reinitialize();
    }

    public boolean addMove(int row, int col) {
        if (row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != ' ' || winner != ' ') {
            return false;
        }
        board[row][col] = currentPlayer;
        movesCount++;
        if (checkWinner()) {
            winner = currentPlayer;
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        return true;
    }

    public void displayBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell == ' ' ? "." : cell);
            }
            System.out.println();
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }

    public char getWinner() {
        return winner;
    }

    public void reinitialize() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
        winner = ' ';
        movesCount = 0;
    }

    public boolean isDraw() {
        return movesCount == 9 && winner == ' ';
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        TicTacToe game = new TicTacToe();
        JButton[][] buttons = new JButton[3][3];
        JPanel panel = new JPanel(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (game.addMove(row, col)) {
                            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer() == 'X' ? 'O' : 'X'));
                            if (game.checkWinner()) {
                                JOptionPane.showMessageDialog(frame, "Player " + game.getWinner() + " wins!");
                            } else if (game.isDraw()) {
                                JOptionPane.showMessageDialog(frame, "It's a draw!");
                            }
                        }
                    }
                });
                panel.add(buttons[i][j]);
            }
        }

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
