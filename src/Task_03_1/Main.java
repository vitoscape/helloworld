/*
Найдите корень уравнения

$cos(x^5) + x^4 - 345.3 * x - 23 = 0$
на отрезке [0; 10] с точностью по x не хуже, чем 0.001. Известно, что на этом промежутке корень единственный.
Используйте для этого метод деления отрезка пополам (и рекурсию).
 */

package Task_03_1;

import static java.lang.System.exit;

public class Main {

	// Метод функции уравнения
	private static double f(double x) {
		return (double) (Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23);
	}

	// Метод деления отрезка пополам
	public static double halfSegment(double left, double right, double accuracy) {
		// Проверка на разные знаки значений функций в left и right
		if (Math.signum((float) f(left)) != Math.signum((float) f(right))) {
			System.out.printf("Signs are not equal. Continue...\n");	// Знаки разные, продолжаем
		} else {
			System.out.printf("Signs are equal. Another borders of segment are required.");	// Знаки одинаковые, ошибка
			// TODO: Добавить возврат ошибки
			exit(0);
		}

		double segmentLength = right - left;	// Длина отрезка
		double center = 0;						// Центр отрезка

		// Производим вычисления до определенной точности
		while (segmentLength > accuracy) {
			segmentLength /= 2;				// Длина новых отрезков
			center = left + segmentLength;	// Новый центр отрезка

			// TODO: Проанализировать значение функции в центре
		}
	}

	public static void main(String args[]) {
		int leftBorder = 0;		// Нижняя граница отрезка
		int rightBorder = 10;	// Верхняя граница отрезка

		// Вывод значений функции на границах отрезка
		System.out.printf("f(%d) = %.2f\nf(%d) = %.2f\n", leftBorder, f(leftBorder), rightBorder, f(rightBorder));
	}
}
