package game;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entities.towers.Tower;
import guiComponents.BoardPresentation;
import guiComponents.CreepsPresentation;
import guiComponents.GameToolbar;
import guiComponents.TowerSelectionDialog;
import guiComponents.TowersPresentation;
import pace.Timer;

public class Game extends JPanel implements MouseListener, ActionListener {
	public Timer timer;
	public Board board;
	public BoardPresentation boardGUI;
	public CreepsPresentation gameCreeps;
	public TowersPresentation gameTowers;
	public GameStats gameStats;
	public GameToolbar gameToolbar;

	public Game(Board board, Timer timer) {
		super(new BorderLayout());
		this.timer = timer;
		this.board = board;
		boardGUI = new BoardPresentation(board.blocksPartition());
		gameCreeps = new CreepsPresentation(this.board.getDirectionMatrix());
		gameTowers = new TowersPresentation(gameCreeps.creeps);
		gameToolbar = new GameToolbar(this);
		this.add(boardGUI, BorderLayout.CENTER);
		boardGUI.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point toPlace = new Point(e.getX(), e.getY());
		Tower towerAt = gameTowers.getTowerAt(toPlace);
		if (towerAt != null) {
			gameTowers.setOnFocus(towerAt);
			gameTowers.repaint();
		} else {
			if (!gameStats.isWave) {
				if (board.isFloor(toPlace.x, toPlace.y))
					JOptionPane.showMessageDialog(this, "You may put towers only on grass tiles!", "Error", 0);
				else {
					TowerSelectionDialog selectionDialog = new TowerSelectionDialog(this, toPlace);
				}
			} else {
				gameTowers.setOnFocus(null);
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
