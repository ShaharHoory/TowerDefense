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
}
