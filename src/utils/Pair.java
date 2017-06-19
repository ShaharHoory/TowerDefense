package utils;

public class Pair {

	protected final int _x;
	protected final int _y;
	private final boolean _isEnterPoint;
	private final boolean _isExitPoint;
	
	public Pair(int x, int y, boolean isEnterPoint, boolean isExitPoint) {
		_x = x;
		_y = y;
		_isEnterPoint = isEnterPoint;
		_isExitPoint = isExitPoint;
	}

	public Pair(int x, int y) {
		_x = x;
		_y = y;
		_isEnterPoint = false;
		_isExitPoint = false;
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
	
}
