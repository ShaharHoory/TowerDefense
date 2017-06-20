package towers;

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

	public Tower(int threatArea, int attackSpeed) {
		this.threatArea = threatArea;
		this.attackSpeed = attackSpeed;
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
	
}
