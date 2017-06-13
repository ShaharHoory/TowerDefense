package towers;

import javax.swing.ImageIcon;

import Creeps.Guli;
import Creeps.Knight;
import Creeps.Mike;
import Creeps.Naji;
import agents.Creep;
import agents.Tower;

public class LavaTower extends Tower{
	
	public LavaTower(int threatArea, int attackSpeed) {
		super(threatArea, attackSpeed);
		this.type = TYPE.ASSASIN;
		icon = new ImageIcon(this.getClass().getResource("/lava"));
	}

	@Override
	public void visit(Guli g) {
		g.set_hp(g.get_hp()-15);
	}

	@Override
	public void visit(Knight k) {
		k.set_hp(k.get_hp()-10);		
	}

	@Override
	public void visit(Mike m) {
		m.set_hp(m.get_hp()-15);		
	}

	@Override
	public void visit(Naji n) {
		n.set_hp(n.get_hp()-15);		
	}
}
