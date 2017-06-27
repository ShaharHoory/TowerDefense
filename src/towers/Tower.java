package towers;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;

import creeps.Creep;
import utils.Tickable;
import utils.Visitor;

public abstract class Tower implements Visitor,Tickable {
	protected int threatArea;
	protected enum TYPE{
		REGULAR,
		ASSASIN
	}
	protected TYPE type;
	protected int attackSpeed;
	protected ImageIcon icon;
	int x;
	int y;
	int timeToShoot;
	Color rangeColor;
	protected URL towerImage;
	protected URL shootingImage;

	public Tower(int threatArea, int attackSpeed , int x , int y) {
		this.threatArea = threatArea;
		this.attackSpeed = attackSpeed;
		this.x = x;
		this.y = y;
		timeToShoot=0;
	}
	
	public int getThreatArea() {
		return threatArea;
	}

	public void setThreatArea(int threatArea) {
		this.threatArea = threatArea;
	}

	public void hit(Creep creep){
		creep.impact(this);
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
