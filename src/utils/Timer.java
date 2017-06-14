package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Timer implements ActionListener {
	protected LinkedList<Tickable> timedElements;
	protected javax.swing.Timer t;
	protected int gameSpeed;
	
	public Timer(){
		timedElements = new LinkedList<>();
		gameSpeed = 1;
		t = new javax.swing.Timer(1000/gameSpeed, this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Tickable tickable : timedElements) {
			tickable.tickHappened();
		}
	}
}
