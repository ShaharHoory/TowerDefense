package entities.creeps;

import java.awt.Point;

import javax.swing.ImageIcon;

import entities.Visitor;
import run.TowerDefence;
import utilities.Constants;
import utilities.Pair;

public class Naji extends Creep {

	public Naji(Point location ,Pair[][] directionMatrix) {
		super(Constants.najiSpeed, Constants.HP, new ImageIcon (TowerDefence.class.getResource("/naji-1.png")),
				new ImageIcon (TowerDefence.class.getResource("/naji-2.png")), location,directionMatrix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void impact(Visitor v) {
		v.attack(this);
	}

}
