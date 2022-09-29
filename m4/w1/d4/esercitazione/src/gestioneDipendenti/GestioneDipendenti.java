package gestioneDipendenti;


public class GestioneDipendenti {

	public static void main(String[] args) {
		Dipendente d1 = new Dipendente(1, Dipartimento.PRODUZIONE);
		Dipendente d2 = new Dipendente(2, Dipartimento.PRODUZIONE);
		Dipendente d3 = new Dipendente(3, Dipartimento.AMMINISTRAZIONE, 30,Livello.IMPIEGATO);
		Dipendente d4 = new Dipendente(4, Dipartimento.VENDITE, 30, Livello.DIRIGENTE);
		
		d1.promuovi();
		d3.promuovi();
		
		System.out.println("---- Dipendente 1 ----");
		d1.printData();
		System.out.println("---- Dipendente 2 ----");
		d2.printData();
		System.out.println("---- Dipendente 3 ----");
		d3.printData();
		System.out.println("---- Dipendente 4 ----");
		d4.printData();
		
		System.out.println("---- Paga con 5 ore di straordinario ----");
		System.out.println("Devi pagare " + sommaDipendenti(new Dipendente[]{d1,d2,d3,d4}, 5));
	}
	
	
	public static double sommaDipendenti(Dipendente[] dipArr , int oreStr) {
		double tot = 0;
		
		for(Dipendente dip : dipArr) {
			tot += Dipendente.calcolaPaga(dip, oreStr);
		}
		
		
		return tot;
	}

}
