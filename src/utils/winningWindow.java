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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import highscores.RecordsManager;

public class winningWindow extends JFrame implements MouseListener{

	private Game _game;
	private JPanel _mainPanel;
	private JPanel _infoPanel;
	private JPanel _buttonsPanel;
	private JLabel _livesLabel;
	private JLabel _passedEnemies;
	private JLabel _deadCreeps;
	private JLabel _timePassed;
	private JLabel _scoreLabel;
	private JButton _startOver;
	private JButton _exit;
	private JButton _saveRecord;
	private JTextField _name;
	private boolean _saved;
	private RecordsManager _recordsManager;
	private double _score;
	
	public winningWindow(Game game) {
		super("You Won!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 330);
		this.setResizable(false);
		_mainPanel = new JPanel(new BorderLayout());
		this.add(_mainPanel);
		_game = game;
		_saved = false;
		_recordsManager = new RecordsManager();
	//****	_score = //להכניס נוסחה של עידו\!!!!!!!!!! ****************************
		
		//mainPanel
		JLabel lostLabel = new JLabel("You Won!");
		lostLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		_mainPanel.add(lostLabel, BorderLayout.PAGE_START);
		
		//infoPanel
		_infoPanel = new JPanel();
		_infoPanel.setLayout(new BoxLayout(_infoPanel, BoxLayout.Y_AXIS));
		_infoPanel.setSize(100, 150);
		//text
		_scoreLabel = new JLabel("\n" + "\n" + "Your score: " + _score);
		_livesLabel = new JLabel("lives: " + _game._lives);
		_passedEnemies = new JLabel("Amount of enemies who passed the finish point: " + _game._passedFinishPointCreeps);
		_deadCreeps = new JLabel("Creeps Killed: " + _game._deadCreeps);
		_timePassed = new JLabel("Time Passed: " + _game.timer.toString());
		//size
		_scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		_livesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		_passedEnemies.setFont(new Font("Tahoma", Font.BOLD, 14));
		_deadCreeps.setFont(new Font("Tahoma", Font.BOLD, 14));
		_timePassed.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		_scoreLabel.setAlignmentX(CENTER_ALIGNMENT);
		_livesLabel.setAlignmentX(CENTER_ALIGNMENT);
		_passedEnemies.setAlignmentX(CENTER_ALIGNMENT);
		_deadCreeps.setAlignmentX(CENTER_ALIGNMENT);
		_timePassed.setAlignmentX(CENTER_ALIGNMENT);
		
		_infoPanel.add(_scoreLabel);
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
		_saveRecord = new JButton(new ImageIcon((this.getClass().getResource("/saveRecordButton.png"))));
		_saveRecord.setContentAreaFilled(false);
		_saveRecord.setSelected(false);
		_saveRecord.setBorderPainted(false);
		_saveRecord.setBorder(null);
		_saveRecord.addMouseListener(this);
		_saveRecord.setVisible(true);
		_name = new JTextField("Enter your name");
		_buttonsPanel.add(_startOver, BorderLayout.WEST);
		_buttonsPanel.add(_saveRecord, BorderLayout.CENTER);
		_buttonsPanel.add(_exit, BorderLayout.EAST);
		_buttonsPanel.add(_name, BorderLayout.SOUTH);
		
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
		else if (e.getSource().equals(_saveRecord)) {
			if (!_saved) {
				if (_name.getText().equals("") || _name.getText().equals("Enter your name")) {
					JOptionPane.showMessageDialog(this, "Enter your name and try again", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				_recordsManager.addScore(_name.getText(), 5);//במקום 5 לשים את _score
				JOptionPane.showMessageDialog(this, "Record Saved!");
				_saved = true;
			}
			else {
				JOptionPane.showMessageDialog(this, "Record has already inserted", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(_startOver))
			_startOver.setIcon(new ImageIcon((this.getClass().getResource("/startOverButtonHovered.png"))));
		else if (e.getSource().equals(_exit))
			_exit.setIcon(new ImageIcon((this.getClass().getResource("/exitButtonHovered.png"))));
		else if (e.getSource().equals(_saveRecord))
			_saveRecord.setIcon(new ImageIcon((this.getClass().getResource("/saveRecordButtonHovered.png"))));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(_startOver)) {
			_startOver.setIcon(new ImageIcon((this.getClass().getResource("/startOverButton.png"))));
		}
		else if (e.getSource().equals(_exit)) {
			_exit.setIcon(new ImageIcon((this.getClass().getResource("/exitButton.png"))));
		}
		else if (e.getSource().equals(_saveRecord))
			_saveRecord.setIcon(new ImageIcon((this.getClass().getResource("/saveRecordButton.png"))));
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
