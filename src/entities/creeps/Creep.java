package entities.creeps;

import javax.swing.ImageIcon;

import entities.Entity;
import entities.Visited;
import effects.*;
import java.util.LinkedList;

public abstract class Creep extends Entity implements Visited {
	protected int speed;
	protected int HP;
	protected ImageIcon sprite2;
	protected boolean state;
	protected LinkedList<Effect> currentEffects;

	public Creep(int speed, int HP, String spriteState1, String spriteState2) {
		super(spriteState1);
		this.speed = speed;
		this.HP = HP;
		state = false;
		sprite2 = new ImageIcon(spriteState2);

	}

	public void damageDecrease(int damage) {
		for (Effect effect : currentEffects) {
			if (effect.getType().equals(EffectType.Poison))
				damage *= effect.getEffectParam();
		}
		HP -= damage;
	}

	// TODO : check for errors
	public void damageDecrease(int damage, Effect e) {
		damageDecrease(damage);
		for (Effect effect : currentEffects) {
			if (effect.getType().equals(e.getType()))
				currentEffects.remove(effect);
			break;
		}

		currentEffects.add(e);
	}

}
