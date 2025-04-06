package edu.missouri.groupn.mlm.noteFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

/**
 * A 'factory' for modifying and creating notes
 */
public interface MidiEventFactory {
	/**
	 * Creates a note on event.
	 * @param tick - the point in the sequence that the note starts
	 * @param note - the pitch of the note measured in semitones - Middle C is 60
	 * @param velocity - some weird number that controls volume
	 * @param channel - an identifier (between 0-15) for channel to play the note on
	 * @return - a midi event that activates the specified note
	 * @throws InvalidMidiDataException
	 */
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	
	/**
	 * Creates a note off event.
	 * @param tick - the point in the sequence that the note stops
	 * @param note - the pitch of the note measured in semitones - Middle C is 60
	 * @param channel - an identifier (between 0-15) for channel the note was playing on
	 * @return - a midi event that terminates the specified note
	 * @throws InvalidMidiDataException
	 */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
