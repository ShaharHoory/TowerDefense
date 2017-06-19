package utils;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class GameToolbar extends JPanel {

	Game game;
	JButton fastForward;
	JLabel wave;
	JLabel lives;
	JButton nextWave;
	
	public GameToolbar(Game game){
		this.game = game;
		this.wave = new JLabel();
		this.lives = new JLabel();
		this.nextWave = new JButton();
		this.fastForward = new JButton();
		this.wave.setText("Waves Passed: "+this.game._currWave+"   "); //change during a wave to "current wave"
		this.lives.setText("Lives: "+this.game._lives+"   ");
		this.nextWave = new JButton();
		//this.fastForward.setIcon(new ImageIcon(GameWindow.class.getResource("/fastForward.png")));
		wave.setFont(new Font("arial", Font.PLAIN, 20));
		lives.setFont(new Font("arial", Font.PLAIN, 20));
		
		this.add(lives);
		this.add(wave);
		this.add(fastForward);
		this.add(nextWave);
		this.setVisible(true);
	}
}
