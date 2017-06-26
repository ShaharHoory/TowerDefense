package entities.creeps;

import entities.Visitor;
import utilities.Constants;

public class MikeW extends Creep {

	public MikeW() {
		super(Constants.mikeWSpeed, Constants.HP, " ‪/TowerDefence/sprites/creeps/mike-1.png",
				"‪/TowerDefence/sprites/creeps/mike-2.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impact(Visitor v) {
		v.attack(this);
	}

}
