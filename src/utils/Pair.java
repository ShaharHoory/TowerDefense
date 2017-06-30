package utils;

public class Pair {

	protected final int _x;
	protected final int _y;
	
	public Pair(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public String toString(){
		if(_x>0)
			return "Right";
		if(_x<0)
			return "Left";
		if(_y>0)
			return "Down";
		if(_y<0)
			return "Up";
		else
			return "Not In Path";
	}

	public int get_x() {
		return _x;
	}

	public int get_y() {
		return _y;
	}
	
}
