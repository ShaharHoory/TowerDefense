package Utils;

import agents.Creep;

public class Board implements Tickable {
	
	private Pair[][] _directonsMat;
	private Creep[][] _creepsLoc; //???
	
	public Board(Pair[][] directionsMat) {
		_directonsMat = directionsMat;
	}

	public void setDirectonsMat(Pair[][] directonsMat) {
		_directonsMat = directonsMat;
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
}
