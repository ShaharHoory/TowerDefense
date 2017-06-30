package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import gameLayers.GameTowers;

public class Timer implements ActionListener {
	protected LinkedList<Tickable> timedElements;
	protected javax.swing.Timer t;
	public static final int NORMAL_TICK = 100;
	private int tick;
	private int numOfTicks;
	
	public Timer(){
		timedElements = new LinkedList<>();
		setTick(NORMAL_TICK);
		t = new javax.swing.Timer(getTick(), this);
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
		setTick(NORMAL_TICK/2);
		t.setDelay(getTick());
	}
	
	public void regularSpeed(){
		setTick(NORMAL_TICK);
		t.setDelay(getTick());
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
		setTick(NORMAL_TICK);
		t.setDelay(getTick());
	}
	
	public String toString(){
		int seconds = (int)(((double)NORMAL_TICK/1000) * numOfTicks);
		if(seconds%60<10 && seconds/60<10)
			return "0"+(seconds/60)+":0"+(seconds%60);
		else if(seconds%60<10)
			return (seconds/60)+":0"+(seconds%60);
		else if(seconds/60<10)
			return "0"+(seconds/60)+":"+(seconds%60);
		else
			return (seconds/60)+":"+(seconds%60);
		
	}

	public int getTick() {
		return tick;
	}

	public void setTick(int tick) {
		this.tick = tick;
	}
}
