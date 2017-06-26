package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import towers.GameTowers;

public class Timer implements ActionListener {
	protected LinkedList<Tickable> timedElements;
	protected javax.swing.Timer t;
	public static final int NORMAL_TICK = 100;
	protected int tick;
	private int numOfTicks;
	
	public Timer(){
		timedElements = new LinkedList<>();
		tick = NORMAL_TICK;
		t = new javax.swing.Timer(tick, this);
		numOfTicks = 0;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		numOfTicks++;
		notifyEveryone();
	}
	
	public void register(Tickable t){
		timedElements.add(t);
	}
	
	public void unregister(Tickable t){
		timedElements.remove(t);
	}
	
	public void start(){
		t.start();
	}
	
	public void fastForward(){
		tick = NORMAL_TICK/2;
		t.setDelay(tick);
	}
	
	public void regularSpeed(){
		tick = NORMAL_TICK;
		t.setDelay(tick);
	}
	
	public void notifyEveryone(){
		for (Tickable tickable : timedElements) {
			tickable.tickHappened();
		}
	}

	public int getNumOfTicks() {
		return numOfTicks;
	}

	public void setNumOfTicks(int numOfTicks) {
		this.numOfTicks = numOfTicks;
	}

	public void stop() {
		t.stop();	
		tick = NORMAL_TICK;
		t.setDelay(tick);
	}
}
