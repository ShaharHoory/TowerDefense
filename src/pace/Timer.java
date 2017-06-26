package pace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Timer implements ActionListener {
	private javax.swing.Timer jTimer;
	private static final int tickInterval = 1000 / 12;
	private static int actualInterval;
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

	public void notifyComponents() {
		for (Tickable tickable : timedObjects) {
			tickable.tickHappened();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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

}
