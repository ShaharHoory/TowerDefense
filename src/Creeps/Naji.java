package Creeps;

import Utils.Visitor;
import agents.Creep;

public class Naji extends Creep {

	private final static int INIT_SPEED = 2;
	
	public Naji() {
		super(INIT_SPEED);
	}

	@Override
	public void impact(Visitor v) {
		v.visit(this);
	}

}
