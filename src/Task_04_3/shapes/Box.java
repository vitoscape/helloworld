package Task_04_3.shapes;

import java.util.ArrayList;

public class Box implements Shape {
	private ArrayList<Shape> shapes = new ArrayList<>();
	private double available;
	private double volume;

	public Box(double available) {
		this.available = available;
		this.volume = available;
	}

	public boolean add(Shape shape) {
		if (available >= shape.getVolume()) {
			shapes.add(shape);
			available -= shape.getVolume();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double getVolume() {
		return volume;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}
}
