import java.util.Scanner;

public class GameLoop {
    private int player;
    private GameBoard board;
    private Scanner sc;

    public GameLoop() {
        this.player = 1;
        this.board = new GameBoard();
        this.sc = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Welcome to Terminal-Tic-Tac-Toe!");
        System.out.println("Player 1 plays 'X' and Player 2 plays 'O'.");
        System.out.println("-".repeat(50));
        runGame();      
    }

    public void runGame() {
        System.out.println("Select a Position on the Numpad.");        
        board.displayBoard();
        getPlayerMove();
        board.displayBoard();
        getPlayerMove();
        board.displayBoard();
        getPlayerMove();
        board.displayBoard();
    }

    public void getPlayerMove() {        
        System.out.print("Player " + player + "'s turn: ");
        board.updatePositionValues(player, sc.nextInt());
        changePlayer();
    }

    public void changePlayer() {
        player = (player == 1) ? 2 : 1;
    }
}
