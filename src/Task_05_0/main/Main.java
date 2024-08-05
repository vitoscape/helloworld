/*
Постройте частотный словарь букв русского (или английского) алфавита.
Опустим проблему выбора и анализа корпуса языка, достаточно будет взять текст небольшой длины.
 */

package Task_05_0.main;

import Task_05_0.services.LetterFrequencyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

	public static void main(String args[]) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String text = reader.readLine();

		Map<Character, Double> letterFrequency = LetterFrequencyService.calculateFrequency(text);

		//System.out.print(letterFrequency);

		for (char character : letterFrequency.keySet()) {
			System.out.printf("Letter '%c' has frequency %.2f%%\n", character, letterFrequency.get(character));
		}

		reader.close();
	}
}
