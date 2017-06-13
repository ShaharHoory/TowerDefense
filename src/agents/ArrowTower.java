package agents;

import javax.swing.ImageIcon;

public class ArrowTower extends Tower{
	 public ArrowTower (int threatArea, int attackSpeed) {
		super(threatArea, attackSpeed);
		this.type = TYPE.REGULAR;
		icon = new ImageIcon(this.getClass().getResource("/arrow"));
	}
}
