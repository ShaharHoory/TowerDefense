package run;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entities.towers.Tower;
import gameMap.Board;
import gameMap.GameStats;
import guiComponents.BoardPresentation;
import guiComponents.CreepsPresentation;
import guiComponents.TowerSelectionDialog;
import guiComponents.TowersPresentation;
import pace.Timer;

public class Game extends JPanel implements MouseListener {
	protected Timer timer;
	protected Board board;
	protected BoardPresentation boardGUI;
	public CreepsPresentation gameCreeps;
	public TowersPresentation gameTowers;
	protected GameStats gameStats;

	public Game(Board board, Timer timer) {
		super(new BorderLayout());
		this.timer = timer;
		this.board = board;
		boardGUI = new BoardPresentation(board.blocksPartition());
		gameCreeps = new CreepsPresentation(this.board.getDirectionMatrix());
		gameTowers = new TowersPresentation(gameCreeps.creeps);
		this.add(boardGUI, BorderLayout.CENTER);
		this.setVisible(true);
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

}
