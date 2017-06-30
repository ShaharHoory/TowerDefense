package utilities;

public class Pair {

	public int xInc;
	public int yInc;

	public Pair(int xInc, int yInc) {
		super();
		this.xInc = xInc;
		this.yInc = yInc;
	}

	public int getxInc() {
		return xInc;
	}

	public void setxInc(int xInc) {
		this.xInc = xInc;
	}

	public int getyInc() {
		return yInc;
	}

	public void setyInc(int yInc) {
		this.yInc = yInc;
	}

	public boolean equals(Pair other) {
		if (other.xInc == xInc && other.yInc == yInc)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Pair [xInc=" + xInc + ", yInc=" + yInc + "]";
	}

}
