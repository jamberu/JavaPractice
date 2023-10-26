import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

class Board {
    String[] board;

    void create() {
        board = new String[9];

        for (int pos = 0; pos < 9; pos++) {
            board[pos] = String.valueOf(pos + 1);
        }

    }

    String checkWinner() {
        for (int boardPos = 0; boardPos < 8; boardPos++) {
            String playerLine = "";

            switch (boardPos) {
                case 0:
                playerLine = board[0] + board[1] + board[2];
                break;
                case 1:
                playerLine = board[3] + board[4] + board[5];
                break;
                case 2:
                playerLine = board[6] + board[7] + board[8];
                break;
                case 3:
                playerLine = board[0] + board[3] + board[6];
                break;
                case 4:
                playerLine = board[1] + board[4] + board[7];
                break;
                case 5:
                playerLine = board[2] + board[5] + board[8];
                break;
                case 6:
                playerLine = board[0] + board[4] + board[8];
                break;
                case 7:
                playerLine = board[2] + board[4] + board[6];
                break;
            }

            if (playerLine.equals("XXX")) {
                return "X";
            }
            else if (playerLine.equals("OOO")) {
                return "O";
            }
        }

        for (int boardPos = 0; boardPos < 9; boardPos++) {
            if (Arrays.asList(board).contains(String.valueOf(boardPos + 1))) {
                break;
            }

            else if (boardPos == 8) {
                return "Draw";
            }
        }

        return null;
    }

    void display() {
        System.out.println("\t ---------");
        System.out.println("\t|  " + board[0] + " " + board[1] + " " + board[2] + "  |");
        System.out.println("\t|  " + board[3] + " " + board[4] + " " + board[5] + "  |");
        System.out.println("\t|  " + board[6] + " " + board[7] + " " + board[8] + "  |");
        System.out.println("\t ---------");
    }

    void occupyPosition(Board board, int position, String currentPlayer) {

        if (board.board[position - 1].equals(String.valueOf(position))) {
            board.board[position - 1] = currentPlayer;
        }
    }
}

public class TTT {
    public static void main (String[] args) {
        Scanner entry = new Scanner(System.in);
        int xScore = 0;
        int oScore = 0;
        String winner = null;

        System.out.println("\tTIC-TAC-TOE");
        System.out.print("Enter how many rounds you will play (BO round): ");
        int rounds = entry.nextInt();

        while (xScore + oScore < rounds) {
            System.out.println("SCORE:\nPlayer X: " + xScore + "\nPlayer O: " + oScore + "\n");

            if (rounds - (xScore + oScore) == 1) {
                break;
            }

            else {
                Board gameBoard = new Board();
                
                Random randomizer = new Random();
                int pick = randomizer.nextInt(0, 2);
                String player = null;
                String gameStatus = null;

                if (pick == 0) {
                    player = "X";
                }
                else {
                    player = "O";
                }

                gameBoard.create();
                gameBoard.display();

                while (gameStatus == null) {
                    System.out.println("NOTICE: It is Player " + player + "'s turn.");
                    System.out.print("Enter the position to fill up: ");

                    int playerPos = entry.nextInt();

                    gameBoard.occupyPosition(gameBoard, playerPos, player);

                    if (player.equals("X")) {
                        player = "O";
                    }
                    else {
                        player = "X";
                    }

                    gameBoard.display();
                    gameStatus = gameBoard.checkWinner();
                } 
                
                if (gameStatus.equals("Draw")) {
                    System.out.print("The round has concluded. It is a tie.\n\n");
                    continue;
                }

                else {
                    System.out.print("NOTICE: Player " + gameStatus + " won the round!\n\n");

                    if (gameStatus.equals("X")) {
                        xScore++;
                    }
                    else {
                        oScore++;
                    }
                    continue;
                }
            }
        }

        entry.close();
        if (xScore > oScore) {
            winner = "X";
        }

        else {
            winner = "O";
        }
        System.out.print("The game has concluded. Player " + winner + " won the game!");
    }
}
