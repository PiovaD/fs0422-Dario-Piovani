package lambda;

@FunctionalInterface
interface StringOperation {
	String start(String s);
}

public class Lam2 {

	public static void main(String[] args) {
		//implementazione
		StringOperation uc = (s) -> s.toUpperCase();
		StringOperation lc = (s) -> s.toLowerCase();
		StringOperation reverseOperation = (s) -> {
			String s2 = "";
			for (int i = s.length() - 1; i >= 0; i--) {
				s2 += s.charAt(i);

			}

				return s2;
			};

		// utilizzo
		System.err.println(uc.start("java"));
		System.err.println(reverseOperation.start("JavA"));
		doStringOperation(lc, "JAVA");
		doStringOperation(uc, "java");

	}

	public static void doStringOperation(StringOperation op, String s) {
		System.out.println(op.start(s));
	}
}
