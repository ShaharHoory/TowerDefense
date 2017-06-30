package guiComponents;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import entities.creeps.Creep;
import pace.Tickable;
import pace.Timer;
import utilities.Constants;
import utilities.Pair;

public class CreepsPresentation extends JComponent implements Tickable {

	public LinkedList<Creep> creeps;
	public LinkedList<Creep> creepsInLine;

	public CreepsPresentation(Pair[][] directionMatrix) {
		this.creeps = new LinkedList<Creep>();
		this.creepsInLine = new LinkedList<Creep>();
		setLocation(0, 0);
		setBounds(0, 0, Constants.BOARD_SIZE, Constants.BOARD_SIZE);
		setPreferredSize(new Dimension(Constants.BOARD_SIZE, Constants.BOARD_SIZE));
		setDoubleBuffered(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Creep creep : creeps) {
			ImageIcon creepIcon = creep.getImage();
			Image creepImage = creepIcon.getImage();
			g.drawImage(creepImage, (int) creep.actualLocation.x * Constants.BLOCK_SIZE,
					(int) creep.actualLocation.y * Constants.BLOCK_SIZE, Constants.CREEP_SIZE, Constants.CREEP_SIZE,
					this);
			System.out.println(creep.location.x + " , " + creep.location.y);
		}
	}

	@Override
	public void tickHappened() {
		repaint();
	}

	public void setCreepsInLine(LinkedList<Creep> toInit) {
		creepsInLine = toInit;

	}

}
