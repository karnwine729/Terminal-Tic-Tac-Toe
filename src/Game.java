import java.util.Scanner;

public class Game {
    private int player;
    private GameBoard board;
    private Scanner sc;
    private boolean gameover;    
    private int winner;
    private boolean playAgain = true;;

    public Game() {
        this.player = 1;
        this.winner = 0;
        this.board = new GameBoard();
        this.sc = new Scanner(System.in);        
    }

    public void play() {
        while(playAgain) {
            start();
            loop();
            playAgain = end();
            if (!playAgain) break;
        }
    }

    private void start() {
        board.resetPositionValues();        
        gameover = false;
        winner = 0;
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Welcome to Terminal-Tic-Tac-Toe!");
        System.out.println("Player 1 plays 'X' and Player 2 plays 'O'.");
        System.out.println("-".repeat(50));          
    }

    private void loop() {            
        board.displayBoard();        
        while (!gameover) {
            System.out.println("-".repeat(30));
            System.out.println("Select a Position on the Numpad.");
            System.out.println("-".repeat(30));
            System.out.print("Player " + player + "'s Turn: ");
            getPlayerMove();
            board.displayBoard();
            checkWinOrDraw();            
        }
    }

    private boolean end() {
        if (winner != 0) {
            System.out.println("*".repeat(3) + " Player " + winner + " Wins! " + "*".repeat(3));
        } else {
            System.out.println("It's a draw!");
        }        
        System.out.print("\nEnter \"yes\" or \"y\" to play again: ");
        String input = sc.nextLine().toLowerCase();
        return (input.equals("y") || input.equals("yes"));
    }

    private void checkWinOrDraw() {
        if (board.columnWin() != 0) {
            gameover = true;
            winner = board.columnWin();
        }
        if (board.rowWin() != 0) {
            gameover = true;
            winner = board.rowWin();
        }
        if (board.diagonalWin() != 0) {
            gameover = true;
            winner = board.diagonalWin();
        }
        if (board.isDraw()) {
            gameover = true;
        }
    }    

    private void getPlayerMove() {
        boolean validMove = false;
        while (!validMove) {
            int position = sc.nextInt() - 1;
            sc.nextLine();
            if (!board.isPositionValid(position)) {
                System.out.print("Invalid Position. Please Choose Another Position: ");
                continue;
            }
            board.updatePositionValues(player, position);
            validMove = true;            
        }
        changePlayer();
    }    

    private void changePlayer() {
        player = (player == 1) ? 2 : 1;
    }
}
