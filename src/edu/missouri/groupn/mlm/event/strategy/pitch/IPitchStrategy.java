package edu.missouri.groupn.mlm.event.strategy.pitch;

public interface IPitchStrategy {
	/**
	 * This abstract method will be implemented to modify the pitch of the note passed in as an argument.
	 * @param note Note to be modified
	 * @return Modified note value
	 */
	int modifyPitch(int note);
}
