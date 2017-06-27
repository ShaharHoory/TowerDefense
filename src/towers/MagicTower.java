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
		rangeColor = Color.PINK;
		towerImage = this.getClass().getResource("/Magic Tower.png");
		shootingImage = this.getClass().getResource("/Shooting Magic Tower.png");
		icon = new ImageIcon(towerImage);
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

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
	
}
