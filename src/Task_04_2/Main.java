/*
Реализуйте ту же иерархию классов, но использовав интерфейсы.
Дополнительно, студентам предлагается реализовать интерфейс Comparable.
 */

package Task_04_2;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String args[]) {

		Ball ball = new Ball(4.5);
		Cylinder cylinder = new Cylinder(2, 2);
		Pyramid pyramid = new Pyramid(100, 100);

		Box box = new Box(1000);

		System.out.println(box.add(ball));
		System.out.println(box.add(cylinder));
		System.out.println(box.add(pyramid));

		ArrayList<Shape> shapes = box.getShapes();
		Collections.sort(shapes);
	}
}
