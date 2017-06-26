package menus;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class WelocmeMenu extends JPanel implements ActionListener {

	protected JLabel _headline;
	protected JButton _playButton;
	protected JButton _exitButton;
	protected JButton _backButton;
	protected JButton _startButton;
	protected JComboBox<Integer> _levelSelect;
	protected JLabel _select;

	public WelocmeMenu() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(800, 800));
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());
		this.setSize(getPreferredSize());
		this.setBackground(Color.CYAN);
		_headline = new JLabel("Tower Defence");
		_headline.setFont(new Font("Tahoma", Font.BOLD, 60));
		_headline.setVisible(true);
		_headline.setAlignmentX(CENTER_ALIGNMENT);
		this.add(_headline);
		initializeButtons();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _playButton) {
			_playButton.setVisible(false);
			_exitButton.setVisible(false);
			_levelSelect.setVisible(true);
			_backButton.setVisible(true);
			_startButton.setVisible(true);
		}
		if (e.getSource() == _backButton) {
			_playButton.setVisible(true);
			_exitButton.setVisible(true);
			_levelSelect.setVisible(false);
			_backButton.setVisible(false);
			_startButton.setVisible(false);
		}

	}

	private void initializeButtons() {
		_playButton = new JButton("Play");
		customizeButton(_playButton);
		_playButton.addActionListener(this);
		_exitButton = new JButton("Exit");
		customizeButton(_exitButton);
		initializeLevelSelect();
		_startButton = new JButton("Start");
		customizeButton(_startButton);
		_startButton.setVisible(false);
		_backButton = new JButton("Back");
		customizeButton(_backButton);
		_backButton.addActionListener(this);
		_backButton.setVisible(false);
	}

	private void customizeButton(JButton b) {
		Dimension size = new Dimension(100, 50);
		b.setMinimumSize(size);
		b.setMaximumSize(size);
		b.setBackground(Color.WHITE);
		b.setAlignmentX(CENTER_ALIGNMENT);
		b.setVerticalAlignment(SwingConstants.CENTER);
		b.setVisible(true);
		b.setFont(new Font("Tahoma", Font.PLAIN, 24));
		this.add(b, CENTER_ALIGNMENT);
		//b.setBounds(b.getBounds().x, b.getBounds().y, 200, 100);
	}

	private void initializeLevelSelect() {
		Vector<Integer> levels = new Vector<Integer>();
		for (int i = 1; i<=5; i++)
			levels.add(new Integer(i));
		this._levelSelect = new JComboBox<>(levels);
		_levelSelect.setFont(new Font("Tahoma", Font.PLAIN, 24));
		this.add(_levelSelect);
		Dimension size = new Dimension(100, 50);
		_levelSelect.setMinimumSize(size);
		_levelSelect.setMaximumSize(size);
		_levelSelect.setVisible(false);
	}
	
	public void exit() {
		String ObjButtons[] = { "Yes", "No" };
		int PromptResult = JOptionPane.showOptionDialog(this, "Are you sure you want to exit?",
				"Online Examination System", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				ObjButtons, ObjButtons[1]);
		if (PromptResult == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
