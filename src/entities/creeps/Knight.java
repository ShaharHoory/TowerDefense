package entities.creeps;

import entities.Visitor;
import utilities.Constants;

public class Knight extends Creep {

	public Knight() {
		super(Constants.knightSpeed, Constants.HP, "‪/TowerDefence/sprites/creeps/abir-1.png‬",
				"‪/TowerDefence/sprites/creeps/abir-2.png‬");
		
		

	}

	@Override
	public void impact(Visitor v) {
		 v.attack(this);
	}
	

}
