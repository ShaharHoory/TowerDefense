package creeps;

import javax.swing.ImageIcon;

import utils.GameWindow;
import utils.Visitor;

public class Mike extends Creep {

	private final static int REDUCTION_PARAM_K = 5;
	
	public Mike(int x , int y) {
		super(1, new ImageIcon(GameWindow.class.getResource("/mike-1.png")), x , y , REDUCTION_PARAM_K);
		INIT_SPEED=1;
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
