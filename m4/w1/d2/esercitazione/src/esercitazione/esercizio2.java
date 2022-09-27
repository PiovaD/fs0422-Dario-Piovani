package esercitazione;

public class esercizio2 {

    public static void main(String[] args) {

	Sim s1 = new Sim(100000);

	s1.setCredit(25);

	s1.setCall(new Call[] { new Call(11211, 20.1), new Call(11010, 20.1), new Call(10010, 2.1),
		new Call(11010, 10.1), new Call(10011, 25.1) });

	s1.printaData();

    }

}

class Call {
    int numero;
    double durata;

    Call(int numero, double durata) {
	this.numero = numero;
	this.durata = durata;
    }

    void print() {
	System.out.println("Numer: " + numero + " -Durata: " + durata);
    }
}

class Sim {
    int numTel;
    double credito;
    Call[] lastCalls;

    Sim(int numTel) {
	this.numTel = numTel;
	this.credito = 0;
	this.lastCalls = new Call[5];
    }

    void printaData() {
	System.out.println("Numero: " + numTel);
	System.out.println("Credito: " + credito);

	for (Call call : lastCalls) {
	    System.out.printf("Chiamata: ");
	    call.print();
	}
    }

    void setCredit(int credit) {
	this.credito += credit;

    }

    void setCall(Call[] lastCalls) {
	this.lastCalls = lastCalls;

	for (Call call : this.lastCalls) {
	    double cost = call.durata * 0.20;
	    this.credito -= cost;
	}
    }

}