package towers;

import java.awt.Color;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class GokuTower extends Tower {

	private int _hitParameterH;
	private int _numOfHits;
	
	public GokuTower(int x , int y) {
		super(2, 1 , x , y);
		this.type = TYPE.REGULAR;
		_hitParameterH = 1;
		_numOfHits = 0;
		setRangeColor(Color.RED);
		setTowerImage((this.getClass().getResource("/Goku Tower.png")));
		setShootingImage((this.getClass().getResource("/Shooting Goku Tower.png")));
		setIcon(new ImageIcon(getTowerImage()));
	}
	
	//updates the numOfHits in accordance
	private void hitted() {
		_numOfHits ++;
		if (_numOfHits % 10 == 0)
			_numOfHits = _numOfHits*2;
	}

	@Override
	public void visit(Guli g) {
		g.setHp(g.getHp()-(_hitParameterH*g.getReductionParameterK()));
		hitted();
	}

	@Override
	public void visit(Knight k) {
		k.setHp(k.getHp()-(_hitParameterH*k.getReductionParameterK()));
		hitted();
	}

	@Override
	public void visit(Mike m) {
		m.setHp(m.getHp()-(_hitParameterH*m.getReductionParameterK()));
		hitted();
	}

	@Override
	public void visit(Naji n) {
		n.setHp(n.getHp()-(_hitParameterH*n.getReductionParameterK()));
		hitted();
	}

}
