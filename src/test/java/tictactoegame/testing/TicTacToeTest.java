package tictactoegame.testing;

import org.example.tictactoegame.TicTacToeGame;
import org.example.tictactoegame.RuchNiedozwolonyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    @Test
    public void testOWinsInRows() {
//        Give
        TicTacToeGame game = new TicTacToeGame(3, 3);
//        When
        game.makeMove(1, 'O');
        game.makeMove(4, 'X');
        game.makeMove(2, 'O');
        game.makeMove(5, 'X');
        game.makeMove(3, 'O');
//        Then
        assertTrue(game.checkWin('O'));
    }

    @Test
    public void testOWinsInColumns() {
//        Give
        TicTacToeGame game = new TicTacToeGame(3, 3);
//        When
        game.makeMove(1, 'O');
        game.makeMove(8, 'X');
        game.makeMove(4, 'O');
        game.makeMove(5, 'X');
        game.makeMove(7, 'O');
//        Then
        assertTrue(game.checkWin('O'));
    }

    @Test
    public void testOWinsInDiagonals() {
//        Give
        TicTacToeGame game = new TicTacToeGame(3, 3);
//        When
        game.makeMove(1, 'O');
        game.makeMove(2, 'X');
        game.makeMove(5, 'O');
        game.makeMove(4, 'X');
        game.makeMove(9, 'O');
//        Then
        assertTrue(game.checkWin('O'));
    }

    @Test
    public void testXWinsInRows() {
//        Give
        TicTacToeGame game = new TicTacToeGame(3, 3);
//        When
        game.makeMove(1, 'X');
        game.makeMove(4, 'O');
        game.makeMove(2, 'X');
        game.makeMove(5, 'O');
        game.makeMove(3, 'X');
//        Then
        assertTrue(game.checkWin('X'));
    }

    @Test
    public void testXWinsInColumns() {
//        Give
        TicTacToeGame game = new TicTacToeGame(3, 3);
//        When
        game.makeMove(1, 'X');
        game.makeMove(5, 'O');
        game.makeMove(4, 'X');
        game.makeMove(8, 'O');
        game.makeMove(7, 'X');
//        Then
        assertTrue(game.checkWin('X'));
    }

    @Test
    public void testXWinsInDiagonals() {
//        Give
        TicTacToeGame game = new TicTacToeGame(3, 3);
//        When
        game.makeMove(1, 'X');
        game.makeMove(2, 'O');
        game.makeMove(5, 'X');
        game.makeMove(4, 'O');
        game.makeMove(9, 'X');
//        Then
        assertTrue(game.checkWin('X'));
    }

    @Test
    public void testDraw() {
//        Give
        TicTacToeGame game = new TicTacToeGame(3, 3);
//        When
        game.makeMove(1, 'X');
        game.makeMove(2, 'O');
        game.makeMove(3, 'X');
        game.makeMove(5, 'O');
        game.makeMove(4, 'X');
        game.makeMove(6, 'O');
        game.makeMove(8, 'X');
        game.makeMove(7, 'O');
        game.makeMove(9, 'X');
//        Then
        assertTrue(game.isBoardFull());
        assertFalse(game.checkWin('X'));
        assertFalse(game.checkWin('O'));
    }

    @Test
    public void testInvalidMove() {
        TicTacToeGame game = new TicTacToeGame(3, 3);
        assertTrue(game.makeMove(1, 'X'));
        assertFalse(game.makeMove(1, 'O'));
    }
}
