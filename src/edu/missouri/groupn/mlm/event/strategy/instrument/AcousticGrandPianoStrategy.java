package edu.missouri.groupn.mlm.event.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

/**
 * This concrete class is an implementation for the InstrumentStrategy interface.
 */
public class AcousticGrandPianoStrategy implements InstrumentStrategy {
	private InstrumentStrategy strategy = new DynamicInstrumentStrategy(0);

	/**
	 * This applyInstrument method implementation selects the acoustic grand piano to be played for a given channel on a track using the provided arguments.
	 * @throws InvalidMidiDataException
	 */
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		this.strategy.applyInstrument(track, channel);
	}
}
