package Task_04_0;

public class Pyramid extends Shape {
	private double s;	// The base of the pyramid
	private double h;	// The height of the pyramid

	public Pyramid(double s, double h) {
		super(s * h / 3);			// Pyramid volume formula as parameter for parent class constructor
		this.s = s;
		this.h = h;
	}
}
