package effects;

public abstract class Effect {
	private int timeRemaining;
	private EffectType type;
	private double effectParam;

	public Effect(int timeRemaining, EffectType type, double effectParam) {
		this.timeRemaining = timeRemaining;
		this.type = type;
		this.effectParam = effectParam;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int t) {
		timeRemaining -= t;
	}

	public EffectType getType() {
		return type;
	}

	public double getEffectParam() {
		return effectParam;
	}
	
	

}
