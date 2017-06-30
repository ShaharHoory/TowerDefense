package pace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

public class Timer implements ActionListener {
	private javax.swing.Timer jTimer;
	public static final int tickInterval = 1000 / 12;
	public static int actualInterval;
	private LinkedList<Tickable> timedObjects;
	public int ticksAccumulator;

	public Timer() {
		jTimer = new javax.swing.Timer(tickInterval, this);
		actualInterval = tickInterval;
		timedObjects = new LinkedList<Tickable>();
		ticksAccumulator = 0;
	}

	public void register(Tickable t) {
		timedObjects.add(t);
	}

	public void unregister(Tickable t) {
		timedObjects.remove(t);
	}

	public void unregister(LinkedList<Tickable> t) {
		timedObjects.removeAll(t);
	}

	public void notifyComponents() {
		int size = timedObjects.size(); 
		for (int i=0; i<size; i++){
			Tickable timedObject = timedObjects.get(i);
            timedObject.tickHappened();
		}
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ticksAccumulator++;
		notifyComponents();
	}

	public void start() {
		jTimer.start();
	}

	public void stop() {
		jTimer.stop();
		actualInterval = tickInterval;
		jTimer.setDelay(actualInterval);
	}

	public void normalSpeed() {
		actualInterval = tickInterval;
		jTimer.setDelay(actualInterval);
	}

	public void fastForward() {
		actualInterval = tickInterval / 2;
		jTimer.setDelay(actualInterval);
	}

	public int getTicksAccumulator() {
		return ticksAccumulator;
	}

	public void setTicksAccumulator(int ticksAccumulator) {
		this.ticksAccumulator = ticksAccumulator;
	}

	public String toString() {// hh:mm:ss
		int seconds = (int) (((double) tickInterval / 1000) * ticksAccumulator);
		if (seconds % 60 < 10 && seconds / 60 < 10)
			return "0" + (seconds / 60) + ":0" + (seconds % 60);
		else if (seconds % 60 < 10)
			return (seconds / 60) + ":0" + (seconds % 60);
		else if (seconds / 60 < 10)
			return "0" + (seconds / 60) + ":" + (seconds % 60);
		else
			return (seconds / 60) + ":" + (seconds % 60);

	}

}
