package m1w2d1;

public class Da1_4 {

	public static void main(String[] args) {

		String n = "la";
		int a = 100;
		
		Student s1 = StudentMaker.make(a, n);
		
		System.out.println(s1.getDescription());
	}
}
