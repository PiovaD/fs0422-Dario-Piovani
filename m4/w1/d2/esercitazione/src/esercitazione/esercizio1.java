package esercitazione;

public class esercizio1 {

	public static void main(String[] args) {
		
		Rettangolo r1 = new Rettangolo(5,7);
		Rettangolo r2 = new Rettangolo(6,8);
		
		r1.stampaRettangolo();
		r2.stampaRettangolo();
		
		Rettangolo.stampaDueRettangoli(r1, r2);

	}

}

class Rettangolo {
	int altezza;
	int larghezza;

	public Rettangolo(int altezza, int larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	};

	int perimetro() {
		return (altezza + larghezza) * 2;
	};

	int area() {
		return altezza * larghezza;
	}
	
	void stampaRettangolo() {
		System.out.println("Area: " + area());
		System.out.println("Perimetro: " + perimetro());
	};
	
	static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
		System.out.println("Primo: ");
		r1.stampaRettangolo();
		System.out.println("Secondo: ");
		r2.stampaRettangolo();
		
		System.out.println("Somma perimetro: " + (r1.perimetro() + r2.perimetro()));
		System.out.println("Somma area: " + (r1.area() + r2.area()));
	};

}