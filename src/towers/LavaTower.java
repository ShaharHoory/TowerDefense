package towers;

import java.awt.Color;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class LavaTower extends Tower{
	
	public LavaTower(int x , int y) {
		super(1, 1 , x , y);
		this.type = TYPE.ASSASIN;
		setRangeColor(Color.ORANGE);
		setTowerImage((this.getClass().getResource("/Lava Tower.png")));
		setShootingImage((this.getClass().getResource("/Shooting Lava Tower.png")));
		setIcon(new ImageIcon(getTowerImage()));
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
}
