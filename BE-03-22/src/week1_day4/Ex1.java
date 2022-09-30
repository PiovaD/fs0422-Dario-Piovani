package week1_day4;

public class Ex1 {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		System.out.println( s1.getName() + " " + s1.getAge() + " " + s1.getGender() );
		
		s1.setAge(100);
		s1.setName("luigi");
		
		System.out.println( s1.getName() + " " + s1.getAge() );
		
		Student s2 = new Student( "daisy", 34 );
		s2.hello();
		
		// s2.printError("ciao");
		
		//Student s2 = new Student(10);
		Student s3 = Student.makeAnotherStudent( 10 );
		s3.hello();
		
		Student s4 = new Student("mario", 58, "Via qualcosa, Milano", StudentGender.M);
		
		s4.m1();
		s4.m1(10);
		s4.m1(10L);
		s4.m1( (byte)10 );
		s4.m1( new Object() );
		s4.m1( new Student() );
		s4.m1( s2 );
		
		System.out.println( s4.getGender() );

	}

}
