package m1w2d1;

public class Day1 {

	public static void main(String[] args) {
		//m1();

		String s = null;

		try {
			try {
				System.out.println(10 / 0);

				//int[] numbers = { 1, 2, 3, 4 };
				//System.out.println(numbers[5]);
				//System.out.println(s.length());

			} catch (NullPointerException exc) {

				System.out.println("Stringa è null");

			} catch (IndexOutOfBoundsException exc) {

				System.out.println("Out of bound");

			}
		} catch (Exception exc) {

			System.out.println("errore generico");
		}

	}

	static void m1() {

		int[] numbers = { 1, 2, 3, 4 };

		try {
			System.out.println(numbers[5]);
		} catch (Exception exc) {
			System.err.println("here " + exc.getMessage());
			exc.printStackTrace();
		}
	}

}
