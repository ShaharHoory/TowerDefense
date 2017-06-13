package entities.towers;

import javax.swing.ImageIcon;

public class GokuTower extends Tower {

	public GokuTower(int threatArea, int attackSpeed, ImageIcon sprite) {
		super(threatArea, attackSpeed, sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initiateTowerType() {
		towerType = TowerTypes.Regular;
	}

}
