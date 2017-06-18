package towers;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class FlyingDinoTower extends Tower {
	
	public FlyingDinoTower() {
		super(2, 1);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/dino-1.png"));
	}

	@Override
	public void visit(Guli g) {
		g.set_hp(g.get_hp()-15);		
	}

	@Override
	public void visit(Knight k) {
		k.set_hp(k.get_hp()-8);		
	}

	@Override
	public void visit(Mike m) {
		m.set_hp(m.get_hp()-10);
	}

	@Override
	public void visit(Naji n) {
		n.set_hp(n.get_hp()-11);
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
}
