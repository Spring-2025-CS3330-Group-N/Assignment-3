package edu.missouri.groupn.mlm.noteFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public class StaccatoMidiEventFactory implements MidiEventFactory {
	private StandardMidiEventFactory standardMidiEventFactory = new StandardMidiEventFactory();
	
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		return this.standardMidiEventFactory.createNoteOn(tick, note, velocity, channel);
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		return this.standardMidiEventFactory.createNoteOff(tick - 120, note, channel);
	}
}
