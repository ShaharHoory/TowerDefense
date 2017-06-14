package agents;
import javax.swing.ImageIcon;

import Utils.Tickable;
import Utils.Visited;
import Utils.Visitor;

public abstract class Creep implements Visited,Tickable {

	private int _speed;
	private ImageIcon _icon;
	private int _hp;
	
	public Creep(int speed, ImageIcon icon) {
		_speed = speed;
		_icon = icon;
		_hp = 100;
	}
	
	public abstract void impact(Visitor v);
	
	public int get_hp() {
		return _hp;
	}

	public void set_hp(int _hp) {
		this._hp = _hp;
	}

	public boolean isDead() {
		return _hp <= 0;
	}
	
}
