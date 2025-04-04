package edu.missouri.groupn.mlm;

import java.util.HashMap;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;

import edu.missouri.groupn.mlm.noteFactories.StandardMidiEventFactory;

public class Main {
	public static void main(String[] args) {
		var noteFactory = new StandardMidiEventFactory();

		try {
			var events = MidiCsvParser.parseCsv("media/mystery_song.csv");
			
			var channelMap = new HashMap<Integer, Integer>();
			for (var event : events) {
				channelMap.put(event.getChannel(), event.getInstrument());
			}
			
			var sequence = new Sequence(Sequence.PPQ, 384);

			var track = sequence.createTrack();
			for (var channel : channelMap.keySet()) {
				track.add(
					new MidiEvent(
						new ShortMessage(
							ShortMessage.PROGRAM_CHANGE,
							0,
							channelMap.get(channel)
						),
						0
					)
				);
			}

			for (var event_datum : events) {
				var event = (
					event_datum.getNoteOnOff() == ShortMessage.NOTE_ON
					? noteFactory.createNoteOn(event_datum.getStartEndTick(), event_datum.getNote(), event_datum.getVelocity(), event_datum.getChannel())
					: noteFactory.createNoteOff(event_datum.getStartEndTick(), event_datum.getNote(), event_datum.getChannel())
				);
				track.add(event);
			}
			
			var sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			
			while (sequencer.isRunning()) {
				Thread.sleep(100);
			}
			
			sequencer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
