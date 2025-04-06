package edu.missouri.groupn.mlm.noteFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * A 'factory' for making MIDI events. Doesn't apply any changes.
 */
public class StandardMidiEventFactory implements MidiEventFactory {
	/**
	 * See the interface for details.
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		var event = new MidiEvent(
			new ShortMessage(
				ShortMessage.NOTE_ON | channel,
				note,
				velocity
			),
			tick
		);
		return event;
	}

	/**
	 * See the interface for details.
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		var event = new MidiEvent(
			new ShortMessage(
				ShortMessage.NOTE_OFF | channel,
				note,
				0
			),
			tick
		);
		return event;
	}
}
