package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Str2 {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>(Arrays.asList("epicode", "java", "back-end"));

		boolean allElementContainsA = words.stream()
				.allMatch(s -> s.contains("a"));
		
		System.out.println(allElementContainsA);

		System.out.println(Stream.<Integer>builder()
				.add(10)
				.add(8)
				.add(50)
				.add(6)
				.add(2)
				.build()
				.noneMatch(n -> n < 0));
		
		Predicate<Student> promosso = (s -> s.getAvg() > 6);
		System.out.println(Stream.<Student>builder()
				.add(new Student("Mario", new int[] { 8, 6, 4, 7 }))
				.add(new Student("Luigi", new int[] { 3, 6, 4, 5 }))
				.add(new Student("Daisy", new int[] { 8, 6, 9, 5 }))
				.add(new Student("Peach", new int[] { 2, 2, 4, 1 }))
				.build()
				.anyMatch(promosso)
		);
		
		//------------
		

        List<Integer> nums = new ArrayList<>( Arrays.asList( 5, 4, 10, 5 ) );
        int initialValue = 0;
        System.out.println( nums.stream().reduce(
                initialValue,
                ( currentValue, nextValue ) -> currentValue + nextValue )
        );

        List<String> words3 = new ArrayList<>( Arrays.asList( "mela", "banana", "kiwi", "mandarino" ) );
        System.out.println( words3.stream().reduce(
                "valore iniziale",
                ( currentValue, nextValue ) -> currentValue + " | " + nextValue ) + " | end" );

        List<Student> students = new ArrayList<>( Arrays.asList(
                new Student( "adiener", new int[] { 10, 5, 6, 9 } ),
                new Student( "marco", new int[] { 10, 5, 6, 9 } ),
                new Student( "manuel", new int[] { 10, 5, 6, 9 } ),
                new Student( "rocco", new int[] { 10, 5, 6, 9 } )
        ) );

        students
                .stream()
                .map( s -> s.votes[ 0 ] )
                .collect( Collectors.toCollection( ArrayList::new ) )
                .forEach( s -> System.out.println( s ) );


        System.out.println( words.stream().collect( Collectors.joining( " | ", "**", "**")));

	}

}
