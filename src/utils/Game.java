package utils;

public class Game {

	private Board _board;
	protected int _lives;
	protected int _currWave;
	
	public Game(Pair[][] directionsMat) {
		_lives = 20;
		_currWave = 0; // it's 0 until the user pushes the nextWave button
		_board = new Board(directionsMat);
	}
	
	private boolean lost() {
		return _lives <= 0;
	}
}
