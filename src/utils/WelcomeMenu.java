package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import highscores.RecordsManager;


public class WelcomeMenu extends JFrame implements ActionListener {

	private Loader _levelLoader;
	protected JButton _playButton;
	protected JButton _exitButton;
	private JButton _highScores;
	private JButton _nextLevelButton;
	private JButton _prevLevelButton;
	private JPanel _menuContent;
	private JPanel _levelSelectPanel;
	private JLabel _levelsViewLabel;
	private HashMap<Integer, ImageIcon> _levelsMap;
	private int _chosenIndex;
	private int _numOfLevels;
	private RecordsManager _recordsManager;
	
	public WelcomeMenu() throws IOException {
		super("Tower Defence!");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(600, 435);
		this.setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				exit();
			}
		});
		
		_levelLoader = new Loader();
		_levelLoader.load("Levels.txt");
		_numOfLevels = _levelLoader.levels.size();
		_recordsManager = new RecordsManager();
		
		//menu content panel
		_menuContent = new JPanel();
		_menuContent.setSize(600, 435);
		_menuContent.setLayout(null);
		JLabel welcomeLabel = new JLabel("Tower Defence!");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		welcomeLabel.setBounds(201, 20, 190, 35);
		_menuContent.add(welcomeLabel);
		initializeButtons();
		_chosenIndex = 1;
		
		//level select panel
		_levelSelectPanel = new JPanel();
		_levelSelectPanel.setBounds(110, 50, 370, 300);
		ImageIcon nextImage = new ImageIcon((this.getClass().getResource("/nextButton.png")));
		ImageIcon prevImage = new ImageIcon((this.getClass().getResource("/prevButton.png")));
		nextImage = new ImageIcon(nextImage.getImage().getScaledInstance(57, 59, Image.SCALE_SMOOTH));
		prevImage = new ImageIcon(prevImage.getImage().getScaledInstance(57, 59, Image.SCALE_SMOOTH));
		_nextLevelButton = new JButton(nextImage);
		_prevLevelButton = new JButton(prevImage);
		_nextLevelButton.setPreferredSize(new Dimension(57, 59));
		_prevLevelButton.setPreferredSize(new Dimension(57, 59));
		_prevLevelButton.setSize(57, 59);
		_nextLevelButton.addActionListener(this);
		_prevLevelButton.addActionListener(this);
		manageLevelsButtons();
		_levelsViewLabel = new JLabel();
		_levelsMap = new HashMap<>();
		levalsMapInitialization();
		_levelSelectPanel.add(_prevLevelButton);
		_levelsViewLabel.setIcon(_levelsMap.get(_chosenIndex));
		_levelSelectPanel.add(_levelsViewLabel);
		_levelSelectPanel.add(_nextLevelButton);
		
		_menuContent.add(_levelSelectPanel);
		this.add(_menuContent);
		this.setVisible(true);
	}

	//initializes the levels-map
	private void levalsMapInitialization() {
		for(int i=1; i<=_numOfLevels; i++) {
			ImageIcon levelIcon = new ImageIcon((this.getClass().getResource("/level"+i+"Image.png")));
			_levelsMap.put(i, levelIcon);
		}
	}

	//initializes all the buttons
	private void initializeButtons() { 
		_playButton = addButton("Play", 237, 250);
		_highScores = addButton("HighScores", 237, 290);
		_exitButton = addButton("Exit", 237, 330);
		}
	
	//creates a button
	 private JButton addButton(String text, int x, int y) {
			JButton button = new JButton(text);
			button.setFont(new Font("Tahoma", Font.BOLD, 14));
			button.setForeground(new Color(88, 44, 0));
			button.setBackground(Color.WHITE);
			button.setFocusable(false);
			button.setRequestFocusEnabled(false);
			button.setMinimumSize(new Dimension(100, 50));
			button.setAlignmentX(CENTER_ALIGNMENT);
			button.setAlignmentY(CENTER_ALIGNMENT);
			button.setBounds(x, y, 117, 35);
			button.addActionListener(this);
			button.setVisible(true);
			_menuContent.add(button);
			_menuContent.revalidate();
			return button;
			}
	
	 public static void main(String[] args) throws IOException {
			new WelcomeMenu();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(_nextLevelButton)) { //pushed nextLevel
			_chosenIndex++;
			if (!(_prevLevelButton.isEnabled()))
				_prevLevelButton.setEnabled(true);
			manageLevelsButtons();
			_levelsViewLabel.setIcon(_levelsMap.get(_chosenIndex)); //shows the chosen level image
		}
		
		if(e.getSource().equals(_prevLevelButton)) { //pushed prevLevel
			_chosenIndex--;
			if (!(_nextLevelButton.isEnabled()))
				_nextLevelButton.setEnabled(true);
			manageLevelsButtons();
			_levelsViewLabel.setIcon(_levelsMap.get(_chosenIndex)); //shows the chosen level image
		}
		
		if(e.getSource().equals(_playButton)) {
			try {
				new GameWindow(_levelLoader, _chosenIndex);
				this.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource().equals(_highScores)) {
			JOptionPane.showMessageDialog(this, _recordsManager.getHighscoreString(), "Highscores", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getSource().equals(_exitButton))
			exit();
	}
	
	//disables/enables the next/prev level buttons
	private void manageLevelsButtons() {
		if(_chosenIndex == _numOfLevels) {
			_nextLevelButton.setEnabled(false);
			return;
		}
		if(_chosenIndex == 1) {
			_prevLevelButton.setEnabled(false);
			return;
		}
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

