package creeps;

import javax.swing.ImageIcon;

import gameLayers.GameWindow;
import utils.Visitor;

public class Guli extends Creep {

	private final static int REDUCTION_PARAM_K = 10;
	
	public Guli(int x , int y) {
		super(1, new ImageIcon(GameWindow.class.getResource("/guli-1.png")), x , y , REDUCTION_PARAM_K);
		this.INIT_SPEED = 1;
		rightS = GameWindow.class.getResource("/guli-1.png");
		rightW = GameWindow.class.getResource("/guli-2.png");
		leftS = GameWindow.class.getResource("/guli-3.png");
		leftW = GameWindow.class.getResource("/guli-4.png");
	
	}

	@Override
	public void impact(Visitor v) {
		v.visit(this);
	}

}
