package towers;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class ArrowTower extends Tower{
	 public ArrowTower () {
		super(2, 2);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/arrow.png"));
	}

	@Override
	public void visit(Guli g) {
		g.setHp(g.getHp()-15);		
	}

	@Override
	public void visit(Knight k) {
		return;
	}

	@Override
	public void visit(Mike m) {
		m.setHp(m.getHp()-30);		
	}

	@Override
	public void visit(Naji n) {
		n.setHp(n.getHp()-n.getPoisoningPower()*30);	
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
}
