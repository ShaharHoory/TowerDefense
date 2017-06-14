package entities;

import entities.creeps.*;

public interface Visitor {
	public void attack(Skull attacked);

	public void attack(MikeW attacked);

	public void attack(Knight attacked);

	public void attack(Naji attacked);
}
