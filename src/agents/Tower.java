package agents;

import javax.swing.ImageIcon;

public abstract class Tower {
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
}
