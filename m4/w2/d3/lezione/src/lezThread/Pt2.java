package lezThread;

public class Pt2 {

	public static void main(String[] args) {
		ThreadBox t1 = new ThreadBox("th_a");
		ThreadBox t2 = new ThreadBox("th_b");

		t1.start();
		t2.start();

		for (int i = 0; i < 10; i++) {
			System.out.println(
					"id: " + Thread.currentThread().getId() + '|' + Thread.currentThread().getName() + " -> " + i);
		}
	}

}

class ThreadBox extends Thread {

	ThreadBox(String name) {
		this.setName(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(
					"id: " + Thread.currentThread().getId() + '|' + Thread.currentThread().getName() + " -> " + i);
		}
	}
}
