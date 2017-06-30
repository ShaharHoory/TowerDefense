package gameLayers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister.Pack;

import creeps.Creep;
import timer.Tickable;
import towers.ArrowTower;
import towers.Tower;
import utils.Pair;


public class Board extends JPanel{
	
	Pair[][] _directionsMat;
	private GridBagConstraints _gbc;
	private int startX;
	private int startY;
	
	public Board(Pair[][] directionsMat) {
		super(new GridBagLayout());
		
		_gbc = new GridBagConstraints();
		_gbc.insets = new Insets(0, 0, 0, 0);
		_gbc.fill = GridBagConstraints.BOTH;
		_directionsMat = directionsMat;
		setSize(800, 800);
		createMap();
		setVisible(true);
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
	
	public void createMap(){
        JLabel label;
		for(int i=0; i<_directionsMat.length;i++){
			_gbc.gridy = i;
			for(int j=0; j<_directionsMat[i].length; j++){
				_gbc.gridx = j;
				ImageIcon backgroundImage;
				if(_directionsMat[i][j].get_x()!=0 || _directionsMat[i][j].get_y()!=0){
					backgroundImage = new ImageIcon(GameWindow.class.getResource("/floor.png"));
					if(j==0){
						startX = j;
						startY = i;
					}						
				}
                else
                    backgroundImage = new ImageIcon(GameWindow.class.getResource("/grass.png"));
                label = new JLabel(new ImageIcon(backgroundImage.getImage().getScaledInstance(25, 25 , Image.SCALE_SMOOTH)));
                label.setPreferredSize(new Dimension(25, 25));  
                label.setVisible(true);
                add(label, _gbc);
			}
		}	
	}	

	public Pair[][] getDirectonsMat() {
		return _directionsMat;
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}
	
	public boolean isInBoard(int x , int y){
		return x<31.99999 && x>=0 && y>=0 && y<31.999;
	}
}
