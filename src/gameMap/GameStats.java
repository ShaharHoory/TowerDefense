package gameMap;

public class GameStats {
	public int life;
	public int currWave;
	public int creepsPassed;
	public int creepsKilled;
	public boolean isWave;

	public GameStats() {
		life = 20;
		currWave = 0;
		creepsPassed = 0;
		creepsKilled = 0;
		isWave = false;
	}

	public boolean isAlive() {
		return life > 0;
	}
}
