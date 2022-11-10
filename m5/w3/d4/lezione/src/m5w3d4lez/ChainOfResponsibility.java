package m5w3d4lez;

/*
Esercizio #3 (chain of responsibility)
Realizzare le classi che modellano la seguente gerarchia militare (dal più basso al più alto):
- Capitano
- Maggiore
- Tenente
- Colonnello
- Generale
Valgono le seguenti regole:
- Ogni ufficiale conosce il proprio responsabile.
- Ogni ufficiale svolge una funzione diversa
- Ogni ufficiale ha uno stipendio diverso
- Ogni ufficiale è collocato gerarchicamente in modo diverso
Gli ufficiali percepiscono i seguenti stipendi:
- Capitano: 1000
- Maggiore: 2000
- Tenente: 3000
- Colonnello: 4000
- Generale: 5000
Si realizzi il client, utilizzando il pattern "Chain of responsibility", che dato un importo verifichi quale ufficiale percepisce almeno tale importo partendo dal capitano.
*/

public class ChainOfResponsibility {

	public static void main(String[] args) {
		
		Capitano cap = new Capitano();

		Maggiore mag = new Maggiore();

		Tenente ten = new Tenente();

		Colonnello col = new Colonnello();

		Generale gen = new Generale();
		
		
		cap.setSuperiore(mag);
		
		mag.setSuperiore(ten);

		ten.setSuperiore(col);

		col.setSuperiore(gen);
		
		
		cap.testStipendio(1000);
	}

}
