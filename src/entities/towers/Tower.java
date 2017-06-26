package entities.towers;

import javax.swing.ImageIcon;
import entities.Visitor;
import entities.Entity;

public abstract class Tower extends Entity implements Visitor {
	protected int threatArea;
	protected TowerType towerType;
	protected int attackSpeed;

	public Tower(int threatArea, int attackSpeed, String spriteState) {
		super(spriteState);
		this.threatArea = threatArea;
		this.attackSpeed = attackSpeed;
		initiateTowerType();
	}

	public abstract void initiateTowerType();
	
	public abstract void engage(); 
}
