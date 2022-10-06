package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Str {
	public static void main(String[] args) {
		Stream<String> s1 = Arrays.stream(new String[] { "prima", "seconda", "terza" });

		s1.forEach(System.out::println);

		Stream<String> s2 = Stream.<String>builder()
				.add("epicode")
				.add("java")
				.add("back-end")
				.build();

		s2.forEach((el) -> System.out.println("L'elemento è: " + el));

		Stream.generate(() -> "elemento")
				.limit(2)
				.forEach(el -> System.out.println(el));

		Stream.iterate(1, n -> n + 1)
				.limit(10)
				.forEach(System.out::println);

		List<String> words = new ArrayList<>(Arrays.asList("epicode", "java", "back-end"));
		Stream<String> s3 = words.stream();
		s3.filter(s -> s.charAt(0) == 'j')
				.forEach(s -> System.out.println("El: " + s));

		List<Student> students = new ArrayList<>(Arrays.asList(new Student("Mario", new int[] { 8, 6, 4, 7 }),
				new Student("Luigi", new int[] { 3, 6, 4, 5 }), new Student("Daisy", new int[] { 8, 6, 9, 5 }),
				new Student("Peach", new int[] { 2, 2, 4, 1 })));

		System.out.println("Studenti promossi: ");
		students.stream()
				.filter(st -> st.getAvg() >= 6)
				.forEach(st -> System.out.println(st.name + " "));

		// map
		List<String> words2 = new ArrayList<>(Arrays.asList("epicode", "java", "back-end"));
		Stream<String> s4 = words2.stream();
		s4.map(s -> s.toUpperCase())
				.filter(s -> s.charAt(0) == 'J')
				.forEach(s -> System.out.println("el: " + s));

	}
}

class Student {
	String name;
	int[] votes;

	Student(String name, int[] votes) {
		this.name = name;
		this.votes = votes;
	}

	double getAvg() {
		double sum = 0;

		for (int num : this.votes) {
			sum += num;
		}

		return sum / this.votes.length;
	}

}