package Task_04_2;

class Cylinder extends SolidOfRevolution {

	private double height;

	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}

	@Override
	public double getVolume() {
		return Math.PI * radius * radius * height;
	}
}
