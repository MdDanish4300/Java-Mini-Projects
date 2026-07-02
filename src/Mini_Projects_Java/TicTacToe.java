package Mini_Projects_Java;

import java.util.Scanner;

public class TicTacToe {

    static String[] board = new String[9];

    // Initialize Board
    static void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = String.valueOf(i + 1);
        }
    }

    // Print Board
    static void printBoard() {
        System.out.println("-------------");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("-------------");
    }

    // Check Winner
    static boolean checkWinner(String player) {

        // Rows
        if (board[0].equals(player) && board[1].equals(player) && board[2].equals(player))
            return true;

        if (board[3].equals(player) && board[4].equals(player) && board[5].equals(player))
            return true;

        if (board[6].equals(player) && board[7].equals(player) && board[8].equals(player))
            return true;

        // Columns
        if (board[0].equals(player) && board[3].equals(player) && board[6].equals(player))
            return true;

        if (board[1].equals(player) && board[4].equals(player) && board[7].equals(player))
            return true;

        if (board[2].equals(player) && board[5].equals(player) && board[8].equals(player))
            return true;

        // Diagonals
        if (board[0].equals(player) && board[4].equals(player) && board[8].equals(player))
            return true;

        if (board[2].equals(player) && board[4].equals(player) && board[6].equals(player))
            return true;

        return false;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        initializeBoard();

        String currentPlayer = "X";
        boolean winner = false;

        System.out.println("===== TIC TAC TOE =====");
        printBoard();

        for (int move = 0; move < 9; move++) {

            System.out.print("Player " + currentPlayer + ", enter a position (1-9): ");
            int position = input.nextInt();

            // Check valid range
            if (position < 1 || position > 9) {
                System.out.println("Invalid position! Choose between 1 and 9.");
                move--;
                continue;
            }

            // Check if already occupied
            if (!board[position - 1].equals(String.valueOf(position))) {
                System.out.println("Position already occupied! Try again.");
                move--;
                continue;
            }

            // Place symbol
            board[position - 1] = currentPlayer;

            printBoard();

            // Check winner
            if (checkWinner(currentPlayer)) {
                System.out.println("🎉 Player " + currentPlayer + " Wins!");
                winner = true;
                break;
            }

            // Switch player
            if (currentPlayer.equals("X")) {
                currentPlayer = "O";
            } else {
                currentPlayer = "X";
            }
        }

        if (!winner) {
            System.out.println("🤝 It's a Draw!");
        }

        input.close();
    }
}