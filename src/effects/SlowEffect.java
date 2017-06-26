package effects;

public class SlowEffect extends Effect {

	public SlowEffect(int timeRemaining) {
		super(timeRemaining, EffectType.Slow, 0.5);
	}

}
