package entities.creeps;

import java.awt.Point;

import entities.Visitor;
import utilities.Constants;
import utilities.Pair;


public class Knight extends Creep {

	public Knight(Point location, Pair[][] directionMatrix) {
		super(Constants.knightSpeed, Constants.HP, "‪/TowerDefence/sprites/creeps/abir-1.png‬",
				"‪/TowerDefence/sprites/creeps/abir-2.png‬", location, directionMatrix);
	}

	@Override
	public void impact(Visitor v) {
		v.attack(this);
	}

}
