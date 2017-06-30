package utilities;

public class Point {
	public double x;
	public double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point(Point other) {
		x = other.x;
		y = other.y;
	}

	public void setPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
