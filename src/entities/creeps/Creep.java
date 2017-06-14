package entities.creeps;

import javax.swing.ImageIcon;

import entities.Entity;
import entities.Visited;

public abstract class Creep extends Entity implements Visited {
	protected int speed;
	protected int HP;

	public Creep(int speed, int HP, ImageIcon sprite) {
		super(sprite);
		this.speed = speed;
		this.HP = HP;
	}

}
