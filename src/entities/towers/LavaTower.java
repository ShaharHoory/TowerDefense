package entities.towers;

import javax.swing.ImageIcon;

import entities.creeps.Knight;
import entities.creeps.MikeW;
import entities.creeps.Naji;
import entities.creeps.Skull;
import utilities.Constants;

public class LavaTower extends Tower {

	public LavaTower(ImageIcon sprite) {
		super(Constants.gokuThreatRadius, Constants.gokuAttackSpeed, sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initiateTowerType() {
		towerType = TowerTypes.Terminator;
	}

	@Override
	public void attack(Skull attacked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(MikeW attacked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Knight attacked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Naji attacked) {
		// TODO Auto-generated method stub
		
	}

}
