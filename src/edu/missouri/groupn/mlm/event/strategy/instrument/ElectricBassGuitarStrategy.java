package edu.missouri.groupn.mlm.event.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

/**
 * This concrete class is an implementation for the InstrumentStrategy interface.
 */
public class ElectricBassGuitarStrategy implements InstrumentStrategy {
	private InstrumentStrategy strategy = new DynamicInstrumentStrategy(33);

	/**
	 * This applyInstrument method implementation selects the electric bass guitar to be played for a given channel on a track using the provided arguments.
	 * @throws InvalidMidiDataException
	 */
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		this.strategy.applyInstrument(track, channel);
	}
}
