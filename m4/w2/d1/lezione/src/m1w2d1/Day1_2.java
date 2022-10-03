package m1w2d1;

public class Day1_2 {

	public static void main(String[] args) {

		int x = 10;
		int y = 0;

		try {
			if (y > 0) {

				System.out.println(x / y);

			} else {
				DivisionByNegativeException exc = new DivisionByNegativeException("Divisioni non accettano 0");
				System.out.println(exc.getExcGenerated());
				throw exc;

			}

		} catch (DivisionByNegativeException e) {
			System.out.println(e);
		}

		try {
			m1();
		} catch (Exception e) {
			
			
		}
		
		try {
			m2();
		} catch (EpicodeException e) {
			e.printStackTrace();
			
		}finally {
			System.out.println("finally eseguito");
		}
	}

	public static void m1() throws EpicodeException {
		int x = 10;
		if (x == 10) {
			//try {
			//	System.out.println("...");
				throw new EpicodeException("epicode magic");
			//} catch (EpicodeException exc) {

			//}
		}
	}
	
	public static void m2() throws EpicodeException{
		m3();
	}
	
	public static void m3() throws EpicodeException{
		m4();
	}
	
	public static void m4() throws EpicodeException{
		throw new EpicodeException("epicode errore");
	}

}

class DivisionByNegativeException extends ArithmeticException {

	private static int excGenerated = 0;

	public DivisionByNegativeException(String message) {
		super(message);
		excGenerated++;
	}

	public int getExcGenerated() {
		return excGenerated;
	}
}

class EpicodeException extends Exception {
	public EpicodeException(String message) {
		super(message);
	}
}
