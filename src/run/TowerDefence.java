package run;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import game.Board;
import game.Game;
import guiComponents.GameToolbar;
import guiComponents.menus.MainWindow;
import guiComponents.menus.WelocmeMenu;
import pace.Tickable;
import pace.Timer;
import utilities.LevelLoader;
import utilities.Pair;

public class TowerDefence extends JFrame implements ActionListener, Tickable {
	private WelocmeMenu _welcomeMenu;
	private Game game;
	private Timer timer;
	private LevelLoader levelLoader;

	public TowerDefence() {
		super("Tower Defense");
		setVisualDesign();
		levelLoader = new LevelLoader();
		Board currBoard = new Board(getDirectionMatrixAtChosenLevel());
		game = new Game(currBoard, timer);
		game.gameToolbar.fastForward.addActionListener(this);
		game.gameToolbar.nextWave.addActionListener(this);
		timer.register(this);
		timer.register(game.gameCreeps);
		timer.register(game.gameTowers);
		
	}

	private Pair[][] getDirectionMatrixAtChosenLevel() {
		return levelLoader.levels.get(_welcomeMenu._levelSelect.getSelectedIndex() - 1);
	}

	private void setVisualDesign() {
		setPreferredSize(new Dimension(800, 900));
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		int xPos = (dm.width / 2) - (this.getWidth() / 2);
		int yPos = (dm.height / 2) - (this.getHeight() / 2);
		this.setLocation(xPos, yPos);
		this.getContentPane().setLayout(new BorderLayout());
		this._welcomeMenu = new WelocmeMenu();
		this.add(_welcomeMenu, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				_welcomeMenu.exit();
			}
		});

		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		_welcomeMenu._exitButton.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow window = new MainWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _welcomeMenu._exitButton) {
			_welcomeMenu.exit();
		}
	}

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
}
