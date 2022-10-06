package lambda;

public class Lam {
	public static void main(String[] args) {

		Shape s = new Rectangle();
		printAreaOfShape(s, 5, 10);

		printAreaOfShape(new Shape() {
			@Override
			public void printArea(int x, int y) {
				System.out.println(x * y);
			}
		}, 10, 5);

	}

	public static void printAreaOfShape(Shape s, int x, int y) {
		s.printArea(x, y);
	}

}

@FunctionalInterface
interface Shape {
	public abstract void printArea(int x, int y);
}

class Rectangle implements Shape {

	@Override
	public void printArea(int x, int y) {
		System.out.println(x * y);
	}

}