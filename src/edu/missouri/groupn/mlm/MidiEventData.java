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

	public int getStartEndTick() {
		return startEndTick;
	}

	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getNoteOnOff() {
		return noteOnOff;
	}

	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

	public int getInstrument() {
		return instrument;
	}

	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}	
}
