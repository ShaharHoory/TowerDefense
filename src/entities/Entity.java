package entities;

import javax.swing.ImageIcon;

public abstract class Entity {
	protected ImageIcon sprite;

	public Entity(ImageIcon sprite) {
		this.sprite = sprite;
	}
}
