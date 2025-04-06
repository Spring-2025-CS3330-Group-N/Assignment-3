package edu.missouri.groupn.mlm;

import java.util.HashMap;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import edu.missouri.groupn.mlm.event.strategy.instrument.InstrumentStrategy;
import edu.missouri.groupn.mlm.event.strategy.pitch.PitchStrategy;
import edu.missouri.groupn.mlm.noteFactories.MidiEventFactory;

public class TrackBuilder {
	List<MidiEventData> eventData;
	MidiEventFactory eventFactory;
	PitchStrategy pitchStrategy;
	HashMap<Integer, InstrumentStrategy> instrumentStrategies;
	
	TrackBuilder(
		List<MidiEventData> eventData,
		MidiEventFactory eventFactory,
		PitchStrategy pitchStrategy,
		HashMap<Integer, InstrumentStrategy> instrumentStrategies
	) {
		this.eventData = eventData;
		this.eventFactory = eventFactory;
		this.pitchStrategy = pitchStrategy;
		this.instrumentStrategies = instrumentStrategies;
	}

	public Track build_track(Sequence sequence) throws InvalidMidiDataException {
		var track = sequence.createTrack();
		
		for (var channel : this.instrumentStrategies.keySet()) {
			var instrumentStrategy = this.instrumentStrategies.get(channel);
			instrumentStrategy.applyInstrument(track, channel);
		}
		
		for (var eventDatum : this.eventData) {
			// Corresponding ON and OFF events have to match
			var note = (
				this.pitchStrategy != null
				? this.pitchStrategy.modifyPitch(eventDatum.getNote())
				: eventDatum.getNote()
			);

			var event = (
				eventDatum.getNoteOnOff() == ShortMessage.NOTE_ON
				? this.eventFactory.createNoteOn(
					eventDatum.getStartEndTick(),
					note,
					eventDatum.getVelocity(),
					eventDatum.getChannel()
				)
				: this.eventFactory.createNoteOff(
					eventDatum.getStartEndTick(),
					note,
					eventDatum.getChannel()
				)
			);
			track.add(event);
		}
		
		return track;
	}
}
