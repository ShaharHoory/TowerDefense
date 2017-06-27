package utils;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class GameToolbar extends JPanel {

	Game game;
	JButton fastForward;
	JLabel wave;
	JLabel lives;
	JButton nextWave;
	Image regularSpeed = new ImageIcon(GameWindow.class.getResource("/regularSpeed.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
	Image doubleSpeed = new ImageIcon(GameWindow.class.getResource("/fast-forward.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
	JLabel time;
	
	public GameToolbar(Game game){
		this.game = game;
		this.wave = new JLabel();
		this.lives = new JLabel();
		this.nextWave = new JButton();
		this.fastForward = new JButton();
		this.fastForward.setIcon(new ImageIcon(regularSpeed));
		this.fastForward.setOpaque(false);
		this.fastForward.setContentAreaFilled(false);
		this.fastForward.setEnabled(false);
		this.wave.setText("Waves Passed: "+this.game._currWave+"   "); //change during a wave to "current wave"
		this.lives.setText("Lives: "+this.game._lives+"   ");
		this.nextWave = new JButton();
		this.nextWave.setText("Call next wave!");
		this.time = new JLabel("Time: "+game.timer.toString());
		//this.fastForward.setIcon(new ImageIcon(GameWindow.class.getResource("/fastForward.png")));
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
