package entities.creeps;

import java.awt.Point;

import entities.Visitor;
import utilities.Constants;
import utilities.Pair;

public class Naji extends Creep {

	public Naji(Point location ,Pair[][] directionMatrix) {
		super(Constants.najiSpeed, Constants.HP, "‪/TowerDefence/sprites/creeps/naji-1.png",
				"‪/TowerDefence/sprites/creeps/naji-2.png", location,directionMatrix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impact(Visitor v) {
		v.attack(this);
	}

}
