package game;

import java.awt.Point;
import java.util.Arrays;

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
				partition[i][j] = isFloor(i, j);
				if (partition[i][j] && i == 0){
					startPosition = new Point(i, j);
					System.out.println("bla");
				}
			}
		}
		return partition;
	}

	public boolean isFloor(int x, int y) {
		return directionMatrix[y][x].xInc != 0 || directionMatrix[y][x].yInc != 0;
	}

	public boolean isInBoard(Point location) {
		return location.x < 32 && location.x >= 0 && location.y >= 0 && location.y < 32;

	}

	public Point getStartPosition() {
		return startPosition;
	}
	@Override
	public String toString() {
		return "Board [directionMatrix=" + Arrays.deepToString(directionMatrix) + ", startPosition=" + startPosition + "]";
	}
	
	

}
