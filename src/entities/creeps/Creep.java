package entities.creeps;

import javax.swing.ImageIcon;

import entities.Entity;
import entities.Visited;
import pace.Tickable;
import pace.Timer;
import utilities.Pair;
import effects.*;
import java.awt.Point;
import java.util.LinkedList;

public abstract class Creep extends Entity implements Visited {
	public int speed;
	protected double HP;
	protected ImageIcon sprite2;
	protected boolean state;
	protected LinkedList<Effect> currentEffects;
	public int steps;
	public utilities.Point actualLocation;
	public static double ticksPerStep;
	private Pair[][] directionMatrix;

	public Creep(int speed, int HP, ImageIcon spriteState1, ImageIcon spriteState2, Point p, Pair[][] directionMatrix) {
		super(spriteState1, p);
		this.speed = speed;
		this.HP = HP;
		state = false;
		sprite2 = spriteState2;
		steps = 0;
		actualLocation = new utilities.Point(p.getX(), p.getY());
		currentEffects = new LinkedList<Effect>();
		ticksPerStep = 0.1 * speed;
		this.directionMatrix = directionMatrix;
	}

	public void updateEffectsDuration() {
		LinkedList<Effect> woreOff = new LinkedList<Effect>();
		for (Effect effect : currentEffects) {
			effect.setTimeRemaining(Timer.tickInterval);
			if (effect.getTimeRemaining() <= 0)
				woreOff.add(effect);
		}
		currentEffects.removeAll(woreOff);
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

	public ImageIcon getImage() {
		return state ? sprite : sprite2;
	}

//	@Override
//	public void tickHappened() {
//		state = !state;
//		Pair movement = getPairInCurrentLocation();
//		boolean direR = movement.xInc > 0;
//		boolean direL = movement.xInc < 0;
//		boolean direD = movement.yInc > 0;
//		boolean direU = movement.yInc < 0;
//		boolean isNextSlotLeft = direR && (int) (actualLocation.x + 0.7) < location.x;
//		boolean isNextSlotUp = direL && (int) (actualLocation.y + 0.7) < location.y;
//		boolean isNextSlotRight = direD && (int) (actualLocation.x - 0.5) > location.x;
//		boolean isNextSlotDown = direU && (int) (actualLocation.y - 0.5) > location.y;
//		if (isNextSlotLeft || isNextSlotUp || isNextSlotRight || isNextSlotDown)
//			moveToNextSlot(movement);
//		else
//			moveWithinSlot(direR, direL, direU, direD);
//
//	}

	// private void moveWithinSlot(boolean direR, boolean direL, boolean direU,
	// boolean direD) {
	// double actualSpeed = ticksPerStep;
	//
	// // taking into consideration the slow effect
	// for (Effect effect : currentEffects) {
	// if (effect.getType().equals(EffectType.Slow))
	// actualSpeed *= effect.getEffectParam();
	// }
	//
	// // update position accoring to direction
	// if (direD) {
	// actualLocation.y += actualSpeed;
	// if (actualLocation.y > location.y)
	// location.y = (int) actualLocation.y;
	// } else if (direR) {
	// actualLocation.x += actualSpeed;
	// if (actualLocation.x > location.x)
	// location.x = (int) actualLocation.x;
	// } else if (direU) {
	// actualLocation.y -= actualSpeed;
	// if (actualLocation.y < location.y - (1 - actualSpeed))
	// location.y = (int) actualLocation.y;
	// } else if (direL) {
	// actualLocation.x -= actualSpeed;
	// if (actualLocation.x < location.x - (1 - actualSpeed))
	// location.x = (int) actualLocation.x;
	// }
	// }
	//
	// private void moveToNextSlot(Pair movement) {
	// location.setLocation(location.x + movement.xInc, location.y +
	// movement.yInc);
	// actualLocation.setPoint(location.x, location.y);
	// steps++;
	//
	// }

	public Pair getPairInCurrentLocation() {
		return directionMatrix[location.y][location.x];
	}

	public boolean isAlive() {
		return HP > 0;
	}
}
