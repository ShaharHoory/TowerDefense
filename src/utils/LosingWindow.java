package utils;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LosingWindow extends JFrame implements MouseListener{

	private Game _game;
	private JPanel _mainPanel;
	private JPanel _infoPanel;
	private JPanel _buttonsPanel;
	private JLabel _livesLabel;
	private JLabel _passedEnemies;
	private JLabel _deadCreeps;
	private JLabel _timePassed;
	private JLabel _score;
	private JButton _startOver;
	private JButton _exit;
	
	public LosingWindow(Game game) {
		super("You Lost!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 280);
		this.setResizable(false);
		_mainPanel = new JPanel(new BorderLayout());
		this.add(_mainPanel);
		_game = game;
		
		//mainPanel
		JLabel lostLabel = new JLabel("You Lost!");
		lostLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		_mainPanel.add(lostLabel, BorderLayout.PAGE_START);
		
		//infoPanel
		_infoPanel = new JPanel();
		_infoPanel.setLayout(new BoxLayout(_infoPanel, BoxLayout.Y_AXIS));
		_infoPanel.setSize(100, 150);
		//text
		_score = new JLabel("\n" + "\n" + "Your score: 0");
		_livesLabel = new JLabel("lives: 0");
		_passedEnemies = new JLabel("Amount of enemies who passed the finish point: 20");
		_deadCreeps = new JLabel("Creeps Killed: " + _game._deadCreeps);
		_timePassed = new JLabel("Time Passed: " + _game.timer.toString());
		//size
		_score.setFont(new Font("Tahoma", Font.BOLD, 14));
		_livesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		_passedEnemies.setFont(new Font("Tahoma", Font.BOLD, 14));
		_deadCreeps.setFont(new Font("Tahoma", Font.BOLD, 14));
		_timePassed.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		_score.setAlignmentX(CENTER_ALIGNMENT);
		_livesLabel.setAlignmentX(CENTER_ALIGNMENT);
		_passedEnemies.setAlignmentX(CENTER_ALIGNMENT);
		_deadCreeps.setAlignmentX(CENTER_ALIGNMENT);
		_timePassed.setAlignmentX(CENTER_ALIGNMENT);
		
		_infoPanel.add(_score);
		_infoPanel.add(_livesLabel);
		_infoPanel.add(_passedEnemies);
		_infoPanel.add(_deadCreeps);
		_infoPanel.add(_timePassed);
		
		//buttonsPanel
		_buttonsPanel = new JPanel();
		_buttonsPanel.setLayout(new BorderLayout());
		_buttonsPanel.setSize(600, 40);
		_startOver = new JButton(new ImageIcon((this.getClass().getResource("/startOverButton.png"))));
		_startOver.setContentAreaFilled(false);
		_startOver.setSelected(false);
		_startOver.setBorderPainted(false);
		_startOver.setBorder(null);
		_startOver.addMouseListener(this);
		_exit = new JButton(new ImageIcon((this.getClass().getResource("/exitButton.png"))));
		_exit.setContentAreaFilled(false);
		_exit.setSelected(false);
		_exit.setBorderPainted(false);
		_exit.setBorder(null);
		_exit.addMouseListener(this);
		_buttonsPanel.add(_startOver, BorderLayout.WEST);
		_buttonsPanel.add(_exit, BorderLayout.EAST);
		
		_mainPanel.add(_infoPanel, BorderLayout.CENTER);
		_mainPanel.add(_buttonsPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(_startOver)) {
			this.dispose();
			try {
				new WelcomeMenu();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource().equals(_exit)) {
			exit();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(_startOver)) 
			_startOver.setIcon(new ImageIcon((this.getClass().getResource("/startOverButtonHovered.png"))));
		else if (e.getSource().equals(_exit))
			_exit.setIcon(new ImageIcon((this.getClass().getResource("/exitButtonHovered.png"))));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(_startOver)) {
			_startOver.setIcon(new ImageIcon((this.getClass().getResource("/startOverButton.png"))));
		}
		else if (e.getSource().equals(_exit)) {
			_exit.setIcon(new ImageIcon((this.getClass().getResource("/exitButton.png"))));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//exits the program according to the user's choice
	public void exit() {
		String ObjButtons[] = { "Yes", "No" };
		int PromptResult = JOptionPane.showOptionDialog(this, "Are you sure you want to exit?",
				"Exit", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				ObjButtons, ObjButtons[1]);
		if (PromptResult == JOptionPane.YES_OPTION) {
			System.exit(0);
			}
		}
}
