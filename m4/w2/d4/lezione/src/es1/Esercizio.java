package es1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Esercizio {
	public static void main(String[] args) {

		// es1
		Predicate<String> isPalindrom = (s) ->
			{
				String reverse = new StringBuilder(s).reverse()
						.toString();
				return s.equals(reverse) ? true : false;
			};

		// es2
		Function<String, Character> lastChar = (s) -> s.charAt(s.length() - 1);

		System.out.println(isPalindrom.test("itopinonavevanonipoti"));
		System.out.println(lastChar.apply("sdjhgb"));

		// es3
		Math add = (x, y) -> x + y;
		Math times = (x, y) -> x * y;
		Math divide = (x, y) -> x / y;
		Math addAndTime = (x, y) -> add.run(x, y) * times.run(x, y);

		System.out.println(add.run(4, 6));
		System.out.println(times.run(4, 6));
		System.out.println(divide.run(4, 6));
		System.out.println(addAndTime.run(4, 6));

		// es4

		List<Integer> num = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			num.add(new Random().nextInt(100));
		}

		num.stream()
				.filter(n -> n > 20)
				.forEach(System.out::println);

		List<Integer> numMagg = num.stream()
				.filter(n -> n > 20)
				.collect(Collectors.toCollection(ArrayList::new));

		System.out.println(numMagg);

	}
}

@FunctionalInterface
interface Math {
	double run(double x, double y);
}