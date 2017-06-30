package guiComponents;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import run.TowerDefence;

public class GameToolbar extends JPanel {
	Game game;
	public JButton fastForward;
	JLabel wave;
	JLabel lives;
	public JButton nextWave;
	Image playButton = new ImageIcon(TowerDefence.class.getResource("/platButton.png")).getImage().getScaledInstance(30,
			20, Image.SCALE_SMOOTH);
	Image fatForwardImage = new ImageIcon(TowerDefence.class.getResource("/fastforward.png")).getImage()
			.getScaledInstance(30, 20, Image.SCALE_SMOOTH);
	JLabel time;

	public GameToolbar(Game game) {
		this.game = game;
		this.wave = new JLabel();
		this.lives = new JLabel();
		this.nextWave = new JButton();
		this.fastForward = new JButton();
		this.fastForward.setIcon(new ImageIcon(playButton));
		this.fastForward.setOpaque(false);
		this.fastForward.setContentAreaFilled(false);
		this.fastForward.setEnabled(false);
		this.wave.setText("Waves Passed: " + this.game.gameStats.currWave + "   "); // change
																					// during
																					// a
																					// wave
																					// to
																					// "current
																					// wave"
		this.lives.setText("Lives: " + this.game.gameStats.life + "   ");
		this.nextWave = new JButton();
		this.nextWave.setText("Call next wave!");
		this.time = new JLabel("Time: " + game.timer.toString());
		// this.fastForward.setIcon(new
		// ImageIcon(GameWindow.class.getResource("/fastForward.png")));
		wave.setFont(new Font("arial", Font.PLAIN, 20));
		lives.setFont(new Font("arial", Font.PLAIN, 20));
		time.setFont(new Font("arial", Font.PLAIN, 20));
		nextWave.setFont(new Font("arial", Font.BOLD, 16));

		this.add(lives);
		this.add(wave);
		this.add(time);
		this.add(fastForward);
		this.add(nextWave);

	}
}
