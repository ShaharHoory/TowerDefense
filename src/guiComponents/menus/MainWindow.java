package guiComponents.menus;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;

import run.TowerDefence;

public class MainWindow extends JFrame implements ActionListener {

	private Dimension _winSize;
	public WelocmeMenu _welcomeMenu;

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
				exit();
			}
		});

		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		_welcomeMenu._exitButton.addActionListener(this);
		_welcomeMenu._backButton.addActionListener(this);
		_welcomeMenu._playButton.addActionListener(this);
		_welcomeMenu._startButton.addActionListener(this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow window = new MainWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _welcomeMenu._playButton) {
			_welcomeMenu._playButton.setVisible(false);
			_welcomeMenu._exitButton.setVisible(false);
			_welcomeMenu._select.setVisible(true);
			_welcomeMenu._lvlSelect.setVisible(true);
			_welcomeMenu._backButton.setVisible(true);
			_welcomeMenu._startButton.setVisible(true);
		}
		if (e.getSource() == _welcomeMenu._backButton) {
			_welcomeMenu._playButton.setVisible(true);
			_welcomeMenu._exitButton.setVisible(true);
			_welcomeMenu._select.setVisible(false);
			_welcomeMenu._lvlSelect.setVisible(false);
			_welcomeMenu._backButton.setVisible(false);
			_welcomeMenu._startButton.setVisible(false);
		}
		if (e.getSource() == _welcomeMenu._startButton) {
			try {
				new TowerDefence(_welcomeMenu._lvl - 1);
				this.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (e.getSource() == _welcomeMenu._exitButton) {
				this.exit();
			}
		}
	}

	public void exit() {
		String ObjButtons[] = { "Yes", "No" };
		int PromptResult = JOptionPane.showOptionDialog(this, "Are you sure you want to exit?",
				"Online Examination System", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons,
				ObjButtons[1]);
		if (PromptResult == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
