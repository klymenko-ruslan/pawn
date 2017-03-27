package com.klymenko.pawn;

import java.util.LinkedList;
import java.util.List;

public class UniqueMovementAlgorithm {
	
	public static void findPath(Board board, GameCell currentCell) {
		if(board.shouldBeVisited(currentCell)) {
			board.visit(currentCell);
			for(GameCell availableCell : getAvailableCells(currentCell, board)) {
				if(board.shouldBeVisited(availableCell)) {
					findPath(board, availableCell);
				}
			}
		}
	}
	
	private static List<GameCell> getAvailableCells(GameCell currentCell, Board board) {
		List<GameCell> availableCells = new LinkedList<>();
		addNorthCell(availableCells, currentCell, board);
		addSouthCell(availableCells, currentCell, board);
		addWestCell(availableCells, currentCell, board);
		addEastCell(availableCells, currentCell, board);
		addNorthWestCell(availableCells, currentCell, board);
		addNorthEastCell(availableCells, currentCell, board);
		addSouthWestCell(availableCells, currentCell, board);
		addSouthEastCell(availableCells, currentCell, board);
		return availableCells;
	}
	private static void addNorthCell(List<GameCell> availableCells, GameCell currentCell, Board board) {
		if(currentCell.getY() - board.getStraightStep() >= 0) {
			availableCells.add(new GameCell(currentCell.getX(), currentCell.getY() - board.getStraightStep()));
		}
	}
	private static void addSouthCell(List<GameCell> availableCells, GameCell currentCell, Board board) {
		if(currentCell.getY() + board.getStraightStep() < board.getBoardSize()) {
			availableCells.add(new GameCell(currentCell.getX(), currentCell.getY() + board.getStraightStep()));
		}
	}
	private static void addWestCell(List<GameCell> availableCells, GameCell currentCell, Board board) {
		if(currentCell.getX() - board.getStraightStep() >= 0) {
			availableCells.add(new GameCell(currentCell.getX() - board.getStraightStep(), currentCell.getY()));
		}
	}
	private static void addEastCell(List<GameCell> availableCells, GameCell currentCell, Board board) {
		if(currentCell.getX() + board.getStraightStep() < board.getBoardSize()) {
			availableCells.add(new GameCell(currentCell.getX() + board.getStraightStep(), currentCell.getY()));
		}
	}
	private static void addNorthWestCell(List<GameCell> availableCells, GameCell currentCell, Board board) {
		if(currentCell.getX() + board.getDiagonalStep() < board.getBoardSize() &&
		   currentCell.getY() - board.getDiagonalStep() >= 0) {
			availableCells.add(new GameCell(currentCell.getX() + board.getDiagonalStep(), currentCell.getY() - board.getDiagonalStep()));
		}
	}
	private static void addNorthEastCell(List<GameCell> availableCells, GameCell currentCell, Board board) {
		if(currentCell.getX() - board.getDiagonalStep() >= 0 &&
		   currentCell.getY() - board.getDiagonalStep() >= 0) {
			availableCells.add(new GameCell(currentCell.getX() - board.getDiagonalStep(), currentCell.getY() - board.getDiagonalStep()));
		}
	}
	private static void addSouthWestCell(List<GameCell> availableCells, GameCell currentCell, Board board) {
		if(currentCell.getX() + board.getDiagonalStep() < board.getBoardSize() &&
		   currentCell.getY() + board.getDiagonalStep() < board.getBoardSize()) {
			availableCells.add(new GameCell(currentCell.getX() + board.getDiagonalStep(), currentCell.getY() + board.getDiagonalStep()));
		}
	}
	private static void addSouthEastCell(List<GameCell> availableCells, GameCell currentCell, Board board) {
		if(currentCell.getX() - board.getDiagonalStep() >= 0 &&
		   currentCell.getY() + board.getDiagonalStep() < board.getBoardSize()) {
			availableCells.add(new GameCell(currentCell.getX() - board.getDiagonalStep(), currentCell.getY() + board.getDiagonalStep()));
		}
	}
}
