/*
Реализуйте ту же иерархию классов, но использовав интерфейсы.
Дополнительно, студентам предлагается реализовать интерфейс Comparable.
 */

package Task_04_2;

public class Main {
	public static void main(String args[]) {
		Box box = new Box(3, 3, 3);    // Box volume 27
		System.out.printf("Box volume = %f\n", box.getVolume());

		// Only one shape
		//Cylinder cylinder = new Cylinder(2, 2); // True
		//Cylinder cylinder = new Cylinder(3, 2); // False

		// Some shapes
		Cylinder cylinder = new Cylinder(1, 2);
		Pyramid pyramid = new Pyramid(5, 5);
		Ball ball = new Ball(1.8);
		//SolidOfRevolution solidOfRevolution = new SolidOfRevolution(1.2, 1.3);	// Error because this class is abstract
		// Same with Shape class


		System.out.printf("Cylinder volume = %f\n", cylinder.getVolume());
		System.out.printf("Pyramid volume = %f\n", pyramid.getVolume());
		System.out.printf("Ball volume = %f\n", ball.getVolume());
		System.out.println(box.add(cylinder));
		System.out.println(box.add(pyramid));
		System.out.println(box.add(ball));
	}
}
