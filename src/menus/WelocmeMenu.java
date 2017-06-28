package menus;
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
	protected JPanel _buttons;
	protected JPanel _lvlSelect;
	protected JLabel _lvlPreview;
	protected int _lvl;

	public WelocmeMenu() {
		super();
		this.setLayout(new BorderLayout(30,100));
		this.setPreferredSize(new Dimension(800, 800));
		this.setMaximumSize(getPreferredSize());
		this.setMinimumSize(getPreferredSize());
		this.setSize(getPreferredSize());
		this.setBackground(Color.lightGray);
		_headline = new JLabel("Tower Defence");
		_headline.setFont(new Font("Tahoma", Font.BOLD, 100));
		_headline.setVisible(true);
		_headline.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(_headline, BorderLayout.NORTH);
		initializeButtons();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _playButton) {
			_playButton.setVisible(false);
			_exitButton.setVisible(false);
			//_levelSelect.setVisible(true);
			_lvlSelect.setVisible(true);
			_backButton.setVisible(true);
			_startButton.setVisible(true);
		}
		if (e.getSource() == _backButton) {
			_playButton.setVisible(true);
			_exitButton.setVisible(true);
			//_levelSelect.setVisible(false);
			_lvlSelect.setVisible(false);
			_backButton.setVisible(false);
			_startButton.setVisible(false);
		}
	}

	private void initializeButtons() {
		_buttons = new JPanel();
		initializeLvlSelect();
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
		this.add(_buttons);
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
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); 
		_buttons.add(b, CENTER_ALIGNMENT);
		_buttons.add(Box.createVerticalStrut(25));
		//b.setBounds(b.getBounds().x, b.getBounds().y, 200, 100);
	}

	/*private void initializeLevelSelect() {
		Vector<Integer> levels = new Vector<Integer>();
		for (int i = 1; i<=5; i++)
			levels.add(new Integer(i));
		this._levelSelect = new JComboBox<>(levels);
		_levelSelect.setFont(new Font("Tahoma", Font.PLAIN, 24));
		_buttons.add(_levelSelect);
		Dimension size = new Dimension(100, 50);
		_levelSelect.setMinimumSize(size);
		_levelSelect.setMaximumSize(size);
		_levelSelect.setVisible(false);
	}*/
	
	private void initializeLvlSelect() {
		_lvlSelect = new JPanel();
		_lvlSelect.setLayout(new FlowLayout());
		_lvlSelect.setMaximumSize(new Dimension(800, 225));
		_lvlSelect.setBackground(new Color(0, 0, 0, 0));
		JButton leftArrow = new JButton();
		ImageIcon leftArrowIcon = new ImageIcon("icons/leftArrow.jpg");
		leftArrow.setIcon(leftArrowIcon);
		leftArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prevLvl();
			}
		});
		leftArrow.setMinimumSize(new Dimension(leftArrowIcon.getIconWidth(), leftArrowIcon.getIconHeight()));
		leftArrow.setMaximumSize(new Dimension(leftArrowIcon.getIconWidth(), leftArrowIcon.getIconHeight()));
		leftArrow.setSize(100,100);
		_lvlSelect.add(leftArrow, FlowLayout.LEFT);
		_lvl = 1;
		_lvlPreview = new JLabel(new ImageIcon("icons/level1.png"));
		//_lvlPreview.setBackground(Color.WHITE);
		//_lvlPreview.setMinimumSize(new Dimension(300, 300));
		//_lvlPreview.setHorizontalTextPosition(SwingConstants.CENTER);
		//_lvlPreview.setVerticalTextPosition(SwingConstants.CENTER);
		//_lvlPreview.setMaximumSize(new Dimension(300, 300));
		//_lvlPreview.setSize(getMaximumSize());
		_lvlSelect.add(_lvlPreview, FlowLayout.CENTER);
		JButton rightArrow = new JButton();
		rightArrow.setIcon(new ImageIcon("icons/rightArrow.jpg"));
		rightArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nextLvl();
			}
		});
		_lvlSelect.add(rightArrow, FlowLayout.RIGHT);
		_buttons.add(_lvlSelect);
		_lvlSelect.setVisible(false);
	}
	
	private void nextLvl() {
		if (_lvl<5)
			_lvl++;
		else
			_lvl = 1;
		_lvlPreview.setIcon(new ImageIcon("icons/level"+_lvl+".png"));
		_lvlPreview.repaint();
		this.revalidate();
		this.repaint();
	}
	
	private void prevLvl() {
		if (_lvl>1)
			_lvl--;
		else
			_lvl=5;
		_lvlPreview.setIcon(new ImageIcon("icons/level"+_lvl+".png"));
		_lvlPreview.repaint();
		this.revalidate();
		this.repaint();
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
