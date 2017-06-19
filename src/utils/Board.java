package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import creeps.Creep;


public class Board extends JPanel implements Tickable {
	
	private Pair[][] _directionsMat;
	private List<Creep>[][] _creepsLoc; //each cell may contains few creeps same time
	private GridBagConstraints _gbc;
	
	public Board(Pair[][] directionsMat) {
		super(new GridBagLayout());
		_gbc = new GridBagConstraints();
		_gbc.insets = new Insets(0, 0, 0, 0);
		_gbc.weightx = 25; //0 ????
		_gbc.weighty = 25; //0 ????
		_gbc.fill = GridBagConstraints.BOTH;
		_directionsMat = directionsMat;
		createMap();
		
		this.setVisible(true);

	}

	public void setDirectonsMat(Pair[][] directonsMat) {
		_directionsMat = directonsMat;
	}
	
	/* public void paint(Graphics g) {
		super.paint(g);
		
		for(int i=0; i<_directionsMat.length; i++) {
			_gbc.gridy = i;
			for (int j=0; j < _directionsMat[0].length; j++) {
				_gbc.gridx = j;
				if (_directionsMat[i][j]._x == 0 && _directionsMat[i][j]._y == 0)
					
			}
		}
	} */

	@Override
	public void tickHappened() {
		// TODO Auto-generated method stub
		
	}
	
	public void createMap(){
        JLabel label;
		for(int i=0; i<_directionsMat.length;i++){
			_gbc.gridy = i;
			for(int j=0; j<_directionsMat[i].length; j++){
				_gbc.gridx = j;
				ImageIcon backgroundImage;
				if(_directionsMat[i][j]._x!=0 || _directionsMat[i][j]._y!=0)
					backgroundImage = new ImageIcon(GameWindow.class.getResource("/floor.png"));                   
                else
                    backgroundImage = new ImageIcon(GameWindow.class.getResource("/grass.png"));
                label = new JLabel(new ImageIcon(backgroundImage.getImage().getScaledInstance(25, 25 , Image.SCALE_SMOOTH)));
                label.setPreferredSize(new Dimension(25, 25));  
                label.setVisible(true);
                add(label, _gbc);
			}
		}	
	}
}
