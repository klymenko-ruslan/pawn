package com.klymenko.pawn;

public final class Board {
	
	public static final int DEFAULT_BOARD_SIZE = 10;
	
	public static final int DEFAULT_STRAIGHT_STEP = 3;
	
	public static final int DEFAULT_DIAGONAL_STEP = 2;
	
	private final int [] [] board;
	
	private final int boardSize;
	
	private final int cellsAmount;
	
	private final int straightStep;
	
	private final int diagonalStep;
	
	private int cellsVisited;
	
	public Board() {
		this(DEFAULT_BOARD_SIZE, DEFAULT_STRAIGHT_STEP, DEFAULT_DIAGONAL_STEP);
	}
	
	public Board(int boardSize, int straightStep, int diagonalStep) {
		this.boardSize = boardSize;
		board = new int[boardSize][boardSize];
		cellsAmount = boardSize * boardSize;
		this.straightStep = straightStep;
		this.diagonalStep = diagonalStep;
	}
	
	public boolean shouldBeVisited(GameCell cell) {
		return cell.getY() < boardSize && 
			   cell.getX() < boardSize &&
			   board[cell.getY()][cell.getX()] == 0;
	}
	
	public void visit(GameCell cell) {
		if(shouldBeVisited(cell)) {
			board[cell.getY()][cell.getX()] = ++cellsVisited;
		}
	}
	
	public boolean isBoardFullyVisited() {
		return cellsVisited == cellsAmount;
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	public int getStraightStep() {
		return straightStep;
	}
	
	public int getDiagonalStep() {
		return diagonalStep;
	}
	
	@Override
	public String toString() {
		StringBuilder result =  new StringBuilder();
		for(int row = 0; row < board.length; row ++) {
			for(int column = 0; column < board[0].length; column++) {
				result.append(board[row][column])
				      .append(" ");
			}
			result.append("\n");
		}
		return result.toString();
	}
}
