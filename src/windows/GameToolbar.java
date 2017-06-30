package windows;

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
import gameLayers.Game;
import gameLayers.GameWindow;

public class GameToolbar extends JPanel {

	Game game;
	private JButton fastForward;
	private JLabel wave;
	private JLabel lives;
	private JButton nextWave;
	private Image regularSpeed = new ImageIcon(GameWindow.class.getResource("/regularSpeed.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
	private Image doubleSpeed = new ImageIcon(GameWindow.class.getResource("/fast-forward.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
	private JLabel time;
	
	public GameToolbar(Game game){
		this.game = game;
		this.setWave(new JLabel());
		this.setLives(new JLabel());
		this.setNextWave(new JButton());
		this.setFastForward(new JButton());
		this.getFastForward().setIcon(new ImageIcon(getRegularSpeed()));
		this.getFastForward().setOpaque(false);
		this.getFastForward().setContentAreaFilled(false);
		this.getFastForward().setEnabled(false);
		this.getWave().setText("Waves Passed: "+this.game.get_currWave()+"   "); //change during a wave to "current wave"
		this.getLives().setText("Lives: "+this.game.get_lives()+"   ");
		this.setNextWave(new JButton());
		this.getNextWave().setText("Call next wave!");
		this.setTime(new JLabel("Time: "+game.getTimer().toString()));
		//this.fastForward.setIcon(new ImageIcon(GameWindow.class.getResource("/fastForward.png")));
		getWave().setFont(new Font("arial", Font.PLAIN, 20));
		getLives().setFont(new Font("arial", Font.PLAIN, 20));
		getTime().setFont(new Font("arial", Font.PLAIN, 20));
		getNextWave().setFont(new Font("arial", Font.BOLD, 16));
		
		
		
		this.add(getLives());
		this.add(getWave());
		this.add(getTime());
		this.add(getFastForward());
		this.add(getNextWave());
		
	}

	public JButton getFastForward() {
		return fastForward;
	}

	public void setFastForward(JButton fastForward) {
		this.fastForward = fastForward;
	}

	public Image getRegularSpeed() {
		return regularSpeed;
	}

	public void setRegularSpeed(Image regularSpeed) {
		this.regularSpeed = regularSpeed;
	}

	public JButton getNextWave() {
		return nextWave;
	}

	public void setNextWave(JButton nextWave) {
		this.nextWave = nextWave;
	}

	public Image getDoubleSpeed() {
		return doubleSpeed;
	}

	public void setDoubleSpeed(Image doubleSpeed) {
		this.doubleSpeed = doubleSpeed;
	}

	public JLabel getWave() {
		return wave;
	}

	public void setWave(JLabel wave) {
		this.wave = wave;
	}

	public JLabel getLives() {
		return lives;
	}

	public void setLives(JLabel lives) {
		this.lives = lives;
	}

	public JLabel getTime() {
		return time;
	}

	public void setTime(JLabel time) {
		this.time = time;
	}
}
