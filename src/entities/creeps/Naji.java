package entities.creeps;

import javax.swing.ImageIcon;

import entities.Visitor;
import utilities.Constants;

public class Naji extends Creep {

	public Naji() {
		super(Constants.najiSpeed, Constants.HP, "‪/TowerDefence/sprites/creeps/naji-1.png",
				"‪/TowerDefence/sprites/creeps/naji-2.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impact(Visitor v) {
		v.attack(this);
	}

}
