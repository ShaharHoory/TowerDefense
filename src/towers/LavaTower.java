package towers;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class LavaTower extends Tower{
	
	public LavaTower() {
		super(1, 1);
		this.type = TYPE.ASSASIN;
		icon = new ImageIcon(this.getClass().getResource("/lava.png"));
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

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
}
