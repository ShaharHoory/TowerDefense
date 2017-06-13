package entities.towers;

import javax.swing.ImageIcon;

import entities.Entity;

public abstract class Tower extends Entity {
	protected int threatArea;

	public enum TowerTypes {
		Regular, Terminator;
	}

	protected TowerTypes towerType;

	protected int attackSpeed;

	public Tower(int threatArea, int attackSpeed, ImageIcon sprite) {
		super(sprite); 
		this.threatArea = threatArea;
		this.attackSpeed = attackSpeed;
		initiateTowerType();
	}

	public abstract void initiateTowerType();

}
