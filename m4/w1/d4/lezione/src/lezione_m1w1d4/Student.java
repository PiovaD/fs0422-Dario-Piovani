package lezione_m1w1d4;

public class Student {
	private String name;
	private int age;

	Student() {
	}

	Student(int age, String name) {
		this(age);
		this.setName(name);
	}
	
	private Student(int a) {
		this.setAge(a);
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public void setName(String name) {
		if (name.length() > 1) {
			this.name = name;
			return;
		}
		this.printError("Nome sbagliato");
	}

	public void setAge(int age) {
		if (age > 0 && age < 120) {
			this.age = age;
			return;
		}
		this.printError("Età errata");
	}

	public void hello() {
		System.out.printf("Ciao sono lo studente %s e ho %d anni %n", this.name, this.age);
	}
	
	private void printError(String msg) {
		System.err.println(msg);
	}
}
