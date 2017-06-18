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
		g.setHp(g.getHp()-15);
	}

	@Override
	public void visit(Knight k) {
		k.setHp(k.getHp()-k.getPoisoningPower()*10);		
	}

	@Override
	public void visit(Mike m) {
		m.setHp(m.getHp()-15);		
	}

	@Override
	public void visit(Naji n) {
		n.setHp(n.getHp()-n.getPoisoningPower()*15);		
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
}
