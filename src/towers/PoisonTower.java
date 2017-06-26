package towers;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;
import utils.GameWindow;

public class PoisonTower extends Tower{
	public PoisonTower(int x , int y) {
		super(1, 1 , x , y);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(GameWindow.class.getResource("/Poison Tower.png"));
	}

	@Override
	public void visit(Guli g) {
		g.setHp(g.getHp()-20);		
	}

	@Override
	public void visit(Knight k) {
		k.setPoisoningPower(2);
		k.set_poisoningTimeLeft(5000);
	}

	@Override
	public void visit(Mike m) {
		return;		
	}

	@Override
	public void visit(Naji n) {
		n.setPoisoningPower(1.5);
		n.set_poisoningTimeLeft(5000);
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
}
