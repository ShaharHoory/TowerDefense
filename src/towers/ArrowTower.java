package towers;

import java.awt.Color;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class ArrowTower extends Tower{
	 public ArrowTower (int x , int y) {
		super(2, 2 , x , y);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/Arrow Tower.png"));
		rangeColor = Color.WHITE;
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
