import java.util.Scanner;

public class Main {

    private static char[][] board = new char[3][3];
    public static char currentPlayer = 'X';

    public static void main(String[] args) {
        newBoard();
        printBoard();

        while (true) {
            yourMove();
            printBoard();
            if (youWin()) {
                System.out.println("You win!");
                break;
            } else if (isEven()) {
                System.out.println("No winners!");
                break;
            }
            playerTwo();
        }
    }

    public static void newBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void yourMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Enter a row number (0, 1, or 2): ");
            row = scanner.nextInt();
            System.out.println("Enter a column number (0, 1, or 2): ");
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static void playerTwo() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static boolean youWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    private static boolean isEven() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
