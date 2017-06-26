package gameMap;

import utilities.*;

public class Board {
	private Pair[][] directionMatrix;
	private int startPositionX;
	private int startPositionY;

	public Board(Pair[][] directionMatrix, int startPositionX, int startPositionY) {
		super();
		this.directionMatrix = directionMatrix;
		this.startPositionX = startPositionX;
		this.startPositionY = startPositionY;
	}

	public Pair[][] getDirectionMatrix() {
		return directionMatrix;
	}

	public int getStartPositionX() {
		return startPositionX;
	}

	public int getStartPositionY() {
		return startPositionY;
	}

}
