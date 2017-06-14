package towers;

import javax.swing.ImageIcon;

import agents.Creep;
import agents.Tower;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class PoisonTower extends Tower{
	public PoisonTower() {
		super(1, 1);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/poison.png"));
	}

	@Override
	public void visit(Guli g) {
		g.set_hp(g.get_hp()-20);		
	}

	@Override
	public void visit(Knight k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Mike m) {
		return;		
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
