package week1_day4;

import week1_day4.animals.Chiwawa;
import week1_day4.animals.Animal;
import week1_day4.animals.Dog;
import week1_day4.animals.Cat;

public class Ex2 {

	public static void main(String[] args) {
		
		Dog d1 = new Dog( "fuffy", 8 );
		d1.hello();
		d1.m2();
		d1.m2(true);
		d1.m3();
		
		System.out.println("--------------------");
		
		Chiwawa c1 = new Chiwawa("ciao", 5, 1000);
		c1.m3();
		c1.m2(true);
		c1.printPrice();
		
		Animal a1 = new Dog( "fuffy", 10 );
		
		a1 = new Cat("miao", 5);
		
		System.out.println("--------------------");
		
		getAnimal( d1 );
		getAnimal( new Cat("felix", 3) );
		
		System.out.println("--------------------");
		
		Animal a2 = new Chiwawa( "fuffy", 5, 10 );
		((Chiwawa)a2).printPrice();
		
		System.out.println("--------------------");
		
		Animal[] animals = { d1, new Cat("felix", 3), a2 };
		
		for( Animal currentAnimal : animals ) {
			
			if( currentAnimal instanceof Chiwawa ) {				
				((Chiwawa)currentAnimal).printPrice();
			}
		}
		
		System.out.println( "ciao sono una stringa " + d1 + " qualcosa" );
		
		//Animal a5 = new Animal();
		
	}
	
	public static void getAnimal(Animal a) {
		System.out.println( a );
	}

}

class Ex2_2 extends Ex2 {}
