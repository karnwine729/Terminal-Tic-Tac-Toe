public class GameBoard {
    private char[] positionValues;

    public GameBoard() {
        this.positionValues = new char[9];
        for (int i = 0; i < 9; i++) {
            positionValues[i] = ' ';
        }
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

    public boolean isPositionValid(int position) {
        if (position < 0 || position > 8) return false;
        return (positionValues[position] == ' ');
    }

    public boolean updatePositionValues(int player, int position) {
        if (!isPositionValid(position)) return false;
        positionValues[position] = (player == 1) ? 'X' : 'O';
        return true;
    }
}