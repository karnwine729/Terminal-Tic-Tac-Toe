# Terminal-Tic-Tac-Toe

## Objective:
Create a Java application that allows two players to play a game of Tic-Tac-Toe using the terminal. Players will use the numpad keys to select their spot on the board.

## Requirements:
1. **Game Board:**
   - Implement a 3x3 game board represented in the terminal.
   - The board positions should be mapped to numpad keys as follows:
     ```
     7 | 8 | 9
     ---------
     4 | 5 | 6
     ---------
     1 | 2 | 3
     ```

2. **Players:**
   - The game should support two players. Player 1 uses the mark "X" and Player 2 uses the mark "O".
   - Players should take turns to place their marks on the board by entering the corresponding numpad key.

3. **Game Mechanics:**
   - Allow players to enter a numpad key to place their mark in the corresponding cell.
   - Prevent players from placing a mark on a cell that is already occupied.
   - Detect when a player has won the game (three marks in a row horizontally, vertically, or diagonally).
   - Detect when the game ends in a draw (all cells are filled without a winner).
   - Display a message indicating whether a player has won or if the game is a draw.

4. **User Interface:**
   - Display the game board after each move.
   - Indicate which player's turn it is.
   - Provide clear instructions for players on how to select their spot on the board using the numpad keys.
   - Include a prompt to start a new game once the current game has ended.