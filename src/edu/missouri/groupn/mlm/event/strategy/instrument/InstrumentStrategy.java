package edu.missouri.groupn.mlm.event.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

public interface InstrumentStrategy {
	/**
	 * This abstract method will be implemented to select an instrument for a given channel on a track.
	 * @param track - the Track to which the channel belongs
	 * @param channel - the Channel to set the instrument for
	 * @throws InvalidMidiDataException - if the instrument id is not recognized
	 */
	void applyInstrument(Track track, int channel) throws InvalidMidiDataException;
}
