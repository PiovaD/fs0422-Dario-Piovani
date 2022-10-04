package lezionew2d2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueLez {

	public static void main(String[] args) {

		PriorityQueue<Integer> q1 = new PriorityQueue<>(10, new Q1Comparator());
		
		q1.add(4);
		q1.add(8);
		q1.add(2);
		q1.add(5);
		q1.add(4);
		
		System.out.println(q1);
	}

}

class Q1Comparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

		return o1 - o2;
	}

}