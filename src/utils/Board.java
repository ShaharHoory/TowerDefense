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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import creeps.Creep;
import towers.ArrowTower;
import towers.Tower;


public class Board extends JPanel implements Tickable{
	
	private Pair[][] _directionsMat;
	private List<Creep>[][] _creepsLoc; //each cell may contains few creeps same time
	private Tower[][] _towersLoc;
	
	public Pair[][] getDirectionsMat() {
		return _directionsMat;
	}

	public List<Creep>[][] getCreepsLoc() {
		return _creepsLoc;
	}

	public Tower[][] getTowersLoc() {
		return _towersLoc;
	}
	private GridBagConstraints _gbc;
	
	public Board(Pair[][] directionsMat) {
		super(new GridBagLayout());
		_gbc = new GridBagConstraints();
		_gbc.insets = new Insets(0, 0, 0, 0);
		_gbc.fill = GridBagConstraints.BOTH;
		_directionsMat = directionsMat;
		_towersLoc = new Tower[_directionsMat.length][directionsMat[0].length];
		createMap();
		this.setVisible(true);

	}

	public void setDirectonsMat(Pair[][] directonsMat) {
		_directionsMat = directonsMat;
	}
	
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
	public void showTowerArea(Graphics g , Tower t , int x , int y){
		int threatArea = t.getThreatArea();
		g.setColor(Color.BLUE);
		for(int i=-threatArea; i<=threatArea; i++){
			for(int j=-threatArea; j<=threatArea; j++){
				if (i!=0 || j!=0){
					if(x+threatArea>=0 && x+threatArea<=_directionsMat.length && y+threatArea>=0 && y+threatArea<=_directionsMat.length)
						g.drawRect((x+i)*25, (y+j)*25, 25, 25);
				}
			}
		}
			
	}
	
	//paints the creeps
	public void paintCreeps(Graphics g) {
		for(int i=0; i<_creepsLoc.length; i++)
			for(int j=0; j<_creepsLoc[i].length; i++) {
				for(Creep creep: _creepsLoc[i][j]) { //for every creep in each cell
					ImageIcon icon = creep.getIcon();
					g.drawImage(icon.getImage(), (800*i)/32, (800*j)/32, null);// ??? or 25
				}
			}
	}
}
