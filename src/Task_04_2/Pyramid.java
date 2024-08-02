package Task_04_2;

public class Pyramid implements Shape {
	private double height;
	private double s;		// The base of the pyramid

	public Pyramid(double height, double s) {
		this.height = height;
		this.s = s;
	}

	@Override
	public double getVolume() {
		return height * s * 4 / 3;
	}
}
