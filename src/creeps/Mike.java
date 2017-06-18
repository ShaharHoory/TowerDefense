package creeps;

import javax.swing.ImageIcon;

import utils.Visitor;

public class Mike extends Creep {

	private final static int INIT_SPEED = 1;
	private final static ImageIcon ICON = new ImageIcon("/sprites/mike-1.png");
	
	public Mike() {
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
