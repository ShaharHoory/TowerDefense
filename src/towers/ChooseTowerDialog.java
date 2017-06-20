package towers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.*;

public class ChooseTowerDialog extends JDialog {
	Game _game;
	JPanel _towerPanel;
	
	public ChooseTowerDialog(Game game){
		setLayout(new GridBagLayout());
		_game = game;
		_towerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(_towerPanel , gbc);
		pack();
		
		for (String str : _game.getTowersLeft().keySet()) {
			ImageIcon towerPic = new ImageIcon(GameWindow.class.getResource("/"+str+".png"));
			JLabel label = new JLabel(towerPic);
			_towerPanel.add(label, gbc);
			gbc.gridx++;
			label.setVisible(true);
		}	
		_towerPanel.setVisible(true);
		this.setVisible(true);
	}	
}
