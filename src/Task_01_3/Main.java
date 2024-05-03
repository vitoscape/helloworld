package Task_01_3;/*
 * Дан массив целых чисел и ещё одно целое число.
 * Удалите все вхождения этого числа из массива (пропусков быть не должно).
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

	public static int delNum(int arr[], int delNum) {
		int deleteCnt = 0;	// Количество удаленных элементов

		for (int i = 0; i < arr.length; i++) {				// Перебор элементов
			if (arr[i] == delNum) {							// Если элемент равен удаляемому числу
				for (int j = i; j < arr.length - 1; j++) {
					arr[j] = arr[j + 1];					// Перемещение элементов на 1 позицию к 0-му элементу
				}
				i--;			// Уменьшение индекса перебора, чтобы повторения удаляемых чисел не игнорировались
				deleteCnt++;	// Увеличение количества удаленных элементов
			}
		}

		return deleteCnt;
	}

	public static void main(String args[]) throws IOException {
		final int SIZE = 20;			// Размер массива
		int array[] = new int[SIZE];	// Массив

		Random rand = new Random();		// Объект класса Random для создания случайных чисел
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	// Объект для ввода данных
		
		// Заполнение массива
		for (int i = 0; i < SIZE; i++) {
			array[i] = rand.nextInt(10);
		}

		// Вывод элементов массива
		for (int i = 0; i < SIZE; i++) {
			System.out.printf("%d\t", array[i]);
		}
		System.out.printf("\n");

		// Ввод удаляемого числа
		System.out.printf("Input nummber to delete: ");
		String deleteNumberStr = reader.readLine();				// Ввод строки
		int deleteNumber = Integer.parseInt(deleteNumberStr);	// Парсинг в число

		// Удаление числа из массива
		int deleteCnt = delNum(array, deleteNumber);	// Получение кол-ва удаленных элементов

		int newArray[] = new int[SIZE - deleteCnt];		// Новый массив

		// Перенос элементов старого массива в новый
		for (int i = 0; i < SIZE - deleteCnt; i ++) {
			newArray[i] = array[i];
		}

		// Вывод элементов обработанного массива
		for (int i = 0; i < newArray.length; i++) {
			System.out.printf("%d\t", newArray[i]);
		}
		System.out.printf("\n");
	}
}
