package agents;

import javax.swing.ImageIcon;

public class PoisonTower extends Tower{
	public PoisonTower(int threatArea, int attackSpeed) {
		super(threatArea, attackSpeed);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/poison"));
	}
}
