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
	
	public void createBoard(){
		
	}

}
