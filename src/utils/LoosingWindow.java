package utils;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoosingWindow extends JFrame {

	private Game _game;
	private JPanel _mainPanel;
	private JPanel _infoPanel;
	private JLabel _livesLabel;
	private JLabel _passedEnemies;
	private JLabel _deadCreeps;
	private JLabel _timePassed;
	
	public LoosingWindow(Game game) {
		super("You Lost!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 435);
		this.setResizable(false);
		_mainPanel = new JPanel(new BorderLayout());
		this.add(_mainPanel);
		
		JLabel lostLabel = new JLabel("You Lost!");
		lostLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		_mainPanel.add(lostLabel, BorderLayout.PAGE_START);
		
		//infoPanel
		_infoPanel = new JPanel();
		_infoPanel.setLayout(new BoxLayout(_infoPanel, BoxLayout.Y_AXIS));
		_infoPanel.setSize(100, 150);
		_livesLabel = new JLabel("lives: 0");
		//_lives.setHorizontalAlignment(SwingConstants.CENTER);
		_passedEnemies = new JLabel("Amount of enemies who passed the finish point: 20");
		_deadCreeps = new JLabel("Dead Creeps: ido merge this!!!");
		_timePassed = new JLabel("Time Passed: MERGE IDO");
		_infoPanel.add(_livesLabel);
		_infoPanel.add(_passedEnemies);
		_infoPanel.add(_deadCreeps);
		_infoPanel.add(_timePassed);
		
		_mainPanel.add(_infoPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
