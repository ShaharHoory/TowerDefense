package entities.creeps;

import java.awt.Point;

import javax.swing.ImageIcon;

import entities.Visitor;
import run.TowerDefence;
import utilities.Constants;
import utilities.Pair;

public class Knight extends Creep {

	public Knight(Point location, Pair[][] directionMatrix) {
		super(Constants.knightSpeed, Constants.HP, new ImageIcon(TowerDefence.class.getResource("/abir-1.png")),
				new ImageIcon(TowerDefence.class.getResource("/abir-2.png")), location, directionMatrix);
	}

	@Override
	public void impact(Visitor v) {
		v.attack(this);
	}

}
