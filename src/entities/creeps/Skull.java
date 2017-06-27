package entities.creeps;


import java.awt.Point;

import entities.Visitor;
import utilities.Constants;
import utilities.Pair;


public class Skull extends Creep {

	public Skull(Point location, Pair[][] directionMatrix) {
		super(Constants.skullSpeed, Constants.HP, "‪/TowerDefence/sprites/creeps/guli-1.png‬",
				"‪/TowerDefence/sprites/creeps/guli-2.png‬", location, directionMatrix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impact(Visitor v) {
		v.attack(this);
	}

}
