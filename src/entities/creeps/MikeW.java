package entities.creeps;

import java.awt.Point;

import entities.Visitor;
import utilities.Constants;
import utilities.Pair;


public class MikeW extends Creep {

	public MikeW(Point location, Pair[][] directionMatrix) {
		super(Constants.mikeWSpeed, Constants.HP, " ‪/TowerDefence/sprites/creeps/mike-1.png",
				"‪/TowerDefence/sprites/creeps/mike-2.png", location, directionMatrix );
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impact(Visitor v) {
		v.attack(this);
	}

}
