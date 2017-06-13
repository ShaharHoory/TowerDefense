package towers;

import javax.swing.ImageIcon;

import Creeps.Guli;
import Creeps.Knight;
import Creeps.Mike;
import Creeps.Naji;
import agents.Creep;
import agents.Tower;

public class LavaTower extends Tower{
	
	public LavaTower(int threatArea, int attackSpeed) {
		super(threatArea, attackSpeed);
		this.type = TYPE.ASSASIN;
		icon = new ImageIcon(this.getClass().getResource("/lava"));
	}

	@Override
	public void visit(Guli g) {
				
	}

	@Override
	public void visit(Knight k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Mike m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Naji n) {
		// TODO Auto-generated method stub
		
	}
}
