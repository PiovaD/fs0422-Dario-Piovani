package gestioneDipendenti;

public enum Livello {
	OPERAIO(1),
	IMPIEGATO(1.2),
	QUADRO(1.5),
	DIRIGENTE(2);
	
	private double moltipPaga;

	private Livello(double moltipPaga) {
		this.moltipPaga = moltipPaga;
	}

	public double getMoltip() {
		return moltipPaga;
	}
}
