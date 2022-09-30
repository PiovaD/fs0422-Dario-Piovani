package week1_day4.animals;

final public class Chiwawa extends Dog {
	
	private int price;

	public Chiwawa(String n, int a, int p) {
		super(n, a);
		this.price = p;
	}
	
	public void printPrice() {
		System.out.println( this.price );
	}

}
