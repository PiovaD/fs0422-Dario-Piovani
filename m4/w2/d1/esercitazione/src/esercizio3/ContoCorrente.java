package esercizio3;

/*Modificare il metodo preleva della classe ContoCorrente in modo che se saldo dopo la sottrazione è minore di zero il metodo lancia una eccezione di tipo BancaException istanziando l’eccezione con la stringa “il conto è in rosso” ed aumentando comunque il contatore dei movimenti.*/

public class ContoCorrente {
	String titolare;
	int nMovimenti;
	final int maxMovimenti = 50;
	double saldo;

	ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	void preleva(double x) throws BancaException {
	
		if (nMovimenti < maxMovimenti) {
			saldo = saldo - x;
		} else {
			saldo = saldo - x - 0.50;
		}
		nMovimenti++;
		
		if(saldo < 0 ) throw new BancaException("Conto in rosso");		

	}

	double restituisciSaldo() {
		return saldo;
	}
}
