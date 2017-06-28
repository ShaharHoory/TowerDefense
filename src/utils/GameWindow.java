package utils;
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
import creeps.GameCreeps;
import creeps.Guli;
import creeps.Knight;
import creeps.Mike;
import creeps.Naji;

public class GameWindow extends JFrame implements ActionListener , Tickable{

	private Game _game;
	MainMenu _menu;
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
		_game = new Game(new Board(loader.levels.get(levelIndex-1)) , timer);
		_toolbar = new GameToolbar(_game);		
		_toolbar.fastForward.addActionListener(this);
		_toolbar.nextWave.addActionListener(this);
		
		timer.register(this);
		timer.register(_game.gameCreeps);
		timer.register(_game.gameTowers);
		
		JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 800));       
        layeredPane.add(_game.get_board() , new Integer(0));
        layeredPane.add(_game.gameCreeps , new Integer(1));
        layeredPane.add(_game.gameTowers , new Integer(2));
        
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
		if(buttonPressed.equals(_toolbar.nextWave)){
			callNextWave();
		}
		else if(buttonPressed.equals(_toolbar.fastForward)){
			if(timer.tick==timer.NORMAL_TICK){
				_toolbar.fastForward.setIcon(new ImageIcon(_toolbar.doubleSpeed));
				timer.fastForward();
			}
			else{
				_toolbar.fastForward.setIcon(new ImageIcon(_toolbar.regularSpeed));
				timer.regularSpeed();
			}
		}			
	}
	
	public void callNextWave() {
		_game._isWave = true;
		_game._currWave++;
		LinkedList<Creep> addedCreeps = _game.gameCreeps.getAddedCreeps();
		for(int i=1 ; i<= Math.pow(2, _game._currWave-1) ; i++){
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
		GameCreeps gc = _game.gameCreeps;
		if(gc.getAddedCreeps().size()>0 && timer.getNumOfTicks()%7==0){
			Creep creep = gc.getAddedCreeps().removeFirst();
			gc.getCreeps().add(creep);
			//timer.register(creep);
		}
		LinkedList<Creep> creepsToRemove = new LinkedList<>();
		for (Creep creep : gc.getCreeps()) {
			if(creep.getHp()<=0){
				_game._deadCreeps++;
				//timer.unregister(creep);
				creepsToRemove.add(creep);
			}			
			if(!_game.get_board().isInBoard(creep.getBoardX() , creep.getBoardY())){
				_game._lives--;
				_game._passedFinishPointCreeps++;
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
			_game._isWave = false;
			_toolbar.fastForward.setIcon(new ImageIcon(_toolbar.regularSpeed));
		}				
		if (!_game._isWave && _game._currWave == 1) { //if won
			this.dispose();
			new winningWindow(_game);
		}
		updateGameToolbar();
	}

	private void updateGameToolbar() {
		if(_game._isWave)
			_toolbar.wave.setText("Current Wave: "+_game._currWave);
		else
			_toolbar.wave.setText("Waves Passed: "+(_game._currWave));
		_toolbar.nextWave.setEnabled(!_game._isWave);
		_toolbar.fastForward.setEnabled(_game._isWave);
		_toolbar.lives.setText("Lives: "+_game._lives);
		_toolbar.time.setText("Time: "+timer.toString());
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
