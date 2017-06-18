package towers;

import javax.swing.ImageIcon;

import creeps.Creep;
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
		g.setHp(g.getHp()-25);		
	}

	@Override
	public void visit(Knight k) {
		k.setHp(k.getHp()-k.getPoisoningPower()*30);		
	}

	@Override
	public void visit(Mike m) {
		m.setHp(m.getHp()-10);		
	}

	@Override
	public void visit(Naji n) {
		n.setHp(n.getHp()-n.getPoisoningPower()*10);		
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
	
}
