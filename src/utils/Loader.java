package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Loader {
	private static final char UP = 'U';
	private static final char DOWN = 'D';
	private static final char RIGHT = 'R';
	private static final char LEFT = 'L';
	private static final char NOT_IN_PATH = '.';
	
	private Vector<Pair[][]> levels;
	
	public Loader(){
		setLevels(new Vector<>());
	}
	
	public boolean load(String levelsFile) throws IOException{
		String line = null;
		Pair[][] level = null;
		BufferedReader br = new BufferedReader(new FileReader(levelsFile));
		int w = 0;
		int h = 0;
		int row = 0;
		while ((line = br.readLine()) != null) {
			// end of level
			if (line.trim().isEmpty()) {
				if (level!=null) {
					getLevels().add(level);
					level = null;
				}
				continue;
			}
			// board size
			if (line.trim().startsWith("w")) {
				w = Integer.valueOf(line.trim().substring(1));
				continue;
			}
			if (line.trim().startsWith("h")) {
				h = Integer.valueOf(line.trim().substring(1));
				continue;
			}
			if (line.startsWith(";")) {
				continue;
			}
			// start of level definition
			if (level==null && h > 0 && w > 0) {
				level = new Pair[h][w];
				row = 0;
			}
			// regular board line
			for (int col = 0; col < line.length(); col++) {
				Pair pair = parsePair(row, col, line.charAt(col));
				if (pair!=null) {
					level[row][col] = pair;
				} else {
					br.close();
					return false;
				}
			}
			row++;
		}
		if (level!=null) {
			getLevels().add(level);
			level = null;
		}
		br.close();
		return true;
	}

	private Pair parsePair(int row, int col, char charAt) {
		switch(charAt){
		case UP:
			return new Pair(0,-1);
		case DOWN:
			return new Pair(0,1);
		case RIGHT:
			return new Pair(1,0);
		case LEFT:
			return new Pair(-1,0);
		case NOT_IN_PATH:
			return new Pair(0,0);
		default: return null;
		}
	}

	public Vector<Pair[][]> getLevels() {
		return levels;
	}

	public void setLevels(Vector<Pair[][]> levels) {
		this.levels = levels;
	}
	
	
}
