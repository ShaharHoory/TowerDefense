package Creeps;

import Utils.Visitor;
import agents.Creep;

public class Knight extends Creep {

	private final static int INIT_SPEED = 1;
	
	public Knight() {
		super(INIT_SPEED);
	}

	@Override
	public void impact(Visitor v) {
		v.visit(this);
	}

}
