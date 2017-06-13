package agents;
import javax.swing.ImageIcon;

import Utils.Visited;
import Utils.Visitor;

public abstract class Creep implements Visited {

	private int _speed;
	private ImageIcon _icon;
	private int _hp;
	
	public Creep(int speed, ImageIcon icon) {
		_speed = speed;
		_icon = icon;
		_hp = 100;
	}
	
	public abstract void impact(Visitor v);
	
	public boolean isDead() {
		return _hp <= 0;
	}
	
}
