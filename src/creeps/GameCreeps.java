package creeps;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import utils.Pair;
import utils.Tickable;
import utils.Timer;

import java.awt.Image;

public class GameCreeps extends JComponent implements Tickable {
	protected Timer timer;
	protected Pair[][] _directionsMat;
	protected LinkedList<Creep> addedCreeps;
	protected LinkedList<Creep> creeps;
	
	public GameCreeps(Pair[][] directionsMat , Timer timer){
		addedCreeps = new LinkedList<>();
		creeps = new LinkedList<>();
		_directionsMat = directionsMat;
		this.timer = timer;
		setLocation(0, 0);
        setBounds(0, 0, 800, 800);
		setSize(new Dimension(800, 800));
		setPreferredSize(new Dimension(800, 800));
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Creep creep : creeps) {
			if(creep._x<31.99999){
				ImageIcon icon = creep.getIcon();
				Image image = icon.getImage();
				//g.drawOval((int)(creep._x*25), (int)(creep._y*25), 20, 20);
				g.drawImage(image, (int)(creep._x*25) , (int)(creep._y*25) , 20 , 20 , this);	
				System.out.println("painted creep: "+creep._x+" "+creep._y+" ");
			}
		}
	}

	@Override
	public void tickHappened() {
		for (Creep creep : creeps) {
			int currX = (int)creep._x;
			int currY = (int)creep._y;
			Pair moveTo = _directionsMat[currY][currX];
			if(moveTo.get_x()>0){ //right
				double boardX = creep._x+creep.getSpeed()*((double)Timer.NORMAL_TICK/1000);
				creep._x = boardX;	
			}
			else if(moveTo.get_x()<0){ //left
				double boardX = creep._x-creep.getSpeed()*((double)Timer.NORMAL_TICK/1000);
				creep._x = boardX;	
			}
			else if (moveTo.get_y()>0){ //down
				double boardY = creep._y+creep.getSpeed()*((double)Timer.NORMAL_TICK/1000);
				creep._y = boardY;	
			}
			else { //up
				double boardY = creep._y-creep.getSpeed()*((double)Timer.NORMAL_TICK/1000);
				creep._y = boardY;	
			}		
			creep.steps+=creep.getSpeed()*((double)Timer.NORMAL_TICK/1000);
			System.out.println("creep moved from: "+currX+" , "+currY);	
			System.out.println(creep.getHp());
		}
		repaint();		
	}
	
	public LinkedList<Creep> getCreeps(){
		return this.creeps;
	}

	public LinkedList<Creep> getAddedCreeps() {
		return addedCreeps;
	}
}
