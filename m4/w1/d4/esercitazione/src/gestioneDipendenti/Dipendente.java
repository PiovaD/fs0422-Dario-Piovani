package gestioneDipendenti;

public class Dipendente {

	private static double stipendioBase = 1000;

	private int matricola;
	private double stipendio;
	private double importoOrarioStraordinario;

	private Livello livello;
	private Dipartimento dipartimento;

	private Dipendente() {
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
	}

	public Dipendente(int matricola, Dipartimento dipart) {
		this();
		this.matricola = matricola;
		this.dipartimento = dipart;
	}

	public Dipendente(int matricola, Dipartimento dipart, double impOraStraora, Livello livello) {
		this(matricola, dipart);
		this.importoOrarioStraordinario = impOraStraora;
		this.livello = livello;
		setStipendio();
	}

	private void setStipendio() {
		this.stipendio = stipendioBase * this.livello.getMoltip();
	}

	public void setDipartimento(Dipartimento dip) {
		this.dipartimento = dip;
	}

	public void setImportoOrarioStraordinario(double IoS) {
		this.importoOrarioStraordinario = IoS;
	}

	public int getMatricola() {
		return this.matricola;
	}

	public double getStipendio() {
		return this.stipendio;
	}

	public double getImportoOrarioStraordinario() {
		return this.importoOrarioStraordinario;
	}

	public Livello getLivello() {
		return this.livello;
	}

	public Dipartimento getDipartimento() {
		return this.dipartimento;
	}

	public void printData() {
		System.out.printf(
				"Matricola: %s %n" + "Stipendio: %s %n" + "Importo Straordinario: %s %n" + "Livello: %s %n"
						+ "Dipartimento: %s %n",
				this.matricola, this.stipendio, this.importoOrarioStraordinario, this.livello, this.dipartimento);
	}

	public void promuovi() {

		switch (this.livello) {
		case OPERAIO:
			this.livello = Livello.IMPIEGATO;
			break;
		case IMPIEGATO:
			this.livello = Livello.QUADRO;
			break;
		case QUADRO:
			this.livello = Livello.DIRIGENTE;
			break;
		case DIRIGENTE:
			System.err.println("L'utente ha raggiunto il massimo livello della sua carriera");
			break;
		}

		setStipendio();
	}

	public static double calcolaPaga(Dipendente dipendente) {
		return dipendente.stipendio;
	}

	public static double calcolaPaga(Dipendente dipendente, int oreStraordinario) {
		return (dipendente.stipendio + (dipendente.importoOrarioStraordinario * oreStraordinario));
	}

}
