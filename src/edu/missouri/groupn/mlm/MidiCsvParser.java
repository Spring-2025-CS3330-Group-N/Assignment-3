package edu.missouri.groupn.mlm;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.midi.ShortMessage;

public class MidiCsvParser {
	private static MidiEventData parseLine(String line) {
		// TODO: handle bad input!
		var items = line.split(", ?");
		var startEndTick = Integer.parseInt(items[0]);
		var onOff = items[1].equals("Note_on_c")? ShortMessage.NOTE_ON : ShortMessage.NOTE_OFF; // TODO: more possible bad inputs
		var channel = Integer.parseInt(items[2]);
		var note = Integer.parseInt(items[3]);
		var velocity = Integer.parseInt(items[4]);
		var instrument = Integer.parseInt(items[5]);
		
		var event = new MidiEventData(
			startEndTick,
			velocity,
			note,
			channel,
			onOff,
			instrument
		);
		return event;
	}

	static List<MidiEventData> parseCsv(String filename) {
		var events = new ArrayList<MidiEventData>();

		try (var buffer = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = buffer.readLine()) != null) {
				var event = MidiCsvParser.parseLine(line);
				events.add(event);
			}
		} catch (FileNotFoundException e) {
			// couldn't open
		} catch (IOException e) {
			// couldn't close
		}
		
		return events;
	}
}
