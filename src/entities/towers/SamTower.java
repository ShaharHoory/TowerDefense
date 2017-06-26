package entities.towers;

import javax.swing.ImageIcon;

import entities.creeps.Knight;
import entities.creeps.MikeW;
import entities.creeps.Naji;
import entities.creeps.Skull;
import utilities.Constants;

public class SamTower extends Tower {

	public SamTower() {
		super(Constants.samThreatRadius, Constants.samAttackSpeed, "‪/TowerDefence/sprites/towers/5.png‬");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initiateTowerType() {
		towerType = TowerType.Terminator;
	}

	@Override
	public void attack(Skull attacked) {
		attacked.damageDecrease(0); // slow effect			
	}

	@Override
	public void attack(MikeW attacked) {
		attacked.damageDecrease(10);	//slow effect				
	}

	@Override
	public void attack(Knight attacked) {
		attacked.damageDecrease(0);	//slow effect						
	}

	@Override
	public void attack(Naji attacked) {
		attacked.damageDecrease(0);	//slow effect						
	}

	@Override
	public void engage() {
		// TODO Auto-generated method stub
		
	}

}
