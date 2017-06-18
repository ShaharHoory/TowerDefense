package creeps;

import javax.swing.ImageIcon;

import utils.Visitor;

public class Guli extends Creep {

	private final static int INIT_SPEED = 1;
	private final static int REDUCTION_PARAM_K = 10;
	
	public Guli() {
		super(INIT_SPEED, new ImageIcon("/sprites/guli-1.png"), REDUCTION_PARAM_K);
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
