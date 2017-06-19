package utils;

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
import javax.swing.JPanel;

import creeps.Creep;
import towers.Tower;


public class Board extends JPanel implements Tickable , MouseListener {
	
	private Pair[][] _directionsMat;
	private List<Creep>[][] _creepsLoc; //each cell may contains few creeps same time
	private Tower[][] _towersLoc;
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
		this.addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		int yLoc = e.getY()/25;
		int xLoc = e.getX()/25;
		if(_directionsMat[yLoc][xLoc]._x!=0 || _directionsMat[yLoc][xLoc]._y!=0)
			System.out.println("can't put towers on tiles");
		//TODO: show a message box
		else if(_towersLoc[yLoc][xLoc]!=null){
			//show its shooting range
		}
		else{
			//open a menu showing all the available towers
		}
			
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// if not part of tile: change picture to "selected grass tile"
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// if not part of tile: change picture back to "unselected grass tile"
		
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
