package m5w3d4.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sezione extends ComponenteLibro {

	private String titoloSezione;
	private List<ComponenteLibro> listaComponenti = new ArrayList<ComponenteLibro>();

	public Sezione(String titoloSezione) {
		this.titoloSezione = titoloSezione;
	}
	
	public void addListaC(ComponenteLibro c) {
		this.listaComponenti.add(c);
	}

	@Override
	public void stampa() {
		System.out.println("Sezione: " + titoloSezione);
		listaComponenti.forEach(com -> com.stampa());
	}

	@Override
	public int getNumeroPagine() {
		Integer numeroPagine = listaComponenti.stream()
				.collect(Collectors.summingInt(ComponenteLibro::getNumeroPagine));
		return numeroPagine;
	}

}
