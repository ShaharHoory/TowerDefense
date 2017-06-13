package agents;
import javax.swing.ImageIcon;

import Utils.Visited;
import Utils.Visitor;

public abstract class Creep implements Visited {

	private int _speed;
	private ImageIcon _icon;
	
	public Creep(int speed, ImageIcon icon) {
		_speed = speed;
		_icon = icon;
	}
	
	public abstract void impact(Visitor v);
	
}
