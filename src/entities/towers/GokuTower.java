package entities.towers;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

import entities.creeps.Creep;
import entities.creeps.Knight;
import entities.creeps.MikeW;
import entities.creeps.Naji;
import entities.creeps.Skull;
import utilities.Constants;

public class GokuTower extends OneTargetTower {

	private int H;
	private int hitCount;

	public GokuTower(LinkedList<Creep> creeps, Point location) {
		super(Constants.gokuThreatRadius, Constants.gokuAttackSpeed, "‪/TowerDefence/sprites/towers/6.png‬",
				Color.yellow, creeps, location);
		H = 1;
		hitCount = 0;
	}

	public void sayians() {
		hitCount++;
		if (hitCount == 10) {
			H *= 2;
			hitCount = 0;
		}
	}

	// @Override
	// public void initiateTowerType() {
	// towerType = TowerType.Regular;
	// }

	@Override
	public void attack(Skull attacked) {
		attacked.damageDecrease(H * 7);
		sayians();

	}

	@Override
	public void attack(MikeW attacked) {
		attacked.damageDecrease(H * 5);
		sayians();
	}

	@Override
	public void attack(Knight attacked) {
		attacked.damageDecrease(H * 10);
		sayians();
	}

	@Override
	public void attack(Naji attacked) {
		attacked.damageDecrease(H * 5);
		sayians();
	}

}
