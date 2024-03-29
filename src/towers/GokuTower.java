package towers;

import javax.swing.ImageIcon;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class GokuTower extends Tower {

	private int _hitParameterH;
	private int _numOfHits;
	
	public GokuTower() {
		super(2, 1);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/goku.png"));
		_hitParameterH = 1;
		_numOfHits = 0;
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

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}

}
