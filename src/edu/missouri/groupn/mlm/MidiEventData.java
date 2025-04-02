package edu.missouri.groupn.mlm;

/**
 * This class contains the required data for MIDI events.
 * It includes getters and setters for each class member. 
 */
public class MidiEventData {
	/**
	 * Required members for MIDI event data as per assignment specifications.
	 */
	private int startEndTick, velocity, note, channel, noteOnOff;
	private int instrument;
	
	/**
	 * Parameterized constructor for MidiEventData as per assignment specifications.
	 * @param startEndTick 
	 * @param velocity
	 * @param note
	 * @param channel
	 * @param noteOnOff
	 * @param instrument
	 */
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int noteOnOff, int instrument) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.noteOnOff = noteOnOff;
		this.instrument = instrument;
	}

	/**
	 * This getter method returns an integer with the startEndTick value of the MIDI event it's called upon.
	 * @return MIDI event's startEndTick value
	 */
	public int getStartEndTick() {
		return startEndTick;
	}

	/**
	 * This setter method updates the startEndTick value of the MIDI event it's called upon with the passed argument's value.
	 * @param startEndTick The startEndTick value to be set for a MIDI event
	 */
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	/**
	 * This getter method returns an integer with the velocity value of the MIDI event it's called upon.
	 * @return MIDI event's velocity value
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * This setter method updates the velocity value of the MIDI event it's called upon with the passed argument's value.
	 * @param velocity The velocity value to be set for a MIDI event
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	/**
	 * This getter method returns an integer with the note value of the MIDI event it's called upon.
	 * @return MIDI event's note value
	 */
	public int getNote() {
		return note;
	}

	/**
	 * This setter method updates the note value of the MIDI event it's called upon with the passed argument's value.
	 * @param note The note value to be set for a MIDI event
	 */
	public void setNote(int note) {
		this.note = note;
	}

	/**
	 * This getter method returns an integer with the channel value of the MIDI event it's called upon.
	 * @return MIDI event's channel value
	 */
	public int getChannel() {
		return channel;
	}

	/**
	 * This setter method updates the channel value of the MIDI event it's called upon with the passed argument's value.
	 * @param channel The channel value to be set for a MIDI event
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}

	/**
	 * This getter method returns an integer with the noteOnOff value of the MIDI event it's called upon.
	 * @return MIDI event's noteOnOff value
	 */
	public int getNoteOnOff() {
		return noteOnOff;
	}

	/**
	 * This setter method updates the noteOnOff value of the MIDI event it's called upon with the passed argument's value.
	 * @param noteOnOff The noteOnOff value to be set for a MIDI event
	 */
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

	/**
	 * This getter method returns an integer with the instrument value of the MIDI event it's called upon.
	 * @return MIDI event's instrument value
	 */
	public int getInstrument() {
		return instrument;
	}

	/**
	 * This setter method updates the instrument value of the MIDI event it's called upon with the passed argument's value.
	 * @param instrument The instrument value to be set for a MIDI event
	 */
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
	
}
