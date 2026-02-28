import java.util.Scanner;

public class Main {

    static char[] board = {'1','2','3','4','5','6','7','8','9'};

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char Player1 = 'X';
        int moves = 0;
        boolean gameOver = false;

        while (!gameOver) {

            printBoard();

            System.out.print("Player " + Player1 + ", choose position (1-9): ");
            int position = input.nextInt();

            if (position < 1 || position > 9 || board[position - 1] == 'X' || board[position - 1] == 'O') {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board[position - 1] = Player1;
            moves++;

            if (checkWin()) {
                printBoard();
                System.out.println("Player " + Player1 + " wins! 🎉");
                gameOver = true;
            } else if (moves == 9) {
                printBoard();
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                Player1 = (Player1 == 'X') ? 'O' : 'X';
            }
        }
    }

    public static void printBoard() {
        System.out.println();
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    public static boolean checkWin() {

        int[][] winPositions = {
                {0,1,2},{3,4,5},{6,7,8}, // Rows
                {0,3,6},{1,4,7},{2,5,8}, // Columns
                {0,4,8},{2,4,6}          // Diagonals
        };

        for (int i = 0; i < winPositions.length; i++) {
            if (board[winPositions[i][0]] ==
                    board[winPositions[i][1]] &&
                    board[winPositions[i][1]] ==
                            board[winPositions[i][2]]) {
                return true;
            }
        }

        return false;
    }
}