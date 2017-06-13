package agents;

import javax.swing.ImageIcon;

public class LavaTower extends Tower{
	
	public LavaTower(int threatArea, int attackSpeed) {
		super(threatArea, attackSpeed);
		this.type = TYPE.ASSASIN;
		icon = new ImageIcon(this.getClass().getResource("/lava"));
	}
}
