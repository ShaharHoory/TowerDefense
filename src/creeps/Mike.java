package creeps;

import javax.swing.ImageIcon;

import gameLayers.GameWindow;
import utils.Visitor;

public class Mike extends Creep {

	private final static int REDUCTION_PARAM_K = 5;
	
	public Mike(int x , int y) {
		super(1, new ImageIcon(GameWindow.class.getResource("/mike-1.png")), x , y , REDUCTION_PARAM_K);
		INIT_SPEED=1;
		rightS = GameWindow.class.getResource("/mike-1.png");
		rightW = GameWindow.class.getResource("/mike-2.png");
		leftS = GameWindow.class.getResource("/mike-3.png");
		leftW = GameWindow.class.getResource("/mike-4.png");
		
	}

	@Override
	public void impact(Visitor v) {
		v.visit(this);
	}

}
