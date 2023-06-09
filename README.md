# Tic-Tac-Toe Game
This project is a simple implementation of the classic game Tic-Tac-Toe. It is built using Java and includes a graphical user interface (GUI) using Swing. The game allows two players to take turns and complete against each other to get three of their marks (either 'X' or 'O') in a row, either horizontally, vertically, or diagonally.

## Files
The project consists of the following files:
1. **`Main.java`**: This file contains the main method and serves as the entry point for the application. It creates an instance of the **TicTacToe** class and starts the game.
2. **`TicTacToe.java`**: This file contains **TicTacToe** class, which is responsilbe for managing the game logic and GUI. It implements the **ActionListener** interface to handle button clicks and other events. The class contains methods for starting a new game, checking for a win, updating the game state, and saving the game.

## Design Choices
In designing this Tic-Tac-Toe game, several choices were made to ensure a smooth and user-friendly experience:

1. **`GUI Layout`**: The GUI is designed using a **JFrame** with a **BorderLayout**. The title panel is located at the top and contains the game title, start button, and save button. The button panel is placed in the center and contains the nine buttons representing the Tic-Tac-Toe grid.
2. **`Button Configuration`**: Each button in the game grid is represented by a **JButton** object. The buttons are set to have a large font size and are disabled after being clicked to prevent further interation. The button colors are set to default, and when a player wins, the winning combination of buttons is highlighted in green.
3. **`Game State`**: The game maintains a boolean flag, **player1Turn**, to keep track of which player's turn it is. This flag is toggled after each move. The game also keeps track of whether a game has been started or not using the **isGameStarted** flag.
4. **`Event Handling`**: The game implements the **ActionListener** interface to handle button clicks and other events. The **actionPerformed** method is overhidden to perform the necessary actions based on the event source. The start button starts a new game, the save button saves the current game state, and the grid buttons handle player moves.

