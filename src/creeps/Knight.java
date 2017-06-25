package creeps;

import javax.swing.ImageIcon;

import utils.GameWindow;
import utils.Visitor;

public class Knight extends Creep {

	private final static int INIT_SPEED = 1;
	private final static int REDUCTION_PARAM_K = 7;
	
	public Knight(int x , int y) {
		super(INIT_SPEED, new ImageIcon(GameWindow.class.getResource("/abir-1.png")), x , y ,REDUCTION_PARAM_K);
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
