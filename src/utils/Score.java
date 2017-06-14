package utils;

public class Score implements Comparable<Score> {
	protected int score;
	protected String name;
	
	public Score(int score , String name){
		this.score = score;
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Score arg0) {
		return this.score-arg0.score;
	}
	
	
}
