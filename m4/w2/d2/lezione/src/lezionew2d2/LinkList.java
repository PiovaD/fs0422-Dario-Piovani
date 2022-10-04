package lezionew2d2;

import java.util.LinkedList;

public class LinkList {
	public static void main(String[] args) {

		LinkedList<String> l1 = new LinkedList<>();

		l1.add("Hello");
		l1.add("world");
		l1.add("!");

		l1.addFirst("Terminal:");
		l1.addLast("/n");

		System.out.println(l1);

		for (int i = 0; i < l1.size(); i++) {
			//System.out.print(l1.get(i) + " ");
		}
		
		System.out.println();
		
		String firstElement = l1.peek();		
		System.out.println(firstElement);
		
		int s  = l1.size();
		
		for(int i = 0; i < s; i++) {
			System.out.println("ho rimosso \"" + l1.pollFirst() + "\"");
			System.out.println("Situazione attuale " + l1 );
			System.out.println("--------------------------------------");
		}

	}
}
