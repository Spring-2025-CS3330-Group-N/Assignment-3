package edu.missouri.groupn.mlm;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.sound.midi.ShortMessage;

public class MidiCsvParser {
	/**
	 * Parses an event name
	 * @param eventName - the name of the event in the CSV
	 * @return - the MIDI message type
	 * @throws ParseException - if the event name is not recognized
	 */
	private static int parseEventType(String eventName) throws ParseException {
		if (eventName.equals("Note_on_c")) {
			return ShortMessage.NOTE_ON;
		}
		
		if (eventName.equals("Note_off_c")) {
			return ShortMessage.NOTE_OFF;
		}
		
		throw new ParseException("Event type \"" + eventName +  "\" not recognized", 0);
	}

	/**
	 * Parses a single line of the CSV file
	 * @param line
	 * @return - the event described by that line
	 * @throws ParseException - if the line has too few values or if an event type is unrecognized
	 */
	private static MidiEventData parseLine(String line) throws ParseException {
		var items = line.split(", ?");

		if (items.length < 6) {
			throw new ParseException("Line \"" + line + "\" has too few values!", 0);
		} else if (items.length > 6) {
			System.err.println("Line \"" + line + "\" has too many values!");
		}

		var startEndTick = Integer.parseInt(items[0]);
		var onOff = MidiCsvParser.parseEventType(items[1]);
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

	/**
	 * Parses a CSV file containing data in the format specified by the assignment
	 * @param filename - the path to the file to be parsed
	 * @return - the events contained in the parsed file
	 * @throws FileNotFoundException - if the path does not resolve
	 * @throws ParseException - if the file cannot be parsed
	 */
	public static List<MidiEventData> parseCsv(String filename) throws FileNotFoundException, ParseException {
		var events = new ArrayList<MidiEventData>();

		try (var buffer = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = buffer.readLine()) != null) {
				var event = MidiCsvParser.parseLine(line);
				events.add(event);
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			// since we're only reading it doesn't matter if we can't close the file
		}
		
		return events;
	}
}
