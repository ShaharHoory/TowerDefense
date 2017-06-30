package run;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import entities.creeps.Creep;
import entities.creeps.Knight;
import entities.creeps.MikeW;
import entities.creeps.Naji;
import entities.creeps.Skull;
import game.Board;
import game.Game;
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

		JLayeredPane layers = new JLayeredPane();
		layers.add(game.boardGUI, new Integer(0));
		layers.add(game.gameCreeps, new Integer(1));
		layers.add(game.gameTowers, new Integer(2));
		layers.setVisible(true);

		this.add(layers, BorderLayout.CENTER);
		this.add(game.gameToolbar, BorderLayout.NORTH);

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
		JButton clicked = (JButton) e.getSource();
		if (clicked == game.gameToolbar.nextWave)
			summonNextWave();
		if( clicked == _welcomeMenu._startButton){
			_welcomeMenu.setVisible(false);
			game.setVisible(true);
		}
			
		
	}

	private void summonNextWave() {
		game.gameStats.nextWaveStats();
		LinkedList<Creep> toInit = new LinkedList<Creep>();
		initiateNextWave(toInit);
		Collections.shuffle(toInit);
		game.gameCreeps.creepsInLine.addAll(toInit);
		game.gameToolbar.updateToolbar();
		timer.register(this);
		timer.register(game.gameCreeps);
		timer.register(game.gameTowers);
		timer.start();
	}

	private void initiateNextWave(LinkedList<Creep> toInit) {
		for (int i = 1; i <= Math.pow(2, game.gameStats.currWave); i++) {
			addCreepsToWave(toInit);
		}
	}

	private void addCreepsToWave(LinkedList<Creep> toInit) {
		Point location = game.board.getStartPosition();
		toInit.add(new Skull(location, getDirectionMatrixAtChosenLevel()));
		toInit.add(new Knight(location, getDirectionMatrixAtChosenLevel()));
		toInit.add(new MikeW(location, getDirectionMatrixAtChosenLevel()));
		toInit.add(new Naji(location, getDirectionMatrixAtChosenLevel()));

	}

	@Override
	public void tickHappened() {
		if (game.gameStats.isWave) {
			if (isTimeToSummonNextCreep()) {
				Creep summoned = game.gameCreeps.creepsInLine.removeFirst();
				game.gameCreeps.creeps.add(summoned);
				timer.register(summoned);
			}
			LinkedList<Creep> passedAndKilled = new LinkedList<Creep>();
			for (Creep creep : game.gameCreeps.creeps) {
				if (!creep.isAlive()) {
					game.gameStats.creepsKilled++;
					passedAndKilled.add(creep);
				}
				if (!game.board.isInBoard(creep.location)) {
					game.gameStats.creepPassed();
					timer.unregister(creep);
					passedAndKilled.add(creep);
				}
				game.gameCreeps.creeps.removeAll(passedAndKilled);
			}
			if (!game.gameStats.isAlive()) {
				timer.stop();
				this.dispose();
				// TODO : add losing window
			}

			if (game.gameStats.isWon()) {
				this.dispose();
				// TODO : add winning window
			}
			game.gameToolbar.updateToolbar();
		}
	}
	

	private boolean isTimeToSummonNextCreep() {
		return game.gameCreeps.creepsInLine.size() > 0 && timer.getTicksAccumulator() % 5 == 0;
	}
}
