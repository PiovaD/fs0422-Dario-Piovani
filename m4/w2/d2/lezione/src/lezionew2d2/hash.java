package lezionew2d2;

import java.util.HashSet;
import java.util.Iterator;

public class hash {

	public static void main(String[] args) {

		HashSet<String> s1 = new HashSet<>();

		s1.add("primo");
		s1.add("secondo");
		s1.add("terzo");
		s1.add("quarto");
		s1.add("null");
		s1.add("quarto");
		
		for(String el : s1) {
			System.out.println(el);
		}
		
		System.out.println("----------------------");
		
		Iterator<String> i1 = s1.iterator();		
		while(i1.hasNext()) {
			System.out.println(i1.next());
		}
	}

}
