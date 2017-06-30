package gameLayers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import timer.Timer;
import towers.Tower;
import windows.ChooseTowerDialog;

public class Game extends JPanel implements MouseListener {

	private Timer timer;
	protected Board _board;
	private int _lives;
	private int _currWave;
	private int _passedFinishPointCreeps;
	private int _deadCreeps;	
	private boolean _isWave;
	protected GameTowers gameTowers;
	private GameCreeps gameCreeps;
	
	public Game(Board board , Timer timer) {
		super(new BorderLayout());
		set_lives(20);
		set_currWave(0); // it's 0 until the user pushes the nextWave button
		set_passedFinishPointCreeps(0);
		set_deadCreeps(0);
		_board = board;	
		set_isWave(false);
		this.setTimer(timer);
		setGameCreeps(new GameCreeps(_board._directionsMat , timer));
		gameTowers = new GameTowers(_board , getGameCreeps().getCreeps());		
		addTowerTypes();
		this.add(_board, BorderLayout.CENTER);
		this.setVisible(true);
		_board.addMouseListener(this);
	}
	
	public boolean lost() {
		return get_lives() <= 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int yLoc = e.getY()/25;
		int xLoc = e.getX()/25;
		Tower location = gameTowers.getTowerInPlace(xLoc , yLoc);
		if(location!=null){ // if user clicks on an existing tower 			
			gameTowers.setVisibleRangeTower(location);
			gameTowers.repaint();
		}
		else{
			if(!is_isWave()){
				if(_board._directionsMat[yLoc][xLoc].get_x()!=0 || _board._directionsMat[yLoc][xLoc].get_y()!=0)
					JOptionPane.showMessageDialog(this, "You may put towers only on grass tiles!", "Error" , 0);
				else{
					ChooseTowerDialog dialog = new ChooseTowerDialog(this , xLoc , yLoc);
				}	
			}
			else{
				gameTowers.setVisibleRangeTower(null);
			}
		}		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void addTowerTypes(){
		gameTowers.setTowersLeft(new HashMap<>());
		gameTowers.getTowersLeft().put("Lava Tower", 3);
		gameTowers.getTowersLeft().put("Arrow Tower", 3);
		gameTowers.getTowersLeft().put("Poison Tower", 3);
		gameTowers.getTowersLeft().put("Magic Tower", 3);
		gameTowers.getTowersLeft().put("Sam Tower", 1);
		gameTowers.getTowersLeft().put("Goku Tower", 1);
		
	}
	
	public int getNumOfMinutes() {
		String time = getTimer().toString();
		int minutesIndex = time.indexOf(':');
		String minutesString = time.substring(0, minutesIndex);
		return Integer.parseInt(minutesString);
	}

	public Board get_board() {
		return _board;
	}

	public int get_lives() {
		return _lives;
	}

	public int get_currWave() {
		return _currWave;
	}

	public int get_passedFinishPointCreeps() {
		return _passedFinishPointCreeps;
	}

	public int get_deadCreeps() {
		return _deadCreeps;
	}

	public void set_board(Board _board) {
		this._board = _board;
	}

	public GameTowers getGameTowers() {
		return gameTowers;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public boolean is_isWave() {
		return _isWave;
	}

	public void set_isWave(boolean _isWave) {
		this._isWave = _isWave;
	}

	public void set_deadCreeps(int _deadCreeps) {
		this._deadCreeps = _deadCreeps;
	}

	public GameCreeps getGameCreeps() {
		return gameCreeps;
	}

	public void setGameCreeps(GameCreeps gameCreeps) {
		this.gameCreeps = gameCreeps;
	}

	public void set_currWave(int _currWave) {
		this._currWave = _currWave;
	}

	public void set_lives(int _lives) {
		this._lives = _lives;
	}

	public void set_passedFinishPointCreeps(int _passedFinishPointCreeps) {
		this._passedFinishPointCreeps = _passedFinishPointCreeps;
	}
}
