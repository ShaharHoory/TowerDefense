package utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

public class GameWindow extends JFrame{

	private Game _game;
	MainMenu _menu;
	GameToolbar _toolbar;
	private Loader loader;
	
	public GameWindow() throws IOException {
		super("Tower Defence!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800, 900);
		this.setResizable(false);
		loader = new Loader();
		loader.load("Levels.txt");
		_game = new Game(new Board(loader.levels.get(0)));
		_toolbar = new GameToolbar(_game);
		this.add(_game, BorderLayout.CENTER);
		this.add(_toolbar , BorderLayout.NORTH);
		this.pack();
		this.setVisible(true); 
	}
	
	public static void main(String[] args) throws IOException {
		new GameWindow();
	}

}
