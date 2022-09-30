package week1_day4.animals;

public abstract class Animal {

	protected String name;
	protected int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	protected void m1() {
		System.out.println( "sono m1 di Animal" );
	}
	
	public void m2() {
		System.out.println( "sono m2 di Animal" );
	}
	
	public void m3() {
		System.out.println( "sono m3 di Animal" );
	}
	
	@Override
	public String toString() {
		return "Ciao, sono un Animal e mi chiamo " + name + " e ho " + age + " anni";
	}
	
}
