package utils;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import creeps.Creep;
import towers.ChooseTowerDialog;

public class Game extends JPanel implements MouseListener {

	private Board _board;
	protected int _lives;
	protected int _currWave;
	protected int _passedFinishPointCreeps;
	protected int _deadCreeps;
	protected HashMap<String, Integer> towersLeft;
	private boolean _isWvae;
	
	public Game(Board board) {
		super(new BorderLayout());
		_lives = 20;
		_currWave = 0; // it's 0 until the user pushes the nextWave button
		_passedFinishPointCreeps = 0;
		_deadCreeps = 0;
		_board = board;		
		addTowerTypes();
		this.add(_board, BorderLayout.CENTER);
		this.setVisible(true);
		_board.addMouseListener(this);
	}
	
	private boolean lost() {
		return _lives <= 0;
	}
	
	private void moveCreeps() {
		Pair[][] directionsMat = _board.getDirectionsMat();
		List<Creep>[][] creepsLoc = _board.getCreepsLoc();
		
		for(int i=0; i<creepsLoc.length; i++)
			for(int j=0; j<creepsLoc[i].length; i++) {
				int numOfCreeps = creepsLoc[i][j].size();
				List<Creep> tCreeps = creepsLoc[i][j].subList(0, numOfCreeps); //a cloned list
				if (directionsMat[i][j].outOfPath()) continue;
				for(Creep creep: creepsLoc[i][j]) { //for every creep in each cell
					if(directionsMat[i][j].isRight()) {
						tCreeps.remove(creep);//deleting the creep from the current cell
						creepsLoc[i][j+1].add(creep); //moving the creep to the next cell
					}
					else if(directionsMat[i][j].isLeft()) {
						tCreeps.remove(creep);//deleting the creep from the current cell
						creepsLoc[i][j-1].add(creep); //moving the creep to the next cell
					}
					else if(directionsMat[i][j].isUp()) {
						tCreeps.remove(creep);//deleting the creep from the current cell
						creepsLoc[i-1][j].add(creep); //moving the creep to the next cell
					}
					else { //down
						tCreeps.remove(creep);//deleting the creep from the current cell
						creepsLoc[i+1][j].add(creep); //moving the creep to the next cell
					}		
				}
				creepsLoc[i][j] = tCreeps;
				_board.paintCreeps(getGraphics()); //�� ����� ����� ���� �������� ������������ ����� ����� ����������� ������ �� ����
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int yLoc = e.getY()/25;
		int xLoc = e.getX()/25;
		if(_board.getDirectionsMat()[yLoc][xLoc]._x!=0 || _board.getDirectionsMat()[yLoc][xLoc]._y!=0)
			JOptionPane.showMessageDialog(this, "You may put towers only on grass tiles!", "Error" , 0);
		else if(_board.getTowersLoc()[yLoc][xLoc]!=null){ // if user clicks on an existing tower 
			_board.showTowerArea(getGraphics(), _board.getTowersLoc()[yLoc][xLoc], xLoc, yLoc);
		}
		else{
			ChooseTowerDialog dialog = new ChooseTowerDialog(this);						
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
		towersLeft = new HashMap<>();
		towersLeft.put("Lava Tower", 3);
		towersLeft.put("Arrow Tower", 3);
		towersLeft.put("Poison Tower", 3);
		towersLeft.put("Magic Tower", 3);
		towersLeft.put("Sam Tower", 1);
		towersLeft.put("Goku Tower", 1);
		
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

	public HashMap<String, Integer> getTowersLeft() {
		return towersLeft;
	}
}
