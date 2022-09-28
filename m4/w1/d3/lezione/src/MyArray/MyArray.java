package MyArray;

public class MyArray {
	int[] arr;

	MyArray(int length) {
		this.arr = new int[length];
	}

	public MyArray(int[] firstArr) {
		this.arr = firstArr;
	}

	public void push(int val) {
		int[] tmp = new int[this.arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			tmp[i] = this.arr[i];
		}

		tmp[tmp.length - 1] = val;

		this.arr = tmp;
	};

	public void shift(int val) {
		int[] tmp = new int[this.arr.length + 1];

		for (int i = 1; i < arr.length + 1; i++) {
			tmp[i] = this.arr[i - 1];
		}

		tmp[0] = val;

		this.arr = tmp;
	};

	public void pop() {
		int[] tmp = new int[this.arr.length - 1];

		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = this.arr[i];
		}

		this.arr = tmp;
	};

	public void unshift() {
		int[] tmp = new int[this.arr.length - 1];

		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = this.arr[i + 1];
		}

		this.arr = tmp;
	};
	
	public void print() {
		for(int elem : this.arr) {
			System.out.printf(elem + " ");
		}
		System.out.println();
	}

	
}
