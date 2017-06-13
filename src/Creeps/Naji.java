package Creeps;

import javax.swing.ImageIcon;

import Utils.Visitor;
import agents.Creep;

public class Naji extends Creep {

	private final static int INIT_SPEED = 2;
	private final static ImageIcon ICON = new ImageIcon("/sprites/naji-1.png");
	
	public Naji() {
		super(INIT_SPEED, ICON);
	}

	@Override
	public void impact(Visitor v) {
		v.visit(this);
	}

}
