package Task_04_0;

public class Box extends Shape {
	private double a;
	private double b;
	private double c;
	private double freeVolume;

	public Box(double a, double b, double c) {
		super(a * b * c);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public boolean add(Shape shape) {
		// TODO: Make add() method.
	}
}
