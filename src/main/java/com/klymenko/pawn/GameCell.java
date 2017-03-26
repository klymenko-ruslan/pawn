package com.klymenko.pawn;

public final class GameCell {
	
	private final int x;
	private final int y;
	
	public GameCell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
