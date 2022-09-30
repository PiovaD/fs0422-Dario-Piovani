package week1_day4;

public abstract class Person implements Jumpable, Runnable {

	String name;
	int age;
	
	public Person(String n, int a) {
		this.name = n;
		this.age = a;
	}
	
	public static void main(String[] args) {
		
		Jumpable p1 = new Programmatore("luigi", 20);
		p1.jump();
		p1.jump(40);
		p1.jumpHorizontally();
		((Programmatore)p1).run();
		
	}

	@Override
	public void jump() {
		System.out.println( name + " sta saltando" );
	}

	@Override
	public void jump(int cm) {
		this.jump();
		System.out.println( cm + " centimetri" );
	}

	@Override
	public void jumpHorizontally() {
		this.jump();
		System.out.println(" orizzontalmente");
	}

	/*
	@Override
	public void run() {
		System.out.println( name + " sta correndo" );
	}
	*/
	
	public abstract void m1();

}


class Programmatore extends Person {
	
	public Programmatore(String n, int a) {
		super(n, a);
	}
	
	@Override
	public void run() {
		System.out.println( name + " sta correndo" );
	}
	
	@Override
	public void m1() {
		System.out.println( "m1" );
	}
}
