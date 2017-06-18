package utils;

import java.io.Serializable;

public class Score implements Serializable {
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
}
