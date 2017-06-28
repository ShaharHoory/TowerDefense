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

public class LavaTower extends MultiTargetTower {

	public LavaTower(LinkedList<Creep> creeps, Point location) {
		super(Constants.gokuThreatRadius, Constants.gokuAttackSpeed, new ImageIcon(TowerDefence.class.getResource("/Goku.png")), Color.red,
				creeps, location);
		// TODO Auto-generated constructor stub

	}

	// @Override
	// public void initiateTowerType() {
	// towerType = TowerType.Terminator;
	// }

	@Override
	public void attack(Skull attacked) {
		attacked.damageDecrease(15);
	}

	@Override
	public void attack(MikeW attacked) {
		attacked.damageDecrease(15);
	}

	@Override
	public void attack(Knight attacked) {
		attacked.damageDecrease(10);
	}

	@Override
	public void attack(Naji attacked) {
		attacked.damageDecrease(15);
	}

}
