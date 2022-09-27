
public class esercizioStudente {

	public static void main(String[] args) {
		
		Studente s1 = new Studente();
		Studente s2 = new Studente();
		Studente s3 = new Studente();
		
		System.out.println(s1.matricola + " " + s2.matricola + " " + s3.matricola);
		
		
	}
	
}

class Studente{
	int matricola;
	String nome;
	String cognome;
	byte[] voti;
	static int id = 0;
	
	Studente(){
		matricola=id++;
	}
	
	double stampaMedia() {
		int sum = 0;
		
		for(int value : this.voti) {
			sum += value;
		}
		
		System.out.println( sum / voti.length);
		
		return sum / voti.length;
	}
}
