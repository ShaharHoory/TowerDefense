package towers;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class SamTower extends Tower{

	public SamTower(int x , int y) {
		super(2, 2 , x , y);
		this.type = TYPE.ASSASIN;
		icon = new ImageIcon(this.getClass().getResource("/Sam Tower.png"));
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
