package edu.missouri.groupn.mlm.event.strategy.pitch;

public class NaturalPitchStrategy implements PitchStrategy {
	@Override
	public int modifyPitch(int note) {
		return note;
	}
}
