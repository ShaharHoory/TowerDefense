package Utils;

import agents.Creep;

public class Board {
	
	private Pair[][] _directonsMat;
	private Creep[][] _creepsLoc; //???
	
	public Board(Pair[][] directionsMat) {
		_directonsMat = directionsMat;
	}

	public void setDirectonsMat(Pair[][] directonsMat) {
		_directonsMat = directonsMat;
	}

}
