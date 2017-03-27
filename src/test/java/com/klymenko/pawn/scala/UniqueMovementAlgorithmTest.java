package com.klymenko.pawn.scala;

import org.junit.Assert;
import org.junit.Test;


public class UniqueMovementAlgorithmTest {

    @Test
    public void testDefaultBoardMiddle() {
        Board board = new Board(10, 3 , 2);
        GameCell gameCell = new GameCell(Board.DEFAULT_BOARD_SIZE() / 2, Board.DEFAULT_BOARD_SIZE() / 2);
        Assert.assertFalse(board.isBoardFullyVisited());
        UniqueMovementAlgorithm.findPath(board, gameCell);
        Assert.assertTrue(board.isBoardFullyVisited());
    }

    @Test
    public void testDefaultBoardNorthWest() {
        Board board = new Board(10, 3, 2);
        GameCell gameCell = new GameCell(0,0);
        Assert.assertFalse(board.isBoardFullyVisited());
        UniqueMovementAlgorithm.findPath(board, gameCell);
        Assert.assertTrue(board.isBoardFullyVisited());
    }

    @Test
    public void testDefaultBoardNorthEast() {
        Board board = new Board(10, 3, 2);
        GameCell gameCell = new GameCell(Board.DEFAULT_BOARD_SIZE() - 1, 0);
        Assert.assertFalse(board.isBoardFullyVisited());
        UniqueMovementAlgorithm.findPath(board, gameCell);
        Assert.assertTrue(board.isBoardFullyVisited());
    }

    @Test
    public void testDefaultBoardSouthWest() {
        Board board = new Board(10, 3, 2);
        GameCell gameCell = new GameCell(0,Board.DEFAULT_BOARD_SIZE() - 1);
        Assert.assertFalse(board.isBoardFullyVisited());
        UniqueMovementAlgorithm.findPath(board, gameCell);
        Assert.assertTrue(board.isBoardFullyVisited());
    }

    @Test
    public void testDefaultBoardSouthEast() {
        Board board = new Board(10, 3, 2);
        GameCell gameCell = new GameCell(Board.DEFAULT_BOARD_SIZE() - 1, Board.DEFAULT_BOARD_SIZE() - 1);
        Assert.assertFalse(board.isBoardFullyVisited());
        UniqueMovementAlgorithm.findPath(board, gameCell);
        Assert.assertTrue(board.isBoardFullyVisited());
    }
}
