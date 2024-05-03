package Task_02_1;

import java.util.ArrayList;

import java.util.Arrays;

public class WeightRandom {


	// Более быстрый вариант, но требует больше памяти

	private ArrayList<Integer> array;	// ArrayList для хранения значений
	private int weightSum = 0;			// Сумма весов значений

	public WeightRandom(int values[], int weights[]) {
		// Если массивы разной длины, то программа завершается
		if (weights.length != values.length) {
			System.out.printf("Error: different array lengths.");
			System.exit(0);
		}

		array = new ArrayList<>();
		for (int i = 0; i < weights.length; i++) {
			weightSum += weights[i];	// Вычисление суммы весов

			// Добавление значения в ArrayList столько раз, сколько оно "весит"
			for (int j = 0; j < weights[i]; j++) {
				array.add((Integer) values[i]);
			}
		}
	}

	// Метод вывода ArrayList на экран
	public void printArray() {
		System.out.println(array.toString());
	}

	// Метод возвращает значение с учетом его веса:
	// чем больше вес значения, тем больше шансов, что оно вернется
	public int getValue() {
		int randomWeight = (int) (Math.random() * (weightSum));	// Случайный индекс
		//System.out.printf("(%d)\n", randomWeight);

		return array.get(randomWeight);
	}


	/*
	// Более медленный вариант, но требует меньше памяти

	private int[] values; // значения
	private int[] weights; // веса
	private int[] ranges; // левые границы отрезков
	private int sum; // общая длина всех отрезков

	public WeightRandom(int[] values, int[] weights) {
		this.values = values;
		this.weights = weights;
		ranges = new int[values.length];

		// Сумма длин всех отрезков
		sum = 0;
		for (int weight : weights) {
			sum += weight;
		}

		// Заполняем ranges, левыми границами
		int lastSum = 0;
		for (int i = 0; i < ranges.length; i++) {
			ranges[i] = lastSum;
			lastSum += weights[i];
		}
	}

	public int getValue() {
		int random = (int) (Math.random() * (sum - 1));

		int index = Arrays.binarySearch(ranges, random);
		return values[index >= 0 ? index : -index - 2];
	}
	*/
}