package utilities;

public class Direction {
	public enum Directions {
		UP, DOWN, RIGHT, LEFT, END
	}

	public static Directions pairToDirectionParser(Pair movment) {
		if (movment.equals(new Pair(0, -1)))
			return Directions.UP;
		if (movment.equals(new Pair(0, -1)))
			return Directions.DOWN;
		if (movment.equals(new Pair(1, 0)))
			return Directions.RIGHT;
		if (movment.equals(new Pair(-1, 0)))
			return Directions.LEFT;
		return Directions.END;

	}

}
