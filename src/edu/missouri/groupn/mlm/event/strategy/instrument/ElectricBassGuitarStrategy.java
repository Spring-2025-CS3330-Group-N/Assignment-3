package edu.missouri.groupn.mlm.event.strategy.instrument;

import javax.sound.midi.Track;

/**
 * This concrete class is an implementation for the InstrumentStrategy interface.
 */
public class ElectricBassGuitarStrategy implements InstrumentStrategy {

	/**
	 * This applyInstrument method implementation selects the electric bass guitar to be played for a given channel on a track using the provided arguments.
	 */
	@Override
	public void applyInstrument(Track track, int channel) {
		// assigns electric bass guitar (finger) -- MIDI instrument 33

	}

}
