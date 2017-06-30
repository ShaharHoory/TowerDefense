package towers;

import java.awt.Color;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class MagicTower extends Tower {
	
	public MagicTower(int x , int y) {
		super(1, 1 , x , y);
		this.type = TYPE.REGULAR;
		setRangeColor(Color.PINK);
		setTowerImage(this.getClass().getResource("/Magic Tower.png"));
		setShootingImage(this.getClass().getResource("/Shooting Magic Tower.png"));
		setIcon(new ImageIcon(getTowerImage()));
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
	
}
