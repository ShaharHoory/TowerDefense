package creeps;

import javax.swing.ImageIcon;

import agents.Creep;
import utils.Visitor;

public class Naji extends Creep {

	private final static int INIT_SPEED = 2;
	private final static int REDUCTION_PARAM_K = 5;
	
	public Naji() {
		super(INIT_SPEED, new ImageIcon("/sprites/naji-1.png"), REDUCTION_PARAM_K);
	}

	@Override
	public void impact(Visitor v) {
		v.visit(this);
	}

	@Override
	public void slow(int seconds) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}

}
