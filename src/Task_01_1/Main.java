package Task_01_1;
/*
 * Реализуйте алгоритм сортировки пузырьком для сортировки массива
 */

public class Main {

	public static void bubbleSort(int array[]) {
		boolean sortedFlag = false;	// Флаг, показывающий, отсортирован ли массив

		// Цикл, работающий, пока осуществляется перестановка элементов
		while (!sortedFlag) {
			sortedFlag = true;	// Установка флага

			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					sortedFlag = false;    // Сброс флага

					// Swap элементов с помощью XOR
					array[i] ^= array[i + 1];
					array[i + 1] ^= array[i];
					array[i] ^= array[i + 1];
				}
			}
		}
	}

	public static void main(String args[]) {
		int size = 20;					// Количество элементов массива
		int numbers[] = new int[size];	// Создание массива на 20 чисел

		// Заполнение массива
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 100);
		}

		// Вывод элементов массива
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("%d\t", numbers[i]);
		}
		System.out.printf("\n");

		bubbleSort(numbers);	// Сортировка пузырьком

		// Вывод элементов массива (отсортированный)
		System.out.printf("sorted array:\n");
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("%d\t", numbers[i]);
		}
		System.out.printf("\n");
	}
}
