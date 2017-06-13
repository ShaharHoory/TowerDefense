package Utils;

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
	
}
