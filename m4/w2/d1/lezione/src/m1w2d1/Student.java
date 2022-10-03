package m1w2d1;

public class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		setName(name);
		setAge(age);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return "name: " + this.name + ", età: " + this.age;
	}
}
