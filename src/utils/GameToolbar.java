package utils;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.nextWave.setText("Call next wave!");
		//this.fastForward.setIcon(new ImageIcon(GameWindow.class.getResource("/fastForward.png")));
		wave.setFont(new Font("arial", Font.PLAIN, 20));
		lives.setFont(new Font("arial", Font.PLAIN, 20));
		
		this.add(lives);
		this.add(wave);
		this.add(fastForward);
		this.add(nextWave);
		
		this.nextWave.addActionListener(new ToolbarListener());
		this.fastForward.addActionListener(new ToolbarListener());
		this.setVisible(true);
	}
	
	public class ToolbarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton buttonPressed = ((JButton)e.getSource());
			if(buttonPressed.equals(nextWave)){
				//call next wave
				//disable some features
			}
			if(buttonPressed.equals(fastForward)){
				//fast forward the game - set timer to x/2;
			}			
		}
		
	}
}
