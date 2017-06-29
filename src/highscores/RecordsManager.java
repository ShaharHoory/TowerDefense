package highscores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class RecordsManager {
	private String ScoresFile = "scores.txt";
	private ArrayList<Score> scores;
	private ObjectOutputStream outputStream = null;
	private ObjectInputStream inputStream = null;
	
	public RecordsManager(){
		scores = new ArrayList<Score>();
	}
	
	public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
	
	private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
	}
	
	public void addScore(String name, int score) {
        loadScoreFile();
        scores.add(new Score(score, name));
        updateScoreFile();
	}
	public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(ScoresFile));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
	}
	
	public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(ScoresFile));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
	}
	
	public String getHighscoreString() {
        String highscoreString = "";
        int max = 5;

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + ". " + scores.get(i).getName() + " -      " + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
	}
}
