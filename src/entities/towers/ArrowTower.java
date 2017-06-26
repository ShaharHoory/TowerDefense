package entities.towers;

import javax.swing.ImageIcon;

import entities.creeps.Knight;
import entities.creeps.MikeW;
import entities.creeps.Naji;
import entities.creeps.Skull;
import utilities.Constants;

public class ArrowTower extends Tower {

	public ArrowTower() {
		super(Constants.arrowThreatRadius, Constants.arrowAttackSpeed, "/TowerDefence/sprites/towers/2.png‬");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initiateTowerType() {
		towerType = TowerType.Regular;
	}

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

	@Override
	public void engage() {
		// TODO Auto-generated method stub
		
	}

}
