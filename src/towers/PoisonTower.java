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
		g.setHp(g.getHp()-20);		
	}

	@Override
	public void visit(Knight k) {
		k.setPoisoningPower(2);
		//TODO: return poisoning power to be 1 after 5 seconds
		
	}

	@Override
	public void visit(Mike m) {
		return;		
	}

	@Override
	public void visit(Naji n) {
		n.setPoisoningPower(1.5);
		//TODO: return poisoning power to be 1 after 5 seconds
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
}
