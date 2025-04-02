package edu.missouri.groupn.mlm.event.strategy.pitch;

public class LowerPitchStrategy implements IPitchStrategy {

	/**
	 * This modifyPitch method implementation decreases the pitch of the note passed in as an argument.
	 */
	@Override
	public int modifyPitch(int note) {
		// decrement note value by 2
		return 0;
	}

}
