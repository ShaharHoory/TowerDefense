package gameLayers;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import creeps.Creep;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;
import timer.Tickable;
import timer.Timer;
import utils.Loader;
import windows.GameToolbar;
import windows.LosingWindow;
import windows.MainMenu;
import windows.winningWindow;

public class GameWindow extends JFrame implements ActionListener , Tickable{

	private Game _game;
	GameToolbar _toolbar;
	private Timer timer;
	private Loader _loader;
	
	public GameWindow(Loader loader, int levelIndex) throws IOException {
		super("Tower Defence!");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800, 900);
		this.setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				exit();
			}
		});
		_loader = loader;
		timer = new Timer();
		_game = new Game(new Board(loader.getLevels().get(levelIndex-1)) , timer);
		_toolbar = new GameToolbar(_game);		
		_toolbar.getFastForward().addActionListener(this);
		_toolbar.getNextWave().addActionListener(this);
		
		timer.register(this);
		timer.register(_game.getGameCreeps());
		timer.register(_game.getGameTowers());
		
		JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 800));       
        layeredPane.add(_game.get_board() , new Integer(0));
        layeredPane.add(_game.getGameCreeps() , new Integer(1));
        layeredPane.add(_game.getGameTowers() , new Integer(2));
        
        this.add(layeredPane, BorderLayout.CENTER);
		this.add(_toolbar , BorderLayout.NORTH);
		layeredPane.setVisible(true);
		pack();
		setVisible(true);
	}
	
	/*public static void main(String[] args) throws IOException {
		new GameWindow();
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = ((JButton)e.getSource());
		if(buttonPressed.equals(_toolbar.getNextWave())){
			callNextWave();
		}
		else if(buttonPressed.equals(_toolbar.getFastForward())){
			if(timer.getTick()==timer.NORMAL_TICK){
				_toolbar.getFastForward().setIcon(new ImageIcon(_toolbar.getDoubleSpeed()));
				timer.fastForward();
			}
			else{
				_toolbar.getFastForward().setIcon(new ImageIcon(_toolbar.getRegularSpeed()));
				timer.regularSpeed();
			}
		}			
	}
	
	public void callNextWave() {
		_game.set_isWave(true);
		_game.set_currWave(_game.get_currWave() + 1);
		LinkedList<Creep> addedCreeps = _game.getGameCreeps().getAddedCreeps();
		for(int i=1 ; i<= Math.pow(2, _game.get_currWave()-1) ; i++){
			addCreeps(addedCreeps);
		}
		Collections.shuffle(addedCreeps);
		timer.start();
		updateGameToolbar();
	}

	private void addCreeps(LinkedList<Creep> addedCreeps) {
		int xStart = _game.get_board().getStartX();
		int yStart = _game.get_board().getStartY();
		addedCreeps.add(new Guli(xStart , yStart));
		addedCreeps.add(new Knight(xStart, yStart));
		addedCreeps.add(new Mike(xStart, yStart));
		addedCreeps.add(new Naji(xStart, yStart));		
	}

	@Override
	public void tickHappened() {
		GameCreeps gc = _game.getGameCreeps();
		if(gc.getAddedCreeps().size()>0 && timer.getNumOfTicks()%7==0){
			Creep creep = gc.getAddedCreeps().removeFirst();
			gc.getCreeps().add(creep);
			//timer.register(creep);
		}
		LinkedList<Creep> creepsToRemove = new LinkedList<>();
		for (Creep creep : gc.getCreeps()) {
			if(creep.getHp()<=0){
				_game.set_deadCreeps(_game.get_deadCreeps() + 1);
				//timer.unregister(creep);
				creepsToRemove.add(creep);
			}			
			if(!_game.get_board().isInBoard(creep.getBoardX() , creep.getBoardY())){
				_game.set_lives(_game.get_lives() - 1);
				_game.set_passedFinishPointCreeps(_game.get_passedFinishPointCreeps() + 1);
				//timer.unregister(creep);
				creepsToRemove.add(creep);
			}
		}
		gc.getCreeps().removeAll(creepsToRemove);
		
		if(_game.lost()){
			timer.stop();
			this.dispose();
			LosingWindow loserWind = new LosingWindow(_game);
		}
		
		if(gc.getCreeps().isEmpty() && gc.getAddedCreeps().isEmpty()){
			timer.stop();
			_game.set_isWave(false);
			_toolbar.getFastForward().setIcon(new ImageIcon(_toolbar.getRegularSpeed()));
		}				
		if (!_game.is_isWave() && _game.get_currWave() == 5) { //if won
			this.dispose();
			new winningWindow(_game);
		}
		updateGameToolbar();
	}

	private void updateGameToolbar() {
		if(_game.is_isWave())
			_toolbar.getWave().setText("Current Wave: "+_game.get_currWave());
		else
			_toolbar.getWave().setText("Waves Passed: "+(_game.get_currWave()));
		_toolbar.getNextWave().setEnabled(!_game.is_isWave());
		_toolbar.getFastForward().setEnabled(_game.is_isWave());
		_toolbar.getLives().setText("Lives: "+_game.get_lives());
		_toolbar.getTime().setText("Time: "+timer.toString());
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
