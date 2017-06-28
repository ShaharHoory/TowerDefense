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

public class ArrowTower extends OneTargetTower {

	public ArrowTower(LinkedList<Creep> creeps, Point location) {
		super(Constants.arrowThreatRadius, Constants.arrowAttackSpeed,
				new ImageIcon(TowerDefence.class.getResource("/Arrow.png")), Color.gray, creeps, location);
	}

	// @Override
	// public void initiateTowerType() {
	// towerType = TowerType.Regular;
	// }

	@Override
	public void attack(Skull attacked) {
		attacked.damageDecrease(15);
	}

	@Override
	public void attack(MikeW attacked) {
		attacked.damageDecrease(30);

	}

	@Override
	public void attack(Knight attacked) {

	}

	@Override
	public void attack(Naji attacked) {
		attacked.damageDecrease(30);
	}

}
