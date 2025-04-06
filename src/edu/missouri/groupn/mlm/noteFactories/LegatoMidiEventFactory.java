package edu.missouri.groupn.mlm.noteFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

/**
 * A 'factory' for creating legato notes from non-legato notes
 */
public class LegatoMidiEventFactory implements MidiEventFactory {
	private StandardMidiEventFactory standardMidiEventFactory = new StandardMidiEventFactory();

	/**
	 * See interface for details.
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		return this.standardMidiEventFactory.createNoteOn(tick, note, velocity, channel);
	}

	/**
	 * See interface for details. Makes the off event later.
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		return this.standardMidiEventFactory.createNoteOff(tick + 80, note, channel);
	}
}
