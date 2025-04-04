package edu.missouri.groupn.mlm.event.strategy.instrument;

import javax.sound.midi.Track;

public interface InstrumentStrategy {
	/**
	 * This abstract method will be implemented to select an instrument for a given channel on a track.
	 * @param track Track to be played
	 * @param channel Channel from the track chosen for instrument selection
	 */
	void applyInstrument(Track track, int channel);
}
