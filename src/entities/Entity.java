package entities;

import java.awt.Point;

import javax.swing.ImageIcon;

public abstract class Entity {
	public ImageIcon sprite;
	public Point location;

	public Entity(ImageIcon sprite, Point p) {
		this.sprite = sprite;
		location = new Point(p);
	}

	public Point getLocation() {
		return location;
	}

}