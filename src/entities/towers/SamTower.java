package entities.towers;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import entities.creeps.Creep;
import entities.creeps.Knight;
import entities.creeps.MikeW;
import entities.creeps.Naji;
import entities.creeps.Skull;
import run.TowerDefence;
import utilities.Constants;

public class SamTower extends MultiTargetTower {

	public SamTower(LinkedList<Creep> creeps, Point location) {
		super(Constants.samThreatRadius, Constants.samAttackSpeed,
				new ImageIcon(TowerDefence.class.getResource("/Sam.png")), Color.black, creeps, location);
		// TODO Auto-generated constructor stub
	}

	// @Override
	// public void initiateTowerType() {
	// towerType = TowerType.Terminator;
	// }

	@Override
	public void attack(Skull attacked) {
		attacked.damageDecrease(0); // slow effect
	}

	@Override
	public void attack(MikeW attacked) {
		attacked.damageDecrease(10); // slow effect
	}

	@Override
	public void attack(Knight attacked) {
		attacked.damageDecrease(0); // slow effect
	}

	@Override
	public void attack(Naji attacked) {
		attacked.damageDecrease(0); // slow effect
	}

}
