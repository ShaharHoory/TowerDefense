package towers;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import towers.*;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javafx.scene.control.RadioButton;
import utils.*;

public class ChooseTowerDialog extends JDialog implements ActionListener{
	Game _game;
	JPanel _towerPanel;
	int _x;
	int _y;
	
	public ChooseTowerDialog(Game game , int x , int y){
		setLayout(new GridBagLayout());
		_game = game;
		_towerPanel = new JPanel(new GridBagLayout());
		_x = x;
		_y = y;
		this.setPreferredSize(new Dimension(550, 350));
		this.pack();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets = new Insets(5, 5, 5, 5);
		setResizable(false);
		this.add(_towerPanel , gbc);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (screenSize.getWidth() / 2) - 300 / 2, (int) (screenSize.getHeight() / 2) - 300 / 2);
		
		for (String str : _game.getGameTowers().getTowersLeft().keySet()) {
			gbc.gridy=0;
			ImageIcon towerPic = new ImageIcon(GameWindow.class.getResource("/"+str+".png"));
			towerPic = new ImageIcon(towerPic.getImage().getScaledInstance((getWidth()/9), getHeight()/4, Image.SCALE_SMOOTH));
			JButton selectTower = new JButton(towerPic);
			selectTower.setName(str.replaceAll("\\s+", ""));
			selectTower.setContentAreaFilled(false);
			selectTower.setOpaque(false);
			selectTower.setPreferredSize(new Dimension(getWidth()/9+10, getHeight()/4));
			if( _game.getGameTowers().getTowersLeft().get(str).equals(0))
				selectTower.setEnabled(false);
			_towerPanel.add(selectTower, gbc);
			selectTower.addActionListener(this);
			JLabel name = new JLabel();
			name.setText(str);
			gbc.gridy=1;
			_towerPanel.add(name , gbc);
			gbc.gridy=2;
			JLabel towersLeft = new JLabel();
			towersLeft.setText(_game.getGameTowers().getTowersLeft().get(str).toString() +" Left");
			towersLeft.setFont(new Font("arial", Font.BOLD, 16));
			_towerPanel.add(towersLeft, gbc);
			gbc.gridx++;
		}	
		_towerPanel.setVisible(true);
		this.setVisible(true);
	}	
	
	@Override
	public void actionPerformed(ActionEvent a) {
			JButton towerSelected = ((JButton)a.getSource());
			GameTowers gt = _game.getGameTowers();
			try {
				Class<?> clazz = Class.forName("towers."+towerSelected.getName());
				Constructor<?> ctor = clazz.getConstructors()[0];
				Tower object = (Tower) ctor.newInstance(_x , _y);				
				gt.placeTower(object);
//				Object[] options = {"Place" , "Cancel"};
//				int selected = JOptionPane.showOptionDialog(this, "The tower can't be moved after it has been placed", "Place tower", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//				if (selected != 0){
//					_game.get_board().get_towersLoc()[object.y][object.x] = null;
//				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
	}	
}
