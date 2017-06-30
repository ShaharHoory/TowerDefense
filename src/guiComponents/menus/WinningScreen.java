package guiComponents.menus;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import game.Game;
import game.GameStats;
import guiComponents.GameToolbar;
public class WinningScreen extends JFrame implements ActionListener{
	
	protected JPanel _mainPanel;
	protected JLabel _winMsg;
	protected JLabel _creepsKilled;
	protected JLabel _creepsPassed;
	protected JLabel _gameTime;
	protected TextField _nameField;
	protected JButton _exitButton;
	protected JButton _playAgainButton;
	protected JButton _submitScore;
	
	public WinningScreen(Game game) {
		super();
		_mainPanel = new JPanel();
		_mainPanel.setLayout(new BorderLayout(30, 30));
		_winMsg = new JLabel("You Won!");
		_winMsg.setFont(new Font("Tahoma", Font.BOLD, 32));
		_mainPanel.add(_winMsg, BorderLayout.NORTH);
		initializeStats(game);
		initializeButtons();
	}
	
	
	private void initializeStats(Game game) {
		_creepsKilled = new JLabel("Creeps Killed: " + game.gameStats.creepsKilled);
		_creepsPassed = new JLabel("Creeps Passed: "  + game.gameStats.creepsPassed);
		_gameTime = new JLabel("Time: "  + game.timer);
		_nameField = new TextField("Enter Your Name", 15);
		_nameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		_mainPanel.add(_gameTime, BorderLayout.WEST);
		_mainPanel.add(_creepsKilled, BorderLayout.CENTER);
		_mainPanel.add(_creepsPassed, BorderLayout.EAST);
		_mainPanel.add(_nameField, BorderLayout.SOUTH);
	}
	
	private void initializeButtons() {
		_submitScore = new JButton("Submit");
		_mainPanel.add(_submitScore, BorderLayout.EAST);
		_playAgainButton = new JButton("Play Again");
		_mainPanel.add(_playAgainButton, BorderLayout.EAST);
		_exitButton = new JButton("Exit");
		_mainPanel.add(_exitButton, BorderLayout.EAST);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(_exitButton))
			exit();
		if (e.getSource().equals(_playAgainButton)) {
			//TODO creates a new game
		}
		if (e.getSource().equals(_submitScore)) {
			//TODO submit the score to the highscores.txt
		}
	}
	
	public void exit() {
		String ObjButtons[] = { "Yes", "No" };
		int PromptResult = JOptionPane.showOptionDialog(this, "Are you sure you want to exit?",
				"Online Examination System", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons,
				ObjButtons[1]);
		if (PromptResult == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
