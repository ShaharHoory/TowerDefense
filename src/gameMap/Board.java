package gameMap;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import utilities.*;

public class Board extends JPanel {
	private Pair[][] directionMatrix;
	private int startPositionX;
	private int startPositionY;

	public Board(Pair[][] directionMatrix, int startPositionX, int startPositionY) {

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

	public boolean[][] blocksPartition() {
		boolean[][] partition = new boolean[directionMatrix.length][directionMatrix[0].length];
		for (int i = 0; i < directionMatrix.length; i++) {
			for (int j = 0; j < directionMatrix[i].length; j++) {
				if (isFloor(i, j))
					partition[i][j] = true;
				else
					partition[i][j] = false;
			}
		}
		return partition;
	}

	public boolean isFloor(int x, int y) {
		return directionMatrix[x][y].xInc != 0 || directionMatrix[x][y].yInc != 0;
	}

}
