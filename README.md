# Tic-Tac-Toe Game
This project is a simple implementation of the classic game Tic-Tac-Toe. It is built using Java and includes a graphical user interface (GUI) using Swing. The game allows two players to take turns and complete against each other to get three of their marks (either 'X' or 'O') in a row, either horizontally, vertically, or diagonally.

## Getting Started
To run the Tic-Tac-Toe game, you need to have Java Development Kit (JDK) installed on your machine. Follow these steps to run the game:
1. Clone the repository or download the source code files.
2. Open a terminal or command prompt and navigate to the project directory.
3. Compile the Java source files by executing the following command:
```sh
javac Main.java
```
4. Run the game by executing the following command:
```sh
java Main
```

## Gameplay
Upon running the game, a graphical window will appear with a 3x3 grid and a "Tic-Tac-Toe" title displayed. The game is played by clicking the empty spaces on the grid to mark them with X or O symbols. The first player to get three of their symobls in a row wins the game. If all the spaces on the grid are filled and no player has won, the game ends in a tie.

## Controls
- Click on any empty space on the grid to place your symbol (X or O) and take your turn.
- Click the "Start" button to start a new game. This will reset the grid and randomly stermine which player goes first.
- Click the "Save" button to save the current state of the game. This allows you to continue the game later from where you left off.
- The game automatically saves the state after each turn and loads the saved game on startup if available.

## Files
The project consists of the following files:
1. **`Main.java`**: This file contains the main method and serves as the entry point for the application. It creates an instance of the **'TicTacToe'** class and starts the game.
2. **`TicTacToe.java`**: This file contains **'TicTacToe'** class, which is responsilbe for managing the game logic and GUI. It implements the **'ActionListener'** interface to handle button clicks and other events. The class contains methods for starting a new game, checking for a win, updating the game state, and saving the game.

## Class Variables
- **`random`**: And instance of the **'Random'** class used for randomzing the first player.
- **`frame`**: The main **'JFrame'** that hold the GUI components.
- **`titlePanel`**: A **'JPanel'** that contains the title and buttons.
- **`buttonPanel`**: A **'JPanel'** that contains the 3x3 grid of buttons.
- **`textField`**: A **'JLabel'** used to display the game status.
- **`buttons`**: An array of **'JButton'** objects representing the cells in the grid.
- **`startButton`**: A **'JButton'** to start a new game.
- **`saveButton`**: A **'JButton'** to save the game state.
- **`player1Turn`**: A boolean flag indicating whether it's the first player's turn.
- **`isGameStarted`**: A boolean flag indicating whether the game has started.
- **`backgroundMusic`**: An instance of the **'Clip'** class used to play background music.

## Game Methods
- **`startGame()`**: Starts a new game by resetting the board and determining the first turn.
- **`firstTurn()`**: Randomly selects which player goes first and updates the game status.
- **`check()`**: Checks if there is a winner or a tie by examining the cell values.
- **`xWins(int a, int b, int c)`**: Handles the scenario when player X wins and displays the result.
- **`oWins(int a, int b, int c)`**: Handles the scenario when player O wins and displays the result.
- **`saveGame()`**: Saves the current game state to a file.
- **`resetGameAfterDelay(int delay)`**: Resets the game after a specified delay in milliseconds. It clears the board, updates the game status, and starts a new game after the delay.

## Helper Methods
- **`isBoardFull()`**: Checks if the game board is completely filled with symbols.
- **`playWinSound()`**: Plays a sound effect when a player wins the game.
- **`playButtonSound()`**: Plays a sound effect when a button is clicked.
- **`playBackgroundMusic()`**: Plays the background music during the game.
- **`stopBackgroundMusic()`**: Stops the background music.

## Save/Load Methods
- **`saveGameState(File file)`**: Saves the current game state to a file using Java's serialization mechanism.
- **`loadGameState(File file)`**: Loads a saved game state from a file and restores the game board and other variables.

These methods are responsible for saving and loading the game state to and from a file, allowing the player to continue a previously saved game.

## Design Choices
In designing this Tic-Tac-Toe game, several choices were made to ensure a smooth and user-friendly experience:

1. **`GUI Layout`**: The GUI is designed using a **'JFrame'** with a **'BorderLayout'**. The title panel is located at the top and contains the game title, start button, and save button. The button panel is placed in the center and contains the nine buttons representing the Tic-Tac-Toe grid.
2. **`Button Configuration`**: Each button in the game grid is represented by a **'JButton'** object. The buttons are set to have a large font size and are disabled after being clicked to prevent further interation. The button colors are set to default, and when a player wins, the winning combination of buttons is highlighted in green.
3. **`Game State`**: The game maintains a boolean flag, **'player1Turn'**, to keep track of which player's turn it is. This flag is toggled after each move. The game also keeps track of whether a game has been started or not using the **'isGameStarted'** flag.
4. **`Event Handling`**: The game implements the **'ActionListener'** interface to handle button clicks and other events. The **'actionPerformed'** method is overhidden to perform the necessary actions based on the event source. The start button starts a new game, the save button saves the current game state, and the grid buttons handle player moves.
5. **`Winning Conditions`**: The game checks for winning conditions after each move. It checks all possible winning combinations by comparing the text on the buttons in those positions. If a winning condition is met, the corresponding buttons are highlighted, and a sound is played. The game also checks for a tie if the board is full and no winning condition is met.
6. **`Saving and Loading`**: The game allows users to save and load the game state. The **'saveGame'** method serializes the button values, **'player1Turn'**, and **'isGameStarted'** flags to a file named **'saved_game.ser'**. The **'loadGame'** method checks if a saved game exists and loads it if found, setting the button values and game state accordingly.
7. **`Sound Effects`**: The game includes sound effects for winning conditions. It uses the **'javax.sound.sampled'** package to play audio files. The **'playSound'** method plays a sound file located in the resources folder. The **'playBackgroundMusic'** method is used to play a background music file when the game starts.

## Conclusion
This Tic-Tac-Toe game provides a fun and interactive way to play the classic game. The graphical user interface, game logic, saving/loading functionality, sound effects, and background music combine to create an enjoyable gaming experience. Whether you want to pass the time or challenge your strategic skills, TicTacToe offers a familiar yet engaging gameplay experience.

Please refer to the code comments for further details on each method and its functionality. Enjoy playing TicTacToe!!!