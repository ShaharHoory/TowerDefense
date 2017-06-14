package Creeps;

import javax.swing.ImageIcon;

import Utils.Visitor;
import agents.Creep;

public class Guli extends Creep {

	private final static int INIT_SPEED = 1;
	private final static ImageIcon ICON = new ImageIcon("/sprites/guli-1.png");
	
	public Guli() {
		super(INIT_SPEED, ICON);
	}

	@Override
	public void impact(Visitor v) {
		v.visit(this);
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}

}
