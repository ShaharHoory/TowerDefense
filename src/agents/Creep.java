package agents;
import javax.swing.ImageIcon;

import Utils.Visited;
import Utils.Visitor;

public abstract class Creep implements Visited {

	private int _speed;
	private ImageIcon _icon;
	private double _hp;
	private double _poisoningPower;
	
	public Creep(int speed, ImageIcon icon) {
		_speed = speed;
		_icon = icon;
		_hp = 100;
		_poisoningPower = 1;
	}
	
	public abstract void impact(Visitor v);
	
	public double getHp() {
		return _hp;
	}

	public void setHp(double hp) {
		_hp = hp;
	}

	public double getPoisoningPower() {
		return _poisoningPower;
	}

	public void setPoisoningPower(double poisoningPower) {
		_poisoningPower = poisoningPower;
	}

	public boolean isDead() {
		return _hp <= 0;
	}
	
	public boolean isPoisoned() {
		return _poisoningPower > 0;
	}
	
}
