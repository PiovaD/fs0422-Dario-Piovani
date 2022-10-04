package lezionew2d2;

public class Day2 {

	public static void main(String[] args) {
		Animal obj1 = new Dog();

		obj1.corri();
	}

}

class Animal {
	public void corri() {
		System.out.println("Animale");
	}
}

class Dog extends Animal {
	public void corri() {
		System.out.println("cane");
	}
}