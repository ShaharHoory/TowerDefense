package entities.towers;

import javax.swing.ImageIcon;

public class ArrowTower extends Tower {

	public ArrowTower(int threatArea, int attackSpeed, ImageIcon sprite) {
		super(threatArea, attackSpeed, sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initiateTowerType() {
		towerType = TowerTypes.Regular;
	}

}
