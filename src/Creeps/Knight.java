package Creeps;

import javax.swing.ImageIcon;

import Utils.Visitor;
import agents.Creep;

public class Knight extends Creep {

	private final static int INIT_SPEED = 1;
	private final static ImageIcon ICON = new ImageIcon("/sprites/abir-1.png");
	
	public Knight() {
		super(INIT_SPEED, ICON);
	}

	@Override
	public void impact(Visitor v) {
		v.visit(this);
	}

}
