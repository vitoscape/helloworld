package Task_05_0.services;

import java.util.*;
import java.util.Map.Entry;

public class LetterFrequencyService {

	private static Map<Character, Double> sortByComparator(Map<Character, Double> unsortMap, final boolean order) {
		List<Entry<Character, Double>> list = new LinkedList<>(unsortMap.entrySet());

		// Sorting the list based on values
		list.sort((o1, o2) -> {
			if (order) {
				return o1.getValue().compareTo(o2.getValue());
			} else {
				return o2.getValue().compareTo(o1.getValue());

			}
		});

		// Maintaining insertion order with the help of LinkedList
		Map<Character, Double> sortedMap = new LinkedHashMap<>();
		for (Entry<Character, Double> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	static public Map<Character, Double> calculateFrequency(String text) {

		HashMap<Character, Double> frequencyMap = new HashMap<>();

		int totalLetters = 0;

		for (int i = 0; i < text.length(); i++) {

			char currentChar = Character.toLowerCase(text.charAt(i));

			if (Character.isLetter(currentChar)) {
				if (frequencyMap.containsKey(currentChar)) {                                // If map already contains this char
					frequencyMap.put(currentChar, frequencyMap.get(currentChar) + 1);       // then increment its counter
				} else {                                                                    // else
					frequencyMap.put(currentChar, (double) 1);                              // set counter to 1
				}

				totalLetters++;
			}
		}

		for (char character : frequencyMap.keySet()) {
			frequencyMap.replace(character, frequencyMap.get(character) / (double) totalLetters * 100.0);
		}

		return sortByComparator(frequencyMap, false);
	}
}
