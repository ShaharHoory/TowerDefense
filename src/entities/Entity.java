package entities;

import java.awt.Point;

import javax.swing.ImageIcon;

public abstract class Entity {
	public ImageIcon sprite;
	public Point location;

	public Entity(String sprite, Point p) {
		this.sprite = new ImageIcon("‪/TowerDefence/sprites/creeps/guli-1.png‬");
		location = new Point(p);
	}

	public Point getLocation() {
		return location;
	}

}