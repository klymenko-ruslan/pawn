package com.klymenko.pawn;

public class Client {
	
	private static final String ILLEGAL_ARGUMENT_MESSAGE = "Please run program with such parameters: 1) language name. Possible values: java, scala 2) positive int, represents x of start point. 3) positive int, represents y of start point.";
	
	public static void main(String [] args) {
		if(args.length == 3) {
			try {
				String language = args[0];
				int x = Integer.parseInt(args[1]);
				int y = Integer.parseInt(args[2]);
				if(language.equals(Language.java.name())) {
					executeJava(x, y);
				} else if(language.equals(Language.scala.name())) {
					executeScala(x, y);
				} else {
					throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
				}
			} catch(NumberFormatException e) {
				throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
			}
		} else {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
	}

	private static void executeJava(int x, int y) {
		GameCell startCell = new GameCell(x, y);
		Board board = new Board(10, 3, 2);
		UniqueMovementAlgorithm.findPath(board, startCell);
		System.out.println(board);
	}

	private static void executeScala(int x, int y) {
		com.klymenko.pawn.scala.GameCell startCell = new com.klymenko.pawn.scala.GameCell(x, y);
		com.klymenko.pawn.scala.Board board = new com.klymenko.pawn.scala.Board(10, 3, 2);
		com.klymenko.pawn.scala.UniqueMovementAlgorithm.findPath(board, startCell);
		System.out.println(board);
	}
}
enum Language {
	java, scala
}