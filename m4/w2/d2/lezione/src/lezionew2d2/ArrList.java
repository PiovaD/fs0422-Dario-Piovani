package lezionew2d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrList {

	@SuppressWarnings("removal")
	public static void main(String[] args) {

		ArrayList<String> words = new ArrayList<>();

		words.add("Hello");
		words.add("world");
		words.add("!");

		System.out.println(words);

		Person p1 = new Person("Mario", 20);
		Person p2 = new Person("Luigi", 25);

		ArrayList<Person> people = new ArrayList<>();

		people.add(p1);
		people.add(p2);

		@SuppressWarnings("unchecked")
		ArrayList<Person> peopleClone = (ArrayList<Person>) people.clone();

		System.out.println(people == peopleClone);

		peopleClone.get(0).name = "gino";
		System.out.println(people);
		System.out.println(peopleClone);

		System.out.println(words.contains("world"));

		System.out.println(people.contains(p1));

		words.remove(0);
		System.out.println(words);

		people.remove(p1);
		System.out.println(people);
		System.out.println(peopleClone);

		ArrayList<Integer> numbers = new ArrayList<>();

		numbers.add(145);
		numbers.add(-97);
		numbers.add(32);
		numbers.add(11);
		numbers.add(2);
		numbers.add(68);

		System.out.println(numbers);
		
		numbers.remove(2);
		System.out.println(numbers);
		
		numbers.remove(new Integer(2));
		System.out.println(numbers);
		
		List<String> words2 = new ArrayList<>();
		
		parseList(words2);
		
		
		ArrayList<ArrayList<String>> l2 = new ArrayList<>();
		
		l2.add(new ArrayList<>(Arrays.asList("red","blue","green")));
		l2.add(new ArrayList<>(Arrays.asList("white","green","black")));
		l2.add(new ArrayList<>(Arrays.asList("rainbow")));
		
		for (int i = 0; i < l2.size(); i++) {
			for (int j = 0; j < l2.get(i).size(); j++) {
				
				System.out.println(l2.get(i).get(j));
				
			}
		}

	}
	
	static void parseList(List<String> list) {
		
	}

}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;

		return this.name.equals(p.name) && this.age == p.age;
	}
}
