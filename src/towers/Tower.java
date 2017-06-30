package towers;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;

import creeps.Creep;
import timer.Tickable;
import utils.Visitor;

public abstract class Tower implements Visitor{
	protected int threatArea;
	public enum TYPE{
		REGULAR,
		ASSASIN
	}
	public TYPE type;
	private int attackSpeed;
	private ImageIcon icon;
	int x;
	int y;
	private int timeToShoot;
	private Color rangeColor;
	private URL towerImage;
	private URL shootingImage;

	public Tower(int threatArea, int attackSpeed , int x , int y) {
		this.threatArea = threatArea;
		this.setAttackSpeed(attackSpeed);
		this.x = x;
		this.y = y;
		setTimeToShoot(0);
	}
	
	public int getThreatArea() {
		return threatArea;
	}

	public void setThreatArea(int threatArea) {
		this.threatArea = threatArea;
	}

	public void hit(Creep creep){
		creep.impact(this);
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Color getRangeColor() {
		return rangeColor;
	}

	public void setRangeColor(Color rangeColor) {
		this.rangeColor = rangeColor;
	}

	public int getTimeToShoot() {
		return timeToShoot;
	}

	public void setTimeToShoot(int timeToShoot) {
		this.timeToShoot = timeToShoot;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public URL getShootingImage() {
		return shootingImage;
	}

	public void setShootingImage(URL shootingImage) {
		this.shootingImage = shootingImage;
	}

	public URL getTowerImage() {
		return towerImage;
	}

	public void setTowerImage(URL towerImage) {
		this.towerImage = towerImage;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	
}
