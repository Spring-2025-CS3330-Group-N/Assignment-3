package edu.missouri.groupn.mlm.event.strategy.pitch;

public class HigherPitchStrategy implements IPitchStrategy {
	/**
	 * This modifyPitch method implementation increases the pitch of the note passed in as an argument.
	 */
	@Override
	public int modifyPitch(int note) {
		// increment note value by 2
		return 0;
	}

}
