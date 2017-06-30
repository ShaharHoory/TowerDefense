package guiComponents.menus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;

import run.TowerDefence;

public class WelocmeMenu extends JPanel implements ActionListener {

	protected JLabel _headline;
	protected JButton _playButton;
	public JButton _exitButton;
	protected JButton _backButton;
	protected JButton _startButton;
	public JComboBox<Integer> _levelSelect;
	protected JLabel _select;
	protected JPanel _buttons;
	protected JPanel _lvlSelect;
	protected JLabel _lvlPreview;
	protected int _lvl;

	public WelocmeMenu() {
		super();
		this.setLayout(new BorderLayout(30, 30));
		this.setPreferredSize(new Dimension(800, 800));
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());
		this.setSize(getPreferredSize());
		this.setBackground(Color.lightGray);
		_headline = new JLabel(new ImageIcon(TowerDefence.class.getResource("/towerDefenceLogo.png")));
		_headline.setFont(new Font("Tahoma", Font.BOLD, 100));
		_headline.setVisible(true);
		_headline.setHorizontalAlignment(SwingConstants.CENTER);
		 this.add(_headline, BorderLayout.NORTH);
		_select = new JLabel("Select a level :");
		_select.setHorizontalAlignment(SwingConstants.LEFT);
		_select.setFont(new Font("Tahoma", Font.BOLD, 24));
		_select.setVisible(false);
		_select.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(_select, BorderLayout.CENTER);
		initializeButtons();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _playButton) {
			_playButton.setVisible(false);
			_exitButton.setVisible(false);
			// _levelSelect.setVisible(true);
			_select.setVisible(true);
			_lvlSelect.setVisible(true);
			_backButton.setVisible(true);
			_startButton.setVisible(true);
			// _buttons.repaint();
			// _buttons.revalidate();
			// this.repaint();
			// this.revalidate();
		}
		if (e.getSource() == _backButton) {
			_playButton.setVisible(true);
			_exitButton.setVisible(true);
			// _levelSelect.setVisible(false);
			_select.setVisible(false);
			_lvlSelect.setVisible(false);
			_backButton.setVisible(false);
			_startButton.setVisible(false);
			// _buttons.repaint();
			// _buttons.revalidate();
			// this.repaint();
			// this.revalidate();
		}
	}

	private void initializeButtons() {
		_buttons = new JPanel();
		_buttons.setLayout(new BoxLayout(_buttons, BoxLayout.Y_AXIS));
		initializeLvlSelect();
		_playButton = new JButton("Play");
		customizeButton(_playButton);
		_playButton.addActionListener(this);
		_exitButton = new JButton("Exit");
		customizeButton(_exitButton);
		_startButton = new JButton("Start");
		customizeButton(_startButton);
		_startButton.setVisible(false);
		_backButton = new JButton("Back");
		customizeButton(_backButton);
		_backButton.addActionListener(this);
		_backButton.setVisible(false);
		_buttons.setBackground(Color.lightGray);
		this.add(_buttons, BorderLayout.CENTER);
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
		b.setOpaque(true);
		b.setFocusPainted(false);
		b.setBorderPainted(true);
		b.setContentAreaFilled(true);
		_buttons.add(b, CENTER_ALIGNMENT);
		_buttons.add(Box.createVerticalStrut(25));
		// b.setBounds(b.getBounds().x, b.getBounds().y, 200, 100);
	}

	/*
	 * private void initializeLevelSelect() { Vector<Integer> levels = new
	 * Vector<Integer>(); for (int i = 1; i<=5; i++) levels.add(new Integer(i));
	 * this._levelSelect = new JComboBox<>(levels); _levelSelect.setFont(new
	 * Font("Tahoma", Font.PLAIN, 24)); _buttons.add(_levelSelect); Dimension
	 * size = new Dimension(100, 50); _levelSelect.setMinimumSize(size);
	 * _levelSelect.setMaximumSize(size); _levelSelect.setVisible(false); }
	 */

	private void initializeLvlSelect() {
		Color transparent = new Color(0, 0, 0, 0);
		_lvlSelect = new JPanel();
		_lvlSelect.setLayout(new FlowLayout());
		_lvlSelect.setMaximumSize(new Dimension(800, 225));
		_lvlSelect.setBackground(transparent);
		// _buttons.add(_select, CENTER_ALIGNMENT);
		JButton leftArrow = new JButton();
		ImageIcon leftArrowIcon = new ImageIcon(TowerDefence.class.getResource("/leftArrow.png"));
		leftArrow.setIcon(leftArrowIcon);
		leftArrow.setSelected(false);
		leftArrow.setBackground(Color.LIGHT_GRAY);
		leftArrow.setForeground(Color.LIGHT_GRAY);
		leftArrow.setSize(200, 200);
		leftArrow.setBorderPainted(false);
		leftArrow.setFocusPainted(false);
		leftArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prevLvl();
			}
		});
		leftArrow.setMinimumSize(new Dimension(leftArrowIcon.getIconWidth(), leftArrowIcon.getIconHeight()));
		leftArrow.setMaximumSize(new Dimension(leftArrowIcon.getIconWidth(), leftArrowIcon.getIconHeight()));
		leftArrow.setSize(100, 100);
		_lvlSelect.add(leftArrow, FlowLayout.LEFT);
		_lvl = 1;
		_lvlPreview = new JLabel(new ImageIcon(TowerDefence.class.getResource("/level1.png")));
		// _lvlPreview.setBackground(Color.WHITE);
		// _lvlPreview.setMinimumSize(new Dimension(300, 300));
		// _lvlPreview.setHorizontalTextPosition(SwingConstants.CENTER);
		// _lvlPreview.setVerticalTextPosition(SwingConstants.CENTER);
		// _lvlPreview.setMaximumSize(new Dimension(300, 300));
		// _lvlPreview.setSize(getMaximumSize());
		_lvlSelect.add(_lvlPreview, FlowLayout.CENTER);
		JButton rightArrow = new JButton();
		ImageIcon rightArrowIcon = new ImageIcon(TowerDefence.class.getResource("/rightArrow.png"));
		rightArrow.setIcon(rightArrowIcon);
		rightArrow.setSelected(false);
		rightArrow.setBackground(Color.LIGHT_GRAY);
		rightArrow.setForeground(Color.WHITE);
		rightArrow.setSize(200, 200);
		rightArrow.setContentAreaFilled(true);
		rightArrow.setBorderPainted(false);
		rightArrow.setFocusPainted(false);
		rightArrow.setRolloverEnabled(false);
		rightArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nextLvl();
			}
		});
		_lvlSelect.add(rightArrow, FlowLayout.RIGHT);
		_buttons.add(_lvlSelect, CENTER_ALIGNMENT);
		_lvlSelect.setVisible(false);
	}

	private void nextLvl() {
		if (_lvl < 5)
			_lvl++;
		else
			_lvl = 1;
		_lvlPreview.setIcon(new ImageIcon(TowerDefence.class.getResource("/level" + _lvl + ".png")));
	}

	private void prevLvl() {
		if (_lvl > 1)
			_lvl--;
		else
			_lvl = 5;
		_lvlPreview.setIcon(new ImageIcon(TowerDefence.class.getResource("/level" + _lvl + ".png")));
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
