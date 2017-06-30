package towers;

import java.awt.Color;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;
import gameLayers.GameWindow;

public class PoisonTower extends Tower{
	public PoisonTower(int x , int y) {
		super(1, 1 , x , y);
		this.type = TYPE.REGULAR;		
		setRangeColor(Color.green);
		setTowerImage(this.getClass().getResource("/Poison Tower.png"));
		setShootingImage(this.getClass().getResource("/Shooting Poison Tower.png"));
		setIcon(new ImageIcon(getTowerImage()));
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
}
