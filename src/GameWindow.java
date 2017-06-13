import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends JFrame{

	public GameWindow() {
		super("Tower Defence!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 650);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameWindow();
	}

}
