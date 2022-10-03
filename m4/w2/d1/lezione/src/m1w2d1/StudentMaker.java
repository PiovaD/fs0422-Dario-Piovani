package m1w2d1;

public class StudentMaker {
	
	public static Student make(int a, String n) {
		if (n.length() < 2) {
			throw new StudentNameException("nome corto");
			
		} else if (a < 1 || a > 100) {
			throw new StudentAgeException("età errata");
			
		}
		
		return new Student (n,a);
	}
}
