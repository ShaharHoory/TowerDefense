package towers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import creeps.Creep;
import towers.Tower.TYPE;
import utils.Board;
import utils.Game;
import utils.Tickable;
import utils.Timer;

public class GameTowers extends JComponent implements Tickable{
	LinkedList<Tower> towers;
	private HashMap<String, Integer> towersLeft;
	LinkedList<Creep> creeps;
	Tower visibleRangeTower;
	Board board;
	private int numOfTowers;
	
	
	public GameTowers(Board board , LinkedList<Creep> creeps){
		visibleRangeTower = null;
		towers = new LinkedList<>();
		towersLeft = new HashMap<>();
		this.creeps = creeps;
		this.board = board; 
		this.numOfTowers = 0;
		setSize(new Dimension(800, 800));
		setPreferredSize(new Dimension(800, 800));
	}
	
	@Override
	public void paint(Graphics g) {
		for (Tower tower : towers) {
			ImageIcon icon = tower.icon;
			Image image = icon.getImage();
			int x = tower.getX() * 25 -5;
            int y = tower.getY() * 25 -30; 
            g.drawImage(image , x , y , 35 ,60 , this);
            if(tower.equals(visibleRangeTower))
            	showTowerArea(g, tower);
		}
	}
	public void placeTower(Tower object) {
		towers.add(object);
		visibleRangeTower = object;
		String newStr = object.getClass().getName().substring(7).replace("T", " T");
		Integer i =getTowersLeft().get(newStr);
		getTowersLeft().put(newStr, i-1);
		numOfTowers++;
		repaint();
	}
	
	public void deleteTower(Tower t){
		towers.remove(t);
		String str = t.getClass().getName().substring(7).replace("T", " T");
		Integer i =getTowersLeft().get(str)+1;
		getTowersLeft().put(str, i);
		numOfTowers--;
	}
	
	public void showTowerArea(Graphics g , Tower t){
		int x = t.getX();
		int y = t.getY();
		int threatArea = t.getThreatArea();
		g.setColor(t.rangeColor);
		for(int i=-threatArea; i<=threatArea; i++){
			for(int j=-threatArea; j<=threatArea; j++){
				if (i!=0 || j!=0){
					if(x+threatArea>=0 && x+threatArea<= 32 && y+threatArea>=0 && y+threatArea<=32)
						g.drawRect((x+i)*25, (y+j)*25, 25, 25);
				}
			}
		}
	}

	public Tower getTowerInPlace(int xLoc, int yLoc) {
		for (Tower tower : towers) {
			if(tower.x == xLoc && tower.y == yLoc)
				return tower;
		}
		return null;
	}

	public HashMap<String, Integer> getTowersLeft() {
		return towersLeft;
	}

	public void setTowersLeft(HashMap<String, Integer> towersLeft) {
		this.towersLeft = towersLeft;
	}

	public Tower getVisibleRangeTower() {
		return visibleRangeTower;
	}

	public void setVisibleRangeTower(Tower visibleRangeTower) {
		this.visibleRangeTower = visibleRangeTower;
	}

	@Override
	public void tickHappened() {
		for (Tower tower : towers) {
			tower.timeToShoot-=tower.attackSpeed*Timer.NORMAL_TICK;
			if(tower.timeToShoot<=0){
				if(tower.type==TYPE.REGULAR){
					Creep target = selectTarget(tower);
					if(target!=null){
						tower.hit(target);
						tower.timeToShoot=1000;
						tower.icon = new ImageIcon(tower.shootingImage);
					}
					else{
						tower.icon = new ImageIcon(tower.towerImage);
					}
				}
				else{
					LinkedList<Creep> targets = selectsMultipleTargets(tower);
						for (Creep creep : targets) {
							tower.hit(creep);
							tower.timeToShoot=1000;
						}
						tower.icon = new ImageIcon(tower.shootingImage);
						if(targets.isEmpty())
							tower.icon = new ImageIcon(tower.towerImage);
				}
			}
			else{
				tower.icon = new ImageIcon(tower.towerImage);
			}
		}
	}

	private LinkedList<Creep> selectsMultipleTargets(Tower tower) {
		LinkedList<Creep> targets = new LinkedList<>();
		for (Creep creep : creeps) {
			if(isInRange(tower , creep))
				targets.add(creep);			
		}
		return targets;
	}

	private Creep selectTarget(Tower tower) {
		Creep toReturn = null;
		for (Creep creep : creeps) {
			if(isInRange(tower , creep)){
				if(toReturn==null)
					toReturn = creep;
				else if(toReturn.steps<creep.steps)
					toReturn = creep;
			}				
		}
		return toReturn;
	}

	private boolean isInRange(Tower tower, Creep creep) {
		int area = tower.threatArea;
		for(int i=-area; i<=area; i++){
			for(int j=-area; j<=area; j++){
				int xLocation = tower.getX()+i;
				int yLocation = tower.getY()+j;
				if(board.isInBoard(xLocation, yLocation))
					if((int)creep._x == xLocation && (int)creep._y==yLocation)
						return true;
			}
		}
		return false;
	}

	public int getNumOfTowers() {
		return numOfTowers;
	}
}
