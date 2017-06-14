package towers;

import javax.swing.ImageIcon;

import agents.Creep;
import agents.Tower;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class MagicTower extends Tower {
	
	public MagicTower() {
		super(1, 1);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/magic.png"));
	}

	@Override
	public void visit(Guli g) {
		g.set_hp(g.get_hp()-25);		
	}

	@Override
	public void visit(Knight k) {
		k.set_hp(k.get_hp()-30);		
	}

	@Override
	public void visit(Mike m) {
		m.set_hp(m.get_hp()-10);		
	}

	@Override
	public void visit(Naji n) {
		n.set_hp(n.get_hp()-10);		
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
	
}
