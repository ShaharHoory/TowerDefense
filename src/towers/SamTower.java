package towers;

import java.awt.Color;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class SamTower extends Tower{

	public SamTower(int x , int y) {
		super(2, 2 , x , y);
		this.type = TYPE.ASSASIN;
		setRangeColor(Color.BLACK);
		setTowerImage(this.getClass().getResource("/Sam Tower.png"));
		setShootingImage(this.getClass().getResource("/Shooting Sam Tower.png"));
		setIcon(new ImageIcon(getTowerImage()));
	}

	@Override
	public void visit(Guli g) {
		g.set_slowTimeLeft(3000);
		g.setSpeed(g.INIT_SPEED/2);
	}

	@Override
	public void visit(Knight k) {
		k.set_slowTimeLeft(6000);
		k.setSpeed(k.INIT_SPEED/2);
	}

	@Override
	public void visit(Mike m) {
		m.set_slowTimeLeft(3000);
		m.setHp(m.getHp()-10);
		m.setSpeed(m.INIT_SPEED/2);
		
	}

	@Override
	public void visit(Naji n) {
		n.set_slowTimeLeft(3000);
		n.setSpeed(n.INIT_SPEED/2);
		
	}

}
