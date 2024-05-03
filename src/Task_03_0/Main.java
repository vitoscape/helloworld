/*
Двоичный поиск
Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
Используйте перебор и двоичный поиск для решения этой задачи.
Сравните время выполнения обоих решений для больших массивов (например, 100000000 элементов).
 */

/*
ВЫВОД:
бинарный поиск работает быстрее, что в начале массива, что в середине, что в конце.
 */

package Task_03_0;

public class Main {
	// Метод перебора
	public static int enumerationSearch(int sortedArray[], int targetNumber) {
		for (int i = 0; i < sortedArray.length; i++) {
			if (sortedArray[i] == targetNumber) {	// Сравнение элемента с искомым числом
				return i;
			}
		}
		return -1;	// Ошибка, индекс не найден
	}

	// Метод двоичного поиска
	public static int binarySearch(int sortedArray[], int targetNumber) {
		int leftBorder = 0;							// Левая граница массива
		int rightBorder = sortedArray.length - 1;	// Правая граница массива

		while (leftBorder <= rightBorder) {
			int center = (leftBorder + rightBorder) / 2;	// Вычисление центра участка между границами

			if (sortedArray[center] == targetNumber) {		// Индекс целевого значения найден
				return center;
			} else if (targetNumber < sortedArray[center]) {	// Если целевое значение больше значения в центре массива,
				rightBorder = center - 1;						// то смещаем правую границу в центр и вычитаем 1, так как центральное значение мы уже рассмотрели.
			} else leftBorder = center + 1;						// Иначе смещаем левую границу в центр и прибавляем 1 по той же причине
		}

		return -1; // Ошибка, индекс не найден
	}

	public static void main(String args[]) {
		final int SIZE = 100000000;		// Размер массива
		final int SHIFT = 0;			// Смещение
		int array[] = new int[SIZE];	// Массив
		//int desiredNumber = 67324532;	// Искомое число
		//int desiredNumber = 34;		// Искомое число
		int desiredNumber = 90000000;	// Искомое число

		// Заполнение массива
		for (int i = 0; i < SIZE; i++) {
			array[i] = i + SHIFT;
		}

		// Вывод массива
//		for (int i = 0; i < SIZE; i++) {
//			System.out.printf("%d\t", array[i]);
//		}
//		System.out.printf("\n");


		///////////// Метод перебора
		long time = System.nanoTime();							// Засекаем время
		int result = enumerationSearch(array, desiredNumber);
		System.out.printf("[%10d ns]\t", System.nanoTime() - time);	// Вывод времени работы алгоритма

		if (result != -1) {
			System.out.printf("Desired number at %d index (enumeration search)\n", result);    // Вывод индекса искомого числа
		} else System.out.printf("Array does not contain a number %d\n", desiredNumber);



		///////////// Метод двоичного поиска
		time = System.nanoTime();							// Засекаем время
		result = binarySearch(array, desiredNumber);
		System.out.printf("[%10d ns]\t", System.nanoTime() - time);	// Вывод времени работы алгоритма

		if (result != -1) {
			System.out.printf("Desired number at %d index (binary search)\n", result);    // Вывод индекса искомого числа
		} else System.out.printf("Array does not contain a number %d\n", desiredNumber);
	}
}
