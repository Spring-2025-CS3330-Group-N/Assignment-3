package edu.missouri.groupn.mlm.event.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class DynamicInstrumentStrategy implements InstrumentStrategy {
	private int instrument;

	public DynamicInstrumentStrategy(int instrument) {
		this.instrument = instrument;
	}
	
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
