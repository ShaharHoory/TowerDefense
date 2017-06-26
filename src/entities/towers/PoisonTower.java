package entities.towers;

import javax.swing.ImageIcon;

import entities.creeps.Knight;
import entities.creeps.MikeW;
import entities.creeps.Naji;
import entities.creeps.Skull;
import utilities.Constants;

public class PoisonTower extends Tower {

	public PoisonTower() {
		super(Constants.poisonThreatRadius, Constants.poisonAttackSpeed, "‪/TowerDefence/sprites/towers/3.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initiateTowerType() {
		towerType = TowerType.Regular;
	}

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

	@Override
	public void engage() {
		// TODO Auto-generated method stub
		
	}

}
