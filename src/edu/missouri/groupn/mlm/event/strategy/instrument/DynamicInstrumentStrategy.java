package edu.missouri.groupn.mlm.event.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * An implementation of the instrument strategy for applying any instrument
 *   defined by the MIDI standard
 */
public class DynamicInstrumentStrategy implements InstrumentStrategy {
	private int instrument;

	public DynamicInstrumentStrategy(int instrument) {
		this.instrument = instrument;
	}
	
	/**
	 * See interface for details. Adds a MIDI event to the track to set the
	 *   voice for a particular channel
	 */
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		track.add(
			new MidiEvent(
				new ShortMessage(
					ShortMessage.PROGRAM_CHANGE | channel,
					this.instrument,
					0
				),
				0
			)
		);
	}
}
