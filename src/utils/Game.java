package utils;

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

import creeps.GameCreeps;
import towers.ChooseTowerDialog;
import towers.GameTowers;
import towers.Tower;

public class Game extends JPanel implements MouseListener {

	protected Timer timer;
	protected Board _board;
	protected int _lives;
	protected int _currWave;
	protected int _passedFinishPointCreeps;
	protected int _deadCreeps;	
	protected boolean _isWave;
	protected GameTowers gameTowers;
	protected GameCreeps gameCreeps;
	
	public Game(Board board , Timer timer) {
		super(new BorderLayout());
		_lives = 20;
		_currWave = 0; // it's 0 until the user pushes the nextWave button
		_passedFinishPointCreeps = 0;
		_deadCreeps = 0;
		_board = board;	
		_isWave = false;
		gameCreeps = new GameCreeps(_board._directionsMat , timer);
		gameTowers = new GameTowers(_board , gameCreeps.getCreeps());		
		addTowerTypes();
		this.add(_board, BorderLayout.CENTER);
		this.setVisible(true);
		_board.addMouseListener(this);
	}
	
	public boolean lost() {
		return _lives <= 0;
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
			if(!_isWave){
				if(_board._directionsMat[yLoc][xLoc]._x!=0 || _board._directionsMat[yLoc][xLoc]._y!=0)
					JOptionPane.showMessageDialog(this, "You may put towers only on grass tiles!", "Error" , 0);
				else{
					ChooseTowerDialog dialog = new ChooseTowerDialog(this , xLoc , yLoc);
				}	
			}
		}		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}
