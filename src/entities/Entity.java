package entities;


import javax.swing.ImageIcon;

public abstract class Entity {
	protected ImageIcon sprite;

	public Entity(String sprite) {
		this.sprite = new ImageIcon("‪/TowerDefence/sprites/creeps/guli-1.png‬");
	}

}