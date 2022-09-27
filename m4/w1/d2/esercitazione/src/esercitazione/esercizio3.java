package esercitazione;

import java.util.Date;

public class esercizio3 {
	public static void main(String[] args) {

		Cliente c = new Cliente("Paolo", "Rossi", "jksab@sdas.com");

		Articolo a1 = new Articolo("Maglia", 10, 2);
		Articolo a2 = new Articolo("Pantalone", 25, 1);
		Articolo a3 = new Articolo("Scarpe", 50, 50);

		Carrello cart = new Carrello(c);

		cart.addArticle(a1);
		cart.addArticle(a2);
		cart.addArticle(a2);
		cart.addArticle(a3);
		cart.addArticle(a3);

		cart.printCarrello();
	}
}

class Articolo {

	int codArt;
	String infoArt;
	double price;
	int unit;

	static int count = 0;

	Articolo(String infoArt, double price, int unit) {
		this.codArt = count++;
		this.infoArt = infoArt;
		this.price = price;
		this.unit = unit;
	}

	void print() {
		System.out.println("Cliente: " + infoArt);
		System.out.println("Prezzo: " + price);

	}

}

class Cliente {
	int codCliente;
	String name;
	String lastName;
	String email;
	Date dataSub;

	static int count = 0;

	Cliente(String name, String lastName, String email) {
		this.codCliente = count++;

		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.dataSub = new Date();

	}

	void printCliente() {
		System.out.println("Nome: " + name);
		System.out.println("Cognome: " + lastName);
	}
}

class Carrello {

	Cliente clienteAssociato;
	Articolo[] stack = {};
	double tot;

	Carrello(Cliente clienteAssociato) {
		this.clienteAssociato = clienteAssociato;
	}

	void addArticle(Articolo art) {

		if (art.unit > 0) {

			art.unit--;

			Articolo[] tmp = new Articolo[this.stack.length + 1];

			tmp[0] = art;

			tot = art.price;

			for (int i = 0; i < stack.length; i++) {
				tmp[i + 1] = stack[i];

				tot += stack[i].price;
			}

			this.stack = tmp;

		} else {
			System.err.println("finito");
		}
	}

	void printCarrello() {
		System.out.println("Cliente: ");
		this.clienteAssociato.printCliente();

		System.out.println("Contenuto: ");
		for (Articolo art : stack) {
			art.print();
		}

		System.out.println("Tot: " + this.tot);
	}

}
