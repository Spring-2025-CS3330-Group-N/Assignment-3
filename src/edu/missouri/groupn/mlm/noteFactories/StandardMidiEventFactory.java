package edu.missouri.groupn.mlm.noteFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StandardMidiEventFactory implements MidiEventFactory {
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		var event = new MidiEvent(
			new ShortMessage(
				ShortMessage.NOTE_ON,
				note,
				velocity
			),
			tick
		);
		return event;
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		var event = new MidiEvent(
			new ShortMessage(
				ShortMessage.NOTE_OFF,
				note,
				0
			),
			tick
		);
		return event;
	}
}
