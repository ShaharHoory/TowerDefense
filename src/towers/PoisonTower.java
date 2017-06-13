package towers;

import javax.swing.ImageIcon;

import Creeps.Guli;
import Creeps.Knight;
import Creeps.Mike;
import Creeps.Naji;
import agents.Creep;
import agents.Tower;

public class PoisonTower extends Tower{
	public PoisonTower(int threatArea, int attackSpeed) {
		super(threatArea, attackSpeed);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/poison"));
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
}
