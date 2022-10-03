package esercizio3;

/* Esercizio #3
DATE LE SEGUENTI CLASSI

Creare un nuovo tipo di eccezione: la classe BancaException sottoclasse della classe Exception avente l’attributo message di tipo stringa. Scrivere il costruttore con un parametro di tipo stringa, dopo aver richiamato il costruttore della superclasse passando il parametro impostare il valore
dell’attributo message uguale al parametro. Ridefinire il metodo toString che restituisce un stringa, il metodo restituisce il valore di message.

Modificare il metodo preleva della classe ContoCorrente in modo che se saldo dopo la sottrazione è minore di zero il metodo lancia una eccezione di tipo BancaException istanziando l’eccezione con la stringa “il conto è in rosso” ed aumentando comunque il contatore dei movimenti.

Modificare il metodo preleva della sottoclasse ContoOnLine in modo che se x>maxPrelievo viene lanciata una eccezione di tipo BancaException istanziando l’eccezione con la stringa “il prelievo non è disponibile”.

Modificare la classe Banca in modo da catturare l’eccezione di tipo BancaException e stampare l’errore ogni volta che si richiama il metodo preleva*/

public class Banca {
	public static void main(String args[]) {
		ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);

		System.out.println("Saldo conto: " + conto1.restituisciSaldo());

		try {
			conto1.preleva(1750.5);

			System.out.println("Saldo conto: " + conto1.restituisciSaldo());
		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}

		ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 50350.0, 1500);

		conto2.stampaSaldo();

		try {
			conto2.preleva(2000);
			conto2.stampaSaldo();

		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}
	}
}
