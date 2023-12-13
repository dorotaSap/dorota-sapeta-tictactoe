package org.example.tictactoegame;
import java.util.Scanner;
public class GameBoardRenderer {
    public void renderBoard(char[][] board) {
        System.out.println("Plansza:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
