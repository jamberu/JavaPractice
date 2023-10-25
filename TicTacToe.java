import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Game {
    public static String[] board;
    public static String player;

    public static String boardUpdate() {
        for (int arr = 0; arr < 8; arr++) {
            String line = null;
            switch (arr) {
                case 0:
                line = board[0] + board[1] + board[2];
                break;
                case 1:
                line = board[3] + board[4] + board[5];
                break;
                case 2:
                line = board[6] + board[7] + board[8];
                break;
                case 3:
                line = board[0] + board[3] + board[6];
                break;
                case 4:
                line = board[1] + board[4] + board[7];
                break;
                case 5:
                line = board[2] + board[5] + board[8];
                break;
                case 6:
                line = board[0] + board[4] + board[8];
                break;
                case 7:
                line = board[2] + board[4] + board[6];
                break;
            }

            if (line.equalsIgnoreCase("XXX")) {
                return "X";
            }
            else if (line.equalsIgnoreCase("000")) {
                return "0";
            }
        }

        for (int arr = 0; arr < 9; arr++) {
            if (Arrays.asList(board).contains(String.valueOf(arr + 1))) {
                break;
            }

            else if (arr == 8) {
                return "Draw";
            }
        }

        System.out.printf("%s's Turn. Enter a position to fill up: ", player);

        return null;
    }

    public static void displayBoard() {
        System.out.println(board[0] + " " + board[1] + " " + board[2]);
        System.out.println(board[3] + " " + board[4] + " " + board[5]);
        System.out.println(board[6] + " " + board[7] + " " + board[8]);
    }

    public static void main (String[] args) {
        board = new String[9]; 

        Scanner entry = new Scanner(System.in);
        Random random = new Random();
        int startPlayer = random.nextInt(0, 2);
        if (startPlayer == 0) {
            player = "X";
        }
        else {
            player = "O";
        }

        String winner = null;

        for (int arr = 0; arr < 9; arr++) {
            board[arr] = String.valueOf(arr + 1);
        }

        System.out.println("TIC-TAC-TOE GAME");
        Game.displayBoard();
        System.out.println("\nPlayer " + player + " will go first.");
        System.out.print("Enter a position to fill up: ");

        while (winner == null) {
            int position = entry.nextInt();
            if (board[position - 1].equals(String.valueOf(position))) {
                board[position - 1] = player;

                if (player.equalsIgnoreCase("X")) {
                    player = "O";
                }
                else {
                    player = "X";
                }

                Game.displayBoard();
                winner = boardUpdate();
            }
        }

        if (winner.equalsIgnoreCase("Draw")) {
            System.out.println("The game has concluded. It's a draw.");
            entry.close();
        }
        else {
            System.out.println("Player " + winner + " won!");
            entry.close();
        }
    }
}
