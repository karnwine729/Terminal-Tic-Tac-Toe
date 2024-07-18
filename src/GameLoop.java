import java.util.Scanner;

public class GameLoop {
    private int player;
    private GameBoard board;
    private Scanner sc;
    private boolean gameover;

    public GameLoop() {
        this.player = 1;
        this.board = new GameBoard();
        this.sc = new Scanner(System.in);
        this.gameover = false;
    }

    public void startGame() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Welcome to Terminal-Tic-Tac-Toe!");
        System.out.println("Player 1 plays 'X' and Player 2 plays 'O'.");
        System.out.println("-".repeat(50));
        runGame();      
    }

    private void runGame() {
        System.out.println("Select a Position on the Numpad.");        
        board.displayBoard();        
        while(!gameover) {
            System.out.print("Player " + this.player + "'s Turn: ");
            getPlayerMove();
            board.displayBoard();
        }        
    }

    private void getPlayerMove() {
        boolean validMove = false;
        while (!validMove) {
            int position = sc.nextInt() - 1;
            if (!board.isPositionValid(position)) {
                System.out.print("Invalid Position. Please Choose Another Position: ");
                continue;
            }
            board.updatePositionValues(this.player, position);
            validMove = true;            
        }
        changePlayer();
    }    

    private void changePlayer() {
        player = (player == 1) ? 2 : 1;
    }
}
