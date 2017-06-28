package gameMap;

import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JPanel;

import utilities.Pair;

public class Board extends JPanel {
	private Pair[][] directionMatrix;
	private Point startPosition;

	public Board(Pair[][] directionMatrix) {
		this.directionMatrix = directionMatrix;

	}

	public Pair[][] getDirectionMatrix() {
		return directionMatrix;
	}

	public boolean[][] blocksPartition() {
		boolean[][] partition = new boolean[directionMatrix.length][directionMatrix[0].length];
		for (int i = 0; i < directionMatrix.length; i++) {
			for (int j = 0; j < directionMatrix[i].length; j++) {
				if (isFloor(i, j)) {
					partition[i][j] = true;
					if (j == 0)
						startPosition = new Point(j, i);

				} else
					partition[i][j] = false;
			}
		}
		return partition;
	}

	public boolean isFloor(int x, int y) {
		return directionMatrix[x][y].xInc != 0 || directionMatrix[x][y].yInc != 0;
	}

}
