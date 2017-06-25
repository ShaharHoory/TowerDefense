package towers;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class FlyingDinoTower extends Tower {
	
	public FlyingDinoTower(int x , int y) {
		super(2, 1 , x , y);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/dino-1.png"));
	}

	@Override
	public void visit(Guli g) {
		g.setHp(g.getHp()-15);		
	}

	@Override
	public void visit(Knight k) {
		k.setHp(k.getHp()-k.getPoisoningPower()*8);		
	}

	@Override
	public void visit(Mike m) {
		m.setHp(m.getHp()-10);
	}

	@Override
	public void visit(Naji n) {
		n.setHp(n.getHp()-n.getPoisoningPower()*11);
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
}
