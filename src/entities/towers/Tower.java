package entities.towers;

import entities.Visitor;
import entities.creeps.Creep;
import pace.Tickable;
import pace.Timer;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import entities.Entity;

public abstract class Tower extends Entity implements Visitor, Tickable {
	public int threatArea;
	// protected TowerType towerType;
	protected int attackSpeed;
	private int cooldown;
	public LinkedList<Creep> creeps;
	public Color onFocusColor;

	public Tower(int threatArea, int attackSpeed, ImageIcon sprite, Color onFocusColor, LinkedList<Creep> creeps,
			Point location) {
		super(sprite, location);
		this.threatArea = threatArea;
		this.attackSpeed = attackSpeed;
		this.onFocusColor = onFocusColor;
		this.creeps = creeps;
		// initiateTowerType();
	}

	// public abstract void initiateTowerType();

	public abstract boolean engage();

	public boolean isCreepThreatened(Creep c) {
		return Math.abs(location.x - c.actualLocation.x) <= threatArea
				&& Math.abs(location.y - c.actualLocation.y) <= threatArea;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	@Override
	public void tickHappened() {
		if (cooldown > 0)
			cooldown -= Timer.actualInterval * attackSpeed;

		if (cooldown <= 0) {
			if (engage())
				cooldown = 1000;
		}

	}

	public boolean isOnBoard() {
		return location.x + threatArea >= 0 && location.x + threatArea <= 32 && location.y + threatArea >= 0
				&& location.y + threatArea <= 32;
	}

}
