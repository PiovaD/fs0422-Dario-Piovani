package esercizio3;

/*Modificare il metodo preleva della sottoclasse ContoOnLine in modo che se x>maxPrelievo viene lanciata una eccezione di tipo BancaException istanziando l’eccezione con la stringa “il prelievo non è disponibile”.*/

public class ContoOnLine extends ContoCorrente {
	double maxPrelievo;

	ContoOnLine(String titolare, double saldo, double maxP) {
		super(titolare, saldo);
		this.maxPrelievo = maxP;
	}

	void stampaSaldo() {

		System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
				+ " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
	}

	void preleva(double x) throws BancaException {
		if (x > maxPrelievo) {
			throw new BancaException("Il prelievo non è disponibile");
		}else{
			super.preleva(x);
		}
	}
}
