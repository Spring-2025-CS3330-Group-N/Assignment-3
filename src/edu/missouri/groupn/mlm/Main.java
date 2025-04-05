package edu.missouri.groupn.mlm;

import java.util.HashMap;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;

import edu.missouri.groupn.mlm.noteFactories.StaccatoMidiEventFactory;
import edu.missouri.groupn.mlm.event.strategy.instrument.DynamicInstrumentStrategy;
import edu.missouri.groupn.mlm.event.strategy.instrument.InstrumentStrategy;
import edu.missouri.groupn.mlm.event.strategy.pitch.NaturalPitchStrategy;
import edu.missouri.groupn.mlm.event.strategy.pitch.PitchStrategy;
import edu.missouri.groupn.mlm.noteFactories.LegatoMidiEventFactory;
import edu.missouri.groupn.mlm.noteFactories.MidiEventFactory;
import edu.missouri.groupn.mlm.noteFactories.StandardMidiEventFactory;

public class Main {
	public static void main(String[] args) {
		var noteFactory = new StandardMidiEventFactory();

		try {
			var events = MidiCsvParser.parseCsv("media/mystery_song.csv");

			var channelMap = new HashMap<Integer, InstrumentStrategy>();
			for (var event : events) {
				var instrumentStrategy = new DynamicInstrumentStrategy(event.getInstrument());
				channelMap.put(event.getChannel(), instrumentStrategy);
			}

			MidiEventFactory eventFactory = new StandardMidiEventFactory();
			PitchStrategy pitchStrategy = new NaturalPitchStrategy();

			var trackBuilder = new TrackBuilder(
				events,
				eventFactory,
				pitchStrategy,
				channelMap
			);

			var sequence = new Sequence(Sequence.PPQ, 384);
			trackBuilder.build_track(sequence);

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
