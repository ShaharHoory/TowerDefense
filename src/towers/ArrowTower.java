package towers;

import javax.swing.ImageIcon;

import Creeps.Guli;
import Creeps.Knight;
import Creeps.Mike;
import Creeps.Naji;
import agents.Creep;
import agents.Tower;

public class ArrowTower extends Tower{
	 public ArrowTower () {
		super(2, 2);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/arrow.png"));
	}

	@Override
	public void visit(Guli g) {
		g.set_hp(g.get_hp()-15);		
	}

	@Override
	public void visit(Knight k) {
		return;
	}

	@Override
	public void visit(Mike m) {
		m.set_hp(m.get_hp()-30);		
	}

	@Override
	public void visit(Naji n) {
		n.set_hp(n.get_hp()-30);	
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
}
