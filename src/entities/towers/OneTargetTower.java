package entities.towers;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import entities.creeps.Creep;

public abstract class OneTargetTower extends Tower {
	private Creep currentTarget;

	public OneTargetTower(int threatArea, int attackSpeed, ImageIcon sprite, Color onFocusColor,
			LinkedList<Creep> creeps, Point location) {
		super(threatArea, attackSpeed, sprite, onFocusColor, creeps, location);
		currentTarget = null;
	}

	@Override
	public boolean engage() {
		currentTarget = setTarget();
		if (currentTarget == null)
			return false;
		currentTarget.impact(this);
		return true;
	}

	private Creep setTarget() {
		int furthest = 0;
		Creep target = null;
		for (Creep creep : creeps) {
			if (isCreepThreatened(creep) && creep.steps >= furthest) {
				target = creep;
				furthest = creep.steps;
			}
		}
		return target;
	}

	//
	// @Override
	// public void initiateTowerType() {
	// // TODO Auto-generated method stub
	//
	// }

}
