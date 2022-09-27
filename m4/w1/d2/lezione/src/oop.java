
public class oop {
	public static void main(String[] arg) {

		Student s1 = new Student();
		s1.name = "Mario";
		s1.lastName = "Rossi";
		s1.age = 25;
		s1.votes = new byte[] { 8, 10, 9, 8, 1 };
		s1.sayHello();
		s1.sayHello2();
		s1.printArr();

		Student s2 = new Student("Anna", "Bianchi", 23, new byte[] { 8, 10, 9, 8, 1 });
		s2.sayHello();
		s2.sayHello2();
		s2.printArr();

		Student s3 = new Student("An", "B", 23, new byte[] { 8, 10, 9, 8, 1 });

		System.out.println(Student.school);
		System.out.println(s3.school);

		s2.school = "EpicodeSchool";
		System.out.println(Student.school);
		System.out.println(s3.school);

		String st1 = "epicode";
		String st2 = new String("epicode");
		String st3 = "epicode";
		String st4 = new String("epicode");

		System.out.println(st1 == st2); // false
		System.out.println(st2.equals(st1)); // true

		System.out.println(st1 == st3); // true

		System.out.println(st4 == st2); // false
		System.out.println(st2.equals(st4)); // true

		Student s5 = new Student("An", "Bxz", 23, new byte[] { 8, 10, 9, 8, 1 });
		Student s6 = new Student("An", "Bxz", 23, new byte[] { 8, 10, 9, 8, 1 });

		System.out.println(s5 == s6);
		System.out.println(s5.equals(s6)); // va implementato equals
		
		System.out.println("" + s1.id + s2.id + s3.id + s6.id + s5.id);

	}

}

class Student {

	String name;
	String lastName;
	int age;
	int id;
	byte[] votes;

	static String school = "Epicode";
	
	private static int internId = 0;

	Student() {
		setId();
	};

	Student(String name, String lastName, int age, byte[] votes) {
		
		setId();
		
		if (checkMinLength(name, 2)) {
			this.name = name;
		} else {
			printError("nome", "troppo corto");
		}

		if (checkMinLength(lastName, 2)) {
			this.lastName = lastName;
		} else {
			printError("cognome", "troppo corto");
		}

		if (checkAge(age, 22, 90)) {
			this.age = age;
		} else {
			printError("eta", "fuori range");
		}

		this.votes = votes;
	}

	private boolean checkMinLength(String s, int l) {
		return (s.length() >= l) ? true : false;
	};

	private boolean checkAge(int val, int max, int min) {
		return (val >= min && val <= max);
	}

	private void printError(String field, String message) {
		System.out.println("Warning " + field + " " + message);
	}

	void sayHello() {
		System.out.println("Ciao sono uno studente e mi chiamo " + this.name);

	}

	void sayHello2() {

		System.out.printf("Ciao sono uno studente e mi chiamo %s %s (e ho %d anni) e i miei voti sono: %n", this.name,
				this.lastName, this.age);

		for (int i = 0; i < this.votes.length; i++) {
			System.out.println("voto " + (i + 1) + ": " + this.votes[i]);
		}
	}

	void printArr() {
		System.out.println(java.util.Arrays.toString(this.votes));
	}

	@Override
	public boolean equals(Object obj) {

		Student another = (Student) obj;
		return (this.name.equals(another.name) && this.lastName.equals(another.lastName) && this.age == another.age);

	}

	private void setId() {
		this.id = internId++;
	}
}