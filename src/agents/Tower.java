package agents;

import javax.swing.ImageIcon;

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
	
	public void hit(Creep creep){
		creep.impact(this);
	}
	
}
