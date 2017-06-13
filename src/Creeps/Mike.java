package Creeps;

import Utils.Visitor;
import agents.Creep;

public class Mike extends Creep {

	private final static int INIT_SPEED = 1;
	
	public Mike() {
		super(INIT_SPEED);
	}

	@Override
	public void impact(Visitor v) {
		v.visit(this);
	}

}
