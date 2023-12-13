package org.example.tictactoegame;

 public class TicTacToeGame {

     private static char[][] board;
     private static int boardSize;
     private static int winCondition;

     public TicTacToeGame(int boardSize, int winCondition) {
         this.boardSize = boardSize;
         this.winCondition = winCondition;
         this.board = initializeBoard();
     }

     private char[][] initializeBoard() {
         char[][] newBoard = new char[boardSize][boardSize];
         for (int i = 0; i < boardSize; i++) {
             for (int j = 0; j < boardSize; j++) {
                 newBoard[i][j] = ' ';
             }
         }
         return newBoard;
     }

     public boolean isBoardFull() {
         for (int i = 0; i < boardSize; i++) {
             for (int j = 0; j < boardSize; j++) {
                 if (board[i][j] == ' ') {
                     return false;
                 }
             }
         }
         return true;
     }

     public boolean makeMove(int move, char symbol) {
         int row = (move - 1) / boardSize;
         int col = (move - 1) % boardSize;

         if (isValidMove(row, col) && board[row][col] == ' ') {
             board[row][col] = symbol;
             return true;
         } else {
             return false;
         }
     }
     private boolean isValidMove(int row, int col) {
         return row >= 0 && row < boardSize && col >= 0 && col < boardSize && board[row][col] == ' ';
     }

     public void computerMove() {
         int row, col;

         do {
             row = (int) (Math.random() * boardSize);
             col = (int) (Math.random() * boardSize);
         } while (!isValidMove(row, col));

         System.out.println("Ruch komputera: wiersz " + (row + 1) + ", kolumna " + (col + 1));
         board[row][col] = 'O';
     }
     public static boolean checkWin(char symbol) {

         for (int i = 0; i < board.length; i++) {
             int rowCount = 0;
             int colCount = 0;
             for (int j = 0; j < board[i].length; j++) {
                 if (board[i][j] == symbol) {
                     rowCount++;
                 }
                 if (board[j][i] == symbol) {
                     colCount++;
                 }
             }
             if (rowCount == winCondition || colCount == winCondition) {
                 return true;
             }
         }


         int diagonalCount1 = 0;
         int diagonalCount2 = 0;
         for (int i = 0; i < board.length; i++) {
             if (board[i][i] == symbol) {
                 diagonalCount1++;
             }
             if (board[i][board.length - 1 - i] == symbol) {
                 diagonalCount2++;
             }
         }
         if (diagonalCount1 == winCondition || diagonalCount2 == winCondition) {
             return true;
         }

         return false;
     }

     public char[][] getBoard() {
         return board;
     }

 }

