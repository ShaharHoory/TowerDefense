package creeps;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import utils.Pair;
import utils.Tickable;
import utils.Visited;
import utils.Visitor;

public abstract class Creep extends JPanel implements Visited,Tickable {

	private double _speed;
	private ImageIcon _icon;
	private double _hp;
	private double _poisoningPower;
	private int _reductionParameterK;
	
	public Creep(int speed, ImageIcon icon, int reductionParameter) {
		setSpeed(speed);
		setIcon(icon);
		_reductionParameterK = reductionParameter;
		_hp = 100;
		_poisoningPower = 1;
	}
	
	public abstract void impact(Visitor v);
	
	public void paint(Graphics g, int x, int y) {
		super.paint(g);
		g.drawImage(_icon.getImage(), x, y, null);
	}
	
	//slows down the Creep's speed for @param seconds
	public abstract void slow(int seconds);
	
	public double getSpeed() {
		return _speed;
	}

	public void setSpeed(double speed) {
		_speed = speed;
	}

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

	public ImageIcon getIcon() {
		return _icon;
	}

	public void setIcon(ImageIcon icon) {
		_icon = icon;
	}

	public int getReductionParameterK() {
		return _reductionParameterK;
	}

	public boolean isDead() {
		return _hp <= 0;
	}
	
	public boolean isPoisoned() {
		return _poisoningPower > 0;
	}
}
