package guiComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import run.TowerDefence;
import utilities.Constants;

public class BoardPresentation extends JPanel {
	public BoardPresentation(boolean[][] blocksPartition) {
		setSize(new Dimension(Constants.BOARD_SIZE, Constants.BOARD_SIZE));
		setLayout(new GridBagLayout());
		setBackground(Color.black);
		createBoard(blocksPartition);
	}

	public void createBoard(boolean[][] blocksPartition) {
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel block;
		for (int i = 0; i < blocksPartition.length; i++) {
			for (int j = 0; i < blocksPartition[i].length; j++) {
				gbc.gridy = i;
				gbc.gridx = j;
				ImageIcon blockImage;
				if (blocksPartition[i][j])
					blockImage = new ImageIcon(TowerDefence.class.getResource("/floor.jpeg"));
				else
					blockImage = new ImageIcon(TowerDefence.class.getResource("/grass.jpg"));
				block = new JLabel(blockImage);
				block.setBorder(new MatteBorder(0, 0, 1, 1, Color.BLACK));
				block.setPreferredSize(new Dimension(Constants.BLOCK_SIZE, Constants.BLOCK_SIZE));
				add(block, gbc);
			}
		}

	}
}
