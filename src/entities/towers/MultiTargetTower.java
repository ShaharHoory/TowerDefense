package entities.towers;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import entities.creeps.Creep;

public abstract class MultiTargetTower extends Tower {

	public MultiTargetTower(int threatArea, int attackSpeed, ImageIcon sprite, Color onFocusColor,
			LinkedList<Creep> creeps, Point location) {
		super(threatArea, attackSpeed, sprite, onFocusColor, creeps, location);
	}

	@Override
	public boolean engage() {
		LinkedList<Creep> targets = setTargets();
		if (targets.size() == 0)
			return false;
		for (Creep creep : targets) {
			creep.impact(this);
		}
		return true;
	}

	private LinkedList<Creep> setTargets() {
		LinkedList<Creep> targets = new LinkedList<Creep>();
		for (Creep creep : creeps) {
			if (isCreepThreatened(creep))
				targets.add(creep);
		}
		return targets;
	}

	// @Override
	// public void initiateTowerType() {
	// // TODO Auto-generated method stub
	//
	// }

}
