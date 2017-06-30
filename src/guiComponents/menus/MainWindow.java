package guiComponents.menus;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener {

	private Dimension _winSize;
	private WelocmeMenu _welcomeMenu;

	public MainWindow() {
		super("Tower Defence");
		_winSize = new Dimension(800, 900);
		this.setMinimumSize(_winSize);
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
}
