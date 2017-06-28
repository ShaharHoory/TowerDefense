package guiComponents;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import run.Game;
import run.TowerDefence;

public class TowerSelectionDialog extends JDialog implements ActionListener {

	Game game;
	JPanel selectionPanel;
	Point location;
	GridBagConstraints constraints;

	public TowerSelectionDialog(Game game, Point location) {
		setLayout(new GridBagLayout());
		selectionPanel = new JPanel(new GridBagLayout());
		this.game = game;
		this.location = location;
		constraints = new GridBagConstraints();
		this.setPreferredSize(new Dimension(550, 350));
		this.pack();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(5, 5, 5, 5);
		setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) (screenSize.getWidth() / 2) - 300 / 2, (int) (screenSize.getHeight() / 2) - 300 / 2);
		initiateselectionPanelPresentation();
		this.add(selectionPanel, constraints);
		selectionPanel.setVisible(true);
		this.setVisible(true);

	}

	private void initiateselectionPanelPresentation() {
		for (String towerName : game.gameTowers.towersAvailable.keySet()) {
			constraints.gridy = 0;
			ImageIcon towerImage = new ImageIcon(TowerDefence.class.getResource("/" + towerName + ".png"));
			ImageIcon editedTowerImage = new ImageIcon(
					towerImage.getImage().getScaledInstance((getWidth() / 9), getHeight() / 4, Image.SCALE_SMOOTH));
			JButton chosenTower = new JButton(editedTowerImage);
			chosenTower.setContentAreaFilled(false);
			chosenTower.setOpaque(false);
			chosenTower.setPreferredSize(new Dimension(getWidth() / 9 + 10, getHeight() / 4));
			boolean isLeft = game.gameTowers.towersAvailable.get(towerName).equals(0);
			if (isLeft)
				chosenTower.setEnabled(false);
			selectionPanel.add(chosenTower, constraints);
			chosenTower.addActionListener(this);
			JLabel towerNameText = new JLabel(towerName);
			constraints.gridy = 1;
			selectionPanel.add(towerNameText, constraints);
			constraints.gridy = 2;
			JLabel towersLeft = new JLabel(game.gameTowers.towersAvailable.get(towerName).toString() + " Left");
			towersLeft.setFont(new Font("Times New Roman", Font.BOLD, 18));
			selectionPanel.add(towersLeft, constraints);
			constraints.gridx++;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
