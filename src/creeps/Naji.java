package creeps;

import javax.swing.ImageIcon;

import utils.Visitor;

public class Naji extends Creep {

	private final static int INIT_SPEED = 2;
	private final static ImageIcon ICON = new ImageIcon(Creep.class.getResource("/naji-1.png"));
	
	public Naji() {
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
