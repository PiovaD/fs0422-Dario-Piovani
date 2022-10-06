package lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class predic {

	public static void main(String[] args) {
		Predicate<Integer> greaterThanZero = (n) -> n > 0;
		Predicate<Integer> isEven = (n) -> n % 2 == 0;

		System.out.println(greaterThanZero.test(10));
		System.out.println(greaterThanZero.test(-10));

		tests(isEven, 8);

		tests((n) -> n % 2 != 0, 3);

		// function

		Function<String, Integer> fn1 = (s) -> s.length();
		Function<Integer, Integer> fn2 = (s) -> s * 2;

		System.out.println("La length della stringa è: " + fn1.apply("java"));
		applayFn(fn1, "java");
		applayFn((s) -> s.length() + 10, "java");

		System.out.println(fn1.andThen(fn2)
				.apply("java"));
	}

	public static void tests(Predicate<Integer> testType, int n) {
		System.out.println("Risultato: " + testType.test(n));
	}

	public static void applayFn(Function<String, Integer> fn, String s) {
		System.out.println("Applay fn: " + fn.apply(s));
	}
}
