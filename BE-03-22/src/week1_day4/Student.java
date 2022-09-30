package week1_day4;

public class Student {

	private String name;
	private String lastname;
	private int age;
	private String address;
	private StudentGender gender;
	
	// costruttore
	public Student() {
		this("unknown", 0, "unknown", StudentGender.X);
	}
	
	public Student(String n, int a) {
		this(a);
		this.setName(n);
	}
	
	public Student(String n, int a, String addr, StudentGender g) {
		this(n, a);
		this.setAddress(addr);
		this.setGender(g);
	}

	private Student(int a) {
		this.setAge(a);
	}
	
	// getter
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public StudentGender getGender() {
		return this.gender;
	}
	
	// setter
	public void setAge(int a) {
		if( a > 0 && a < 120 ) {			
			this.age = a;
			return;
		}
		
		this.printError("L'età è errata!");
	}
	
	public void setName(String n) {
		if( n.length() > 1 ) {
			this.name = n;
			return;
		}
		
		this.printError("Il nome è errato!");
	}
	
	public void setAddress(String addr) {
		this.address = addr;
	}
	
	public void setGender(StudentGender g) {
		this.gender = g;
	}
	
	// metodi
	public void hello() {
		System.out.printf( "Ciao, sono lo studente '%s' e ho %d anni %n", this.name, this.age );
	}
	
	public static Student makeAnotherStudent( int a ) {
		Student s = new Student( a );
		return s;
	}
	
	// metodi interni
	private void printError(String msg) {
		System.out.println( msg );
	}
	
	public void m1() {
		System.out.println( "hai chiamato m1 senza parametri" );
	}
	
	public void m1(int x) {
		System.out.println( "hai chiamato m1 con i parametri (int)" );
	}
	
	public void m1(long x) {
		System.out.println( "hai chiamato m1 con i parametri (long)" );
	}
	
	public void m1(byte x) {
		System.out.println( "hai chiamato m1 con i parametri (byte)" );
	}
	
	public void m1(Object o) {
		System.out.println( "hai chiamato m1 con i parametri (Object)" );
	}
	
	public void m1(Student o) {
		System.out.println( "hai chiamato m1 con i parametri (Student)" );
	}
	
}
