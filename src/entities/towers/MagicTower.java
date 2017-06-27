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
import utilities.Constants;

public class MagicTower extends OneTargetTower {

	public MagicTower(LinkedList<Creep> creeps, Point location) {
		super(Constants.magicThreatRadius, Constants.magicAttackSpeed, "‪/TowerDefence/sprites/towers/4.png‬",
				Color.MAGENTA, creeps, location);
		// TODO Auto-generated constructor stub
	}

	// @Override
	// public void initiateTowerType() {
	// towerType = TowerType.Regular;
	// }

	@Override
	public void attack(Skull attacked) {
		attacked.damageDecrease(25);
	}

	@Override
	public void attack(MikeW attacked) {
		attacked.damageDecrease(10);
	}

	@Override
	public void attack(Knight attacked) {
		attacked.damageDecrease(30);
	}

	@Override
	public void attack(Naji attacked) {
		attacked.damageDecrease(10);
	}

}
