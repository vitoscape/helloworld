package Task_01_2;/*
 * Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
 * Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.
 */

public class Main {
	public static void main(String args[]) {
		final int START = 2;	// Нижняя граница промежутка
		final int FINAL = 100;	// Верхняя граница промежутка

		// Нахождение простых чисел
		for (int i = START; i <= FINAL; i++) {
			boolean isSimple = true;	// Флаг, обозначающий, простое ли число
			//int divider = 2;			// Делитель

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isSimple = false;
					break;
				}
			}

			if (isSimple) System.out.printf("%d\t", i);
		}
	}
}
