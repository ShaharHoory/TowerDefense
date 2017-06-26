package entities.creeps;


import entities.Visitor;
import utilities.Constants;

public class Skull extends Creep {

	public Skull() {
		super(Constants.skullSpeed, Constants.HP, "‪/TowerDefence/sprites/creeps/guli-1.png‬",
				"‪/TowerDefence/sprites/creeps/guli-2.png‬");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impact(Visitor v) {
		v.attack(this);
	}

}
