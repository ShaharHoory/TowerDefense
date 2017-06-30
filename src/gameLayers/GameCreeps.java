package gameLayers;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import creeps.Creep;
import timer.Tickable;
import timer.Timer;
import utils.Pair;

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
		Image image;
		for (Creep creep : creeps) {
			if(creep._x<31.99999){
				if(creep.isDirection()){
					if(creep.isWalking()){
						creep.setIcon(new ImageIcon(creep.getRightW()));
						image = creep.getIcon().getImage();
						creep.setWalking(!creep.isWalking());
					}
					else{
						creep.setIcon(new ImageIcon(creep.getRightS()));
						image = creep.getIcon().getImage();
						creep.setWalking(!creep.isWalking());
					}
				}
				else{
					if(creep.isWalking()){
						creep.setIcon(new ImageIcon(creep.getLeftW()));
						image = creep.getIcon().getImage();
						creep.setWalking(!creep.isWalking());
					}
					else{
						creep.setIcon(new ImageIcon(creep.getLeftS()));
						image = creep.getIcon().getImage();
						creep.setWalking(!creep.isWalking());
					}
				}
				//g.drawOval((int)(creep._x*25), (int)(creep._y*25), 20, 20);
				g.drawImage(image, (int)(creep._x*25) , (int)(creep._y*25) , 20 , 20 , this);	
			}
		}
	}

	@Override
	public void tickHappened() {
		for (Creep creep : creeps) {
			Pair moveTo = _directionsMat[creep.getBoardY()][creep.getBoardX()];
			if(moveTo.get_x()>0){ //right
				double moveX = creep._x+creep.getSpeed()*((double)Timer.NORMAL_TICK/1000);
				creep._x = moveX;	
				if((int)(creep._x+0.00001)>creep.getBoardX())
					creep.setBoardX(creep.getBoardX() + 1);	
				creep.setDirection(true);				
			}
			else if(moveTo.get_x()<0){ //left
				double moveX = creep._x-creep.getSpeed()*((double)Timer.NORMAL_TICK/1000);
				creep._x = moveX;	
				if((Math.ceil((creep._x-0.00001))<creep.getBoardX()))
					creep.setBoardX(creep.getBoardX() - 1);
				creep.setDirection(false);
			}
			else if (moveTo.get_y()>0){ //down
				double moveY = creep._y+creep.getSpeed()*((double)Timer.NORMAL_TICK/1000);
				creep._y = moveY;	
				if((int)(creep._y+0.00001)>creep.getBoardY())
					creep.setBoardY(creep.getBoardY() + 1);	
			}
			else { //up
				double moveY = creep._y-creep.getSpeed()*((double)Timer.NORMAL_TICK/1000);
				creep._y = moveY;	
				if((Math.ceil((creep._y-0.00001))<creep.getBoardY()))
					creep.setBoardY(creep.getBoardY() - 1);
			}		
			creep.steps+=creep.getSpeed()*((double)Timer.NORMAL_TICK/1000);
			if(creep.get_poisoningTimeLeft()>0){
				creep.set_poisoningTimeLeft(creep.get_poisoningTimeLeft()-Timer.NORMAL_TICK);
			}
			if(creep.get_poisoningTimeLeft()<=0){
				creep.set_poisoningTimeLeft(0);
				creep.setPoisoningPower(1);
			}
			if(creep.get_slowTimeLeft()>0){
				creep.set_slowTimeLeft(creep.get_slowTimeLeft()-Timer.NORMAL_TICK);
				System.out.println("slow time: "+creep.get_slowTimeLeft());
			}
			if(creep.get_slowTimeLeft()<=0){
				creep.set_slowTimeLeft(0);
				creep.setSpeed(creep.INIT_SPEED);
			}
				
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
