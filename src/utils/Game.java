package utils;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public class Game extends JPanel {

	private Board _board;
	protected int _lives;
	protected int _currWave;
	protected int _passedFinishPointCreeps;
	protected int _deadCreeps;
	
	public Game(Board board) {
		super(new BorderLayout());
		_lives = 20;
		_currWave = 0; // it's 0 until the user pushes the nextWave button
		_passedFinishPointCreeps = 0;
		_deadCreeps = 0;
		_board = board;		
		this.add(_board, BorderLayout.CENTER);
		this.setVisible(true);	
	}
	
	private boolean lost() {
		return _lives <= 0;
	}
}
