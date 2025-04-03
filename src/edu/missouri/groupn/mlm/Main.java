package edu.missouri.groupn.mlm;

import java.util.HashMap;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("do you hear the music?");
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

			for (var event : events) {
				track.add(
					new MidiEvent(
						new ShortMessage(
							event.getNoteOnOff(),
							event.getNote(),
							event.getVelocity()
						),
						event.getStartEndTick()
					)
				);
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
