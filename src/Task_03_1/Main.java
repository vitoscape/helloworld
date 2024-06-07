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

		if (Math.signum((float) f(left)) != Math.signum((float) f(right))) {				// Проверка на разные знаки значений функций в left и right
			System.out.printf("Signs are not equal. Continue...\n");						// Знаки разные, продолжаем
		} else {
			System.out.printf("Signs are equal. Another borders of segment are required.");	// Знаки одинаковые, ошибка
			exit(0);
		}

		double x = 0;
		double center = 0;						// Центр отрезка

		// Производим вычисления до определенной точности
		while (Math.abs(right - left) > accuracy) {
			center = (left + right) / 2;	// Новый центр отрезка
			if (f(left) * f(center) <= 0) right = center;
			else {
				left = center;
				x = (left + right) / 2;
			}
		}

		return x;
	}

	public static void main(String args[]) {
		int leftBorder = 0;		// Нижняя граница отрезка
		int rightBorder = 10;	// Верхняя граница отрезка

		// Вывод корня уравнения
		double root = halfSegment(leftBorder, rightBorder, 0.001);
		System.out.printf("Root: f(%.2f) = %.3f\n", root, f(root));
	}
}
