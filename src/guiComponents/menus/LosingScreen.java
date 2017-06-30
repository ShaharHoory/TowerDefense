package guiComponents.menus;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import game.Game;

public class LosingScreen extends JFrame implements ActionListener {
	
	protected JPanel _mainPanel;
	protected JLabel _loseMsg;
	protected JLabel _creepsKilled;
	protected JLabel _creepsPassed;
	protected JLabel _gameTime;
	protected JButton _exitButton;
	protected JButton _playAgainButton;
	
	public LosingScreen(Game game) {
		super();
		_mainPanel = new JPanel();
		_mainPanel.setLayout(new BorderLayout(30, 30));
		_loseMsg = new JLabel("You Lost!");
		_loseMsg.setFont(new Font("Tahoma", Font.BOLD, 32));
		_mainPanel.add(_loseMsg, BorderLayout.PAGE_START);
		initializeStats(game);
		initializeButtons();
	}
	
	private void initializeStats(Game game) {
		_creepsKilled = new JLabel("Creeps Killed: " + game.gameStats.creepsKilled);
		_creepsPassed = new JLabel("Creeps Passed: "  + game.gameStats.creepsPassed);
		_gameTime = new JLabel("Time: "  + game.timer);
		_mainPanel.add(_gameTime, BorderLayout.LINE_START);
		_mainPanel.add(_creepsKilled, BorderLayout.CENTER);
		_mainPanel.add(_creepsPassed, BorderLayout.LINE_END);
	}
	private void initializeButtons() {
		_playAgainButton = new JButton("Play Again");
		_mainPanel.add(_playAgainButton, BorderLayout.EAST);
		_exitButton = new JButton("Exit");
		_mainPanel.add(_exitButton, BorderLayout.EAST);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
