/*
 * Задача:
 * Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
 * Для генерации случайного числа используйте метод Math.random(), который возвращает значение в промежутке [0, 1].
 */

package Task_01_0;

public class Main {

	// Функция поиска суммы элементов массива
	private static int sum(int[] array) {
		int sum = 0;                    // Сумма элементов

		// Перебор элементов массива для нахождения суммы его элементов
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		return sum;
	}

	// Функция поиска максимального значения в массиве
	public static int findMax(int[] array) {
		int max = 0;                     // Максимальное значение массива

		// Перебор элементов массива для поиска максимального значения
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) max = array[i];
		}

		return max;
	}

	// Функция поиска минимального значения в массиве
	public static int findMin(int[] array) {
		int min = findMax(array);       // Минимальное значение массива. Присваиваем максимальное для первой итерации для корректного поиска

		// Перебор элементов массива для поиска минимального значения
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) min = array[i];
		}

		return min;
	}

	// Функция поиска минимального значения в массиве
	public static double findMean(int[] array) {
		return (double) sum(array) / array.length;    // Вычисление среднего значения
	}

	public static void main(String[] args) {
		int size = 20;					// Количество элементов массива
		int[] numbers = new int[size];	// Создание массива на 20 чисел

		// Заполнение массива
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 100);
		}

		// Вывод элементов массива
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("%d\t", numbers[i]);
		}
		System.out.printf("\n");

		System.out.printf("max value is %d\n", findMax(numbers));       // Вывод максимального значения
		System.out.printf("min value is %d\n", findMin(numbers));       // Вывод минимального значения
		System.out.printf("mean value is %.2f\n", findMean(numbers));   // Вывод среднего значения
	}
}