package com.klymenko.pawn;

public class Client {
	
	private static final String ILLEGAL_ARGUMENT_MESSAGE = "Please run program with such parameters: 1) positive int, represents x of start point. 2) positive int, represents y of start point.";
	
	public static void main(String [] args) {
		if(args.length == 2) {
			try {
				int x = Integer.parseInt(args[0]);
				int y = Integer.parseInt(args[1]);
				GameCell startCell = new GameCell(x,y);
				Board board = new Board();
				UniqueMovementAlgorithm.findPath(board, startCell);
				System.out.println(board);
			} catch(NumberFormatException e) {
				throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
			}
		} else {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		
	}
}
