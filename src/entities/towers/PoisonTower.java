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

public class PoisonTower extends OneTargetTower {

	public PoisonTower(LinkedList<Creep> creeps, Point location) {
		super(Constants.poisonThreatRadius, Constants.poisonAttackSpeed,
				new ImageIcon(TowerDefence.class.getResource("/Poison.png")), Color.green, creeps, location);
		// TODO Auto-generated constructor stub
	}

	// @Override
	// public void initiateTowerType() {
	// towerType = TowerType.Regular;
	// }

	@Override
	public void attack(Skull attacked) {
		attacked.damageDecrease(20);

	}

	@Override
	public void attack(MikeW attacked) {
		attacked.damageDecrease(0);
	}

	@Override
	public void attack(Knight attacked) {
		attacked.damageDecrease(0); // poison effect
	}

	@Override
	public void attack(Naji attacked) {
		attacked.damageDecrease(15);// poison effect
	}

}
