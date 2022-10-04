package lezionew2d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ordinamento {

	public static void main(String[] args) {

		ArrayList<String> words = new ArrayList<>(Arrays.asList("albero", "mela", "epicode", "java"));
		
		Collections.sort(words, new StringLengthComparator());
		
		System.out.println(words);
		
		ArrayList<Person> people = new  ArrayList<>(
				Arrays.asList(
						new Person("mario",20),
						new Person("luigi",30),
						new Person("peach",22),
						new Person("wario",50)
						)
				);
				
		System.out.println("pre ordinamento" + people);
		
		Collections.sort(people, new PersonComparator());
		System.out.println("post ordinamento" + people);
		
		Collections.sort(people, new PersonComparator() {
			@Override
			public int compare(Person o1, Person o2) {
				return super.compare(o1, o2) * -1;
			}
		});
		System.out.println("post ordinamento 2" + people);
		
		
	}

}


class StringLengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		int o1L = o1.length();
		int o2L = o2.length();
		
		if(o1L > o2L ) return 1;
		else if(o1L < o2L ) return -1;
		
		char o1C = o1.charAt(0);
		char o2C = o2.charAt(0);
		

		if(o1C > o2C ) return 1;
		else if(o1C < o2C ) return -1;		
		
		return 0;
	}
	
}

class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		
		if(o1.age > o2.age ) return 1;
		else if(o1.age < o2.age) return -1;		
		
		return 0;
	}
	
}