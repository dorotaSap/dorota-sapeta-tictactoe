package org.example;
import org.example.tictactoegame.GameBoardRenderer;
import org.example.tictactoegame.InputHandler;
import org.example.tictactoegame.TicTacToeGame;


public class Main {
    public static void main(String[] args){
        InputHandler inputHandler = new InputHandler();
        int gameMode = inputHandler.getGameMode();

        int boardSize;
        int winCondition;
        if (gameMode == 1) {
            boardSize = 3;
            winCondition = 3;
        } else {
            boardSize = 10;
            winCondition = 5;
        }

        GameBoardRenderer renderer = new GameBoardRenderer();
        TicTacToeGame ticTacToeGame = new TicTacToeGame(boardSize, winCondition);

        boolean isPlayerTurn = true;
        boolean gameOver = false;

        while (!gameOver) {
            renderer.renderBoard(ticTacToeGame.getBoard());

            if (isPlayerTurn) {
                int playerMove = inputHandler.getPlayerMove();
                if (ticTacToeGame.makeMove(playerMove, 'X')) {
                    if (ticTacToeGame.checkWin('X')) {
                        renderer.renderBoard(ticTacToeGame.getBoard());
                        renderer.printMessage("Gratulacje! Wygrałeś!");
                        gameOver = true;
                    } else if (ticTacToeGame.isBoardFull()) {
                        renderer.renderBoard(ticTacToeGame.getBoard());
                        renderer.printMessage("Remis! Plansza jest pełna.");
                        gameOver = true;
                    }
                    isPlayerTurn = false;
                } else {
                    renderer.printMessage("Niedozwolony ruch. Spróbuj ponownie.");
                }
            } else {
                ticTacToeGame.computerMove();

                if (ticTacToeGame.checkWin('O')) {
                    renderer.renderBoard(ticTacToeGame.getBoard());
                    renderer.printMessage("Komputer wygrał. Spróbuj jeszcze raz!");
                    gameOver = true;
                } else if (ticTacToeGame.isBoardFull()) {
                    renderer.renderBoard(ticTacToeGame.getBoard());
                    renderer.printMessage("Remis! Plansza jest pełna.");
                    gameOver = true;
                }
                isPlayerTurn = true;
            }
        }

        inputHandler.closeScanner();
    }
}