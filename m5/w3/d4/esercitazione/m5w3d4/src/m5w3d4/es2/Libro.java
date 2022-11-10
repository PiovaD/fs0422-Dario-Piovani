package m5w3d4.es2;

import java.util.List;
import java.util.stream.Collectors;

public class Libro {

	private String titolo;
	private Double prezzo;
	private List<String> autori;
	private List<ComponenteLibro> listaComponenti;

	public void stampa() {
		System.out.println("Libro: " + titolo);
		listaComponenti.forEach(com -> com.stampa());
	}

	public Double getPrezzo() {
		return this.prezzo;
	}

	public List<String> getAutori() {
		return this.autori;

	}

	public int getNumeroPagine() {
		Integer numeroPagine = getListaComponenti().stream()
				.collect(Collectors.summingInt(ComponenteLibro::getNumeroPagine));
		return numeroPagine;
	}

	public List<ComponenteLibro> getListaComponenti() {
		return listaComponenti;
	}

	public void setListaComponenti(List<ComponenteLibro> listaComponenti) {
		this.listaComponenti = listaComponenti;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public void setAutori(List<String> autori) {
		this.autori = autori;
	}
}
