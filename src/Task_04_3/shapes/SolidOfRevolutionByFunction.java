package Task_04_3.shapes;

import java.util.function.Function;

public class SolidOfRevolutionByFunction extends SolidOfRevolution {

	private Function<Double, Double> function;
	private double a;
	private double b;

	public SolidOfRevolutionByFunction(Function<Double, Double> function, double a, double b) {
		super(b - a);
		this.function = function;
		this.a = a;
		this.b = b;
	}

	@Override
	public double getVolume() {
		double sum = 0;
		int iterations = 10000;
		double delta = (b - a) / iterations;

		for (int i = 0; i < iterations; i++) {
			double x = a + ((b - a) * i / iterations);
			sum += Math.pow(function.apply(x), 2) * delta;
		}

		return Math.PI * sum;
	}
}
