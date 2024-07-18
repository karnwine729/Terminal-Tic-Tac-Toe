public class GameBoard {
    private char[] positionValues;

    public GameBoard() {
        this.positionValues = new char[9];        
    }

    public void displayBoard() {
        System.out.println();
        displayTopRow(positionValues);
        System.out.println("-".repeat(11));
        displayMiddleRow(positionValues);
        System.out.println("-".repeat(11));
        displayBottomRow(positionValues);
        System.out.println();
    }

    private void displayTopRow(char[] positionValues) {
        for (int i = 1; i <= 11; i++) {
            if (isBlank(i))             System.out.print(" ");
            if ((i == 4) || (i == 8))   System.out.print("|");
            if (i == 2)                 System.out.print(positionValues[6]);
            if (i == 6)                 System.out.print(positionValues[7]);
            if (i == 10)                System.out.print(positionValues[8]);
            if (i == 11)                System.out.println();
        }
    }

    private void displayMiddleRow(char[] positionValues) {
        for (int i = 1; i <= 11; i++) {
            if (isBlank(i))             System.out.print(" ");
            if ((i == 4) || (i == 8))   System.out.print("|");
            if (i == 2)                 System.out.print(positionValues[3]);
            if (i == 6)                 System.out.print(positionValues[4]);
            if (i == 10)                System.out.print(positionValues[5]);
            if (i == 11)                System.out.println();
        }
    }

    private void displayBottomRow(char[] positionValues) {
        for (int i = 1; i <= 11; i++) {
            if (isBlank(i))             System.out.print(" ");
            if ((i == 4) || (i == 8))   System.out.print("|");
            if (i == 2)                 System.out.print(positionValues[0]);
            if (i == 6)                 System.out.print(positionValues[1]);
            if (i == 10)                System.out.print(positionValues[2]);
            if (i == 11)                System.out.println();
        }
    }

    private boolean isBlank(int n) {
        return (n == 1) || (n == 3) || (n == 5) || (n == 7) || (n == 9) || (n == 11);
    }

    public int columnWin() {        
        for (int i = 0; i <= 2; i++) {            
            if (!isColumnFull(i)) continue;
            if (positionValues[i] == positionValues[i + 3] && positionValues[i] == positionValues[i + 6]) {
                return (positionValues[i] == 'X') ? 1 : 2;
            }
        }
        return 0;
    }

    private boolean isColumnFull(int column) {
        boolean filled = true;
        if (positionValues[column] == ' ' || positionValues[column + 3] == ' ' || positionValues[column + 6] == ' ') filled = false;
        return filled;
    }

    public int rowWin() {        
        for (int i = 0; i <= 6; i += 3) {
            if (!isRowFull(i)) continue;
            if (positionValues[i] == positionValues[i + 1] && positionValues[i] == positionValues[i + 2]) {
                return (positionValues[i] == 'X') ? 1 : 2;
            }
        }
        return 0;
    }

    private boolean isRowFull(int row) {
        boolean filled = true;
        if (positionValues[row] == ' ' || positionValues[row + 1] == ' ' || positionValues[row + 2] == ' ') filled = false;
        return filled;
    }

    public int diagonalWin() {        
        if (positionValues[0] == 'X' && positionValues [4] == 'X' && positionValues[8] == 'X') return 1;
        if (positionValues[2] == 'X' && positionValues [4] == 'X' && positionValues[6] == 'X') return 1;
        if (positionValues[0] == 'O' && positionValues [4] == 'O' && positionValues[8] == 'O') return 2;
        if (positionValues[2] == 'O' && positionValues [4] == 'O' && positionValues[6] == 'O') return 2;
        return 0;
    }

    public boolean isDraw() {
        for (int i = 0; i <= 8; i++) {
            if (positionValues[i] == ' ') return false;            
        }
        return true;
    }

    public boolean isPositionValid(int position) {
        if (position < 0 || position > 8) return false;
        return (positionValues[position] == ' ');
    }

    public void updatePositionValues(int player, int position) {        
        positionValues[position] = (player == 1) ? 'X' : 'O';        
    }

    public void resetPositionValues() {
        for (int i = 0; i < 9; i++) {
            positionValues[i] = ' ';
        }
    }
}