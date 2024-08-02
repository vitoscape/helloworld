package Task_04_3.shapes;

class Ball extends SolidOfRevolution {

	@Override
	public double getVolume() {
		return Math.PI * Math.pow(radius, 3) * 4 / 3;
	}

	public  Ball(double radius) {
		super(radius);
	}
}
