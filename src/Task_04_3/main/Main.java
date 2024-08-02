/*
Добавьте в иерархию классов фигуру вращения для произвольной функции. Вычислять объём можно приближенное
с помощью определённого интеграла. Так как объём фигуры вращения вокруг оси x это

$V_x = \pi\int_{a}^{b} f^2(x)dx$

А интеграл это
image

Можно написать реализацию метода прямоугольников.
 */

package Task_04_3.main;

import Task_04_3.shapes.SolidOfRevolutionByFunction;
import Task_04_3.shapes.Shape;

import java.util.function.Function;

public class Main {
	public static void main(String args[]) {

		Shape shape = new SolidOfRevolutionByFunction(new Function<Double, Double>() {
			@Override
			public Double apply(Double x) {
				return Math.cos(x);
			}
		}, 0, 10);

		System.out.println(shape.getVolume());
	}
}
