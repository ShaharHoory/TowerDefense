package utils;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends JFrame{

	private Game _game;
	
	public GameWindow() {
		super("Tower Defence!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800, 650);
		this.setResizable(false);
		this.setVisible(true);
		_game = new Game(new Pair[32][32]); //TODO: add reading levels from text file
		this.add(_game, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new GameWindow();
	}

}
