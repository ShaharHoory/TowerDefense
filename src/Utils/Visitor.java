package Utils;
import Creeps.*;
import agents.Creep;

public interface Visitor {

	public void visit(Guli g);
	public void visit(Knight k);
	public void visit (Mike m);
	public void visit (Naji n);
	
}
