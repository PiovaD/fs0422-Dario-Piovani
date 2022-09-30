package week1_day4.animals;

public class Dog extends Animal {

	public Dog(String n, int a) {
		super(n, a);
	}
	
	public void hello() {
		System.out.println( this.name );
		this.m1();
	}
	
	// overloading
	public void m2(boolean x) {
		System.out.println( "sono m2 di Dog" );
	}
	
	@Override
	public void m3() {
		super.m3();
		System.out.println( "sono m3 di Dog" );
	}
	
}
