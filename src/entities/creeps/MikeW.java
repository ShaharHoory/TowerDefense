package entities.creeps;

import java.awt.Point;

import javax.swing.ImageIcon;

import entities.Visitor;
import run.TowerDefence;
import utilities.Constants;
import utilities.Pair;


public class MikeW extends Creep {

	public MikeW(Point location, Pair[][] directionMatrix) {
		super(Constants.mikeWSpeed, Constants.HP, new ImageIcon (TowerDefence.class.getResource("/mike-1.png")),
				new ImageIcon (TowerDefence.class.getResource("/mike-2.png")), location, directionMatrix );
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impact(Visitor v) {
		v.attack(this);
	}

}
