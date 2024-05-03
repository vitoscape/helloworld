package Task_02_0;

public class Vector {
	// Координаты вектора
	private double x;
	private double y;
	private double z;

	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// Вывод координат вектора (для проверки)
	public void printCoordinates() {
		System.out.printf("Coordinates: (%.2f, %.2f, %.2f)\n", x, y, z);
	}

	// Метод вычисления длины вектора
	public double getLength() {
		return (double) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
	}

	// Метод вычисления скалярного произведения с вектором vec
	public double dotProduct(Vector vec) {
		return x * vec.x + y * vec.y + z * vec.z;
	}

	// Метод вычисления векторного произведения с вектором vec
	public Vector crossProduct(Vector vec) {
		// Вычисление координат вектора-результата векторного произведения
		double newX = y * vec.z - z * vec.y;
		double newY = z * vec.x - x * vec.z;
		double newZ = x * vec.y - y * vec.x;

		return new Vector(newX, newY, newZ);
	}

	// Метод вычисления угла (или косинуса) между векторами
	public double getAngle(Vector vec, boolean isCos) {
		// Вычисление косинуса угла между векторами
		double cos = dotProduct(vec) / (Math.abs(getLength()) * Math.abs(vec.getLength()));

		if (isCos) return cos;	// Если требуется косинус, то возвращаем его

		return Math.acos(cos);	// Если нужен угол, то возвращаем его (в радианах)
	}

	// Метод, вычисляющий сумму векторов
	public Vector sum(Vector vec) {
		return new Vector(x + vec.x, y + vec.y, z + vec.z);
	}

	// Метод, вычисляющий разность векторов
	public Vector dif(Vector vec) {
		return new Vector(x - vec.x, y - vec.y, z - vec.z);
	}

	// Метод генерации случайных векторов в количестве n штук
	public static Vector[] generateVectors(int n) {
		Vector vectors[] = new Vector[n];	// Создание массива векторов
		for (int i = 0; i < n; i++) {		// Заполнение массива
			vectors[i] = new Vector(
					Math.random() * 100 - 50,
					Math.random() * 100 - 50,
					Math.random() * 100 - 50
			);
		}

		return vectors;
	}
}
