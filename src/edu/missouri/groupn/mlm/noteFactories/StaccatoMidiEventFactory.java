package edu.missouri.groupn.mlm.noteFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

/**
 * A 'factory' for creating staccato notes from non-staccato notes
 */
public class StaccatoMidiEventFactory implements MidiEventFactory {
	private StandardMidiEventFactory standardMidiEventFactory = new StandardMidiEventFactory();
	
	/**
	 * See interface for details
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		return this.standardMidiEventFactory.createNoteOn(tick, note, velocity, channel);
	}

	/**
	 * See interface for details. Makes the off event earlier.
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		return this.standardMidiEventFactory.createNoteOff(tick - 120, note, channel);
	}
}
