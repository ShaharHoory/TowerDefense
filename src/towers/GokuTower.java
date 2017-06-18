package towers;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class GokuTower extends Tower {

	public GokuTower() {
		super(2, 1);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/goku.png"));
	}

	@Override
	public void visit(Guli g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Knight k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Mike m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Naji n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}

}
