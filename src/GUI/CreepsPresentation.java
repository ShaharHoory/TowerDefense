package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JComponent;

import entities.creeps.Creep;
import pace.Tickable;
import utilities.Constants;

public class CreepsPresentation extends JComponent implements Tickable {

	private LinkedList<Creep> creeps;

	public CreepsPresentation(LinkedList<Creep> creeps) {
		this.creeps = creeps;
		setLocation(0, 0);
		setBounds(0, 0, Constants.BOARD_SIZE, Constants.BOARD_SIZE);
		setPreferredSize(new Dimension(Constants.BOARD_SIZE, Constants.BOARD_SIZE));
		setDoubleBuffered(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Creep creep : creeps) {

		}
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub

	}
}
