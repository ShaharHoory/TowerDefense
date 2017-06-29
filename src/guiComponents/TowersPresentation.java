package guiComponents;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import entities.creeps.Creep;
import entities.towers.Tower;
import pace.Tickable;
import utilities.Constants;

public class TowersPresentation extends JComponent implements Tickable {

	LinkedList<Tower> towers;
	LinkedList<Creep> creeps;
	HashMap<String, Integer> towersAvailable;
	Tower onFocus;

	public TowersPresentation(LinkedList<Creep> creeps) {
		onFocus = null;
		towers = new LinkedList<Tower>();
		towersAvailable = new HashMap<String, Integer>();
		initiateTowersAvailable();
		this.creeps = creeps;
		setSize(new Dimension(Constants.BOARD_SIZE, Constants.BOARD_SIZE));
		// setPreferredSize(new Dimension(800, 800));
	}

	private void initiateTowersAvailable() {
		towersAvailable.put("Lava Tower", 3);
		towersAvailable.put("Arrow Tower", 3);
		towersAvailable.put("Poison Tower", 3);
		towersAvailable.put("Magic Tower", 3);
		towersAvailable.put("Sam Tower", 1);
		towersAvailable.put("Goku Tower", 1);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Tower tower : towers) {
			ImageIcon spriteIcon = tower.sprite;
			Image sprite = spriteIcon.getImage();
			int x = tower.location.x * Constants.BLOCK_SIZE - 5; // arbitiary
			int y = tower.location.y * Constants.BLOCK_SIZE - 30; // arbitiary
			g.drawImage(sprite, x, y, Constants.TOWER_HEIGHT, Constants.TOWER_WIDTH, this);
			if (tower == onFocus)// using == on purpose
				presentThreatArea(g, tower);

		}
	}

	public void presentThreatArea(Graphics g, Tower tower) {
		g.setColor(tower.onFocusColor);
		for (int i = -tower.threatArea; i < tower.threatArea; i++) {
			for (int j = -tower.threatArea; j < tower.threatArea; j++) {
				if (i != 0 || j != 0 && isOnBoard(tower))
					g.drawRect((tower.location.x + i) * Constants.BLOCK_SIZE,
							(tower.location.y + j) * Constants.BLOCK_SIZE, Constants.BLOCK_SIZE, Constants.BLOCK_SIZE);
			}
		}
	}

	private boolean isOnBoard(Tower tower) {
		return tower.location.x + tower.threatArea >= 0 && tower.location.x + tower.threatArea <= 32
				&& tower.location.y + tower.threatArea >= 0 && tower.location.y + tower.threatArea <= 32;
	}

	public void placeTower(Tower toPlace) {
		towers.add(toPlace);
		onFocus = toPlace;
		String className = getClass().getName();
		String key = className.substring(0, className.indexOf("Tower"));
		Integer currentTowersLeft = towersAvailable.get(key);
		towersAvailable.put(key, currentTowersLeft - 1);
	}

	public Tower getTowerAt(Point location) {
		for (Tower tower : towers) {
			if (tower.location.equals(location))
				return tower;
		}
		return null;
	}

	@Override
	public void tickHappened() {
		for (Tower tower : towers) {
			tower.tickHappened();
		}
	}

	public void setOnFocus(Tower onFocus) {
		this.onFocus = onFocus;
	}

}
